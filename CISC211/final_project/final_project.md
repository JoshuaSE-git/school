# Final Project (Counter)

## Task 2 (Functions and Recursions)

### Task 2 objective

Analyze the performance of function and recursion

Write a function (count) to perform the following task.

- Generate a counter (let's say 20,000) using the function. The function should have one integer argument (in this example, 20,000).
- Calculate the execution time of your code by using the [time command](https://en.wikipedia.org/wiki/Time_(Unix)) and redirect the output to the counter_fun.txt file.
- Append the counter in an already created text file (counter_fun.txt).

Use recursion to generate the same counter which you did above. [Check what is recursion](https://en.wikipedia.org/wiki/Recursion_(computer_science)) 

- Use the same function (count), but you will repeatedly call the same function (recursion) to generate the counter.
- Calculate the execution time of your code by using the [time command](https://en.wikipedia.org/wiki/Time_(Unix)) and redirect the output to the counter_rec.txt file.
- Append the counter in an already created text file (counter_rec.txt).
- Compare both the time and discuss which code (function or recursion) runs efficiently and why.

#### Output to display

- There should be two text files for this task. counter_fun.txt and counter_rec.txt
- Each file should have a time command output and a counter.

## counter_func.asm (non-recursive)

### Time command

Use this command to append timer to end of output file

```
(time ./run.sh counter_func) 2>&1 | tee >> counter_func.txt
```

```assembly
section .text
  global _start

_start:
  push DWORD[counter]                   ;push counter value as argument to _counter
  call _counter                         ;call _counter func

  mov eax, 1
  int 0x80

_counter:                               ;counter function
  push ebp                              ;initialize stack frame
  mov ebp, esp
  sub esp, 4
  mov eax, [ebp+8]
  mov [ebp-4], eax                      ;counter variable in stack
  
  mov [currentCounter], eax             ;initialize counter (starts at 20,000)

  mov eax, 8                            ;create new file and get file descriptor
  mov ebx, filename
  mov ecx, 0777o
  int 0x80

  mov [fd], eax                         ;move file descriptor to fd for easy access

  jmp outputLoop

outputLoop:                             ;starting point for counter loop
  mov eax, [currentCounter]             ;move current counter val to eax
  xor ecx, ecx                          ;clear ecx
  jmp pushLoop                          ;jump to inner pushLoop

pushLoop:                               ;pushing individual digits to stack (inner loop)
  mov ebx, 10
  xor edx, edx
  div ebx
  push edx
  inc ecx                               ;ecx stores length of current number
  cmp eax, 9
  jg pushLoop                           ;loop to push all digits to stack
  push eax
  inc ecx
  mov [printVarLen], ecx                ;move current number length to printVarLen
  jmp writeLoop                         ;after digits are done being pushed, we go to writeLoop

writeLoop:                              ;writing individual digits to file (inner loop)
  pop eax
  add eax, 48
  mov [printVar], eax                   ;printVar now has ascii converted digit

  mov eax, 4                            ;writing individual digit to output file
  mov ebx, [fd]
  mov ecx, printVar
  mov edx, 1
  int 0x80

  mov ecx, [printVarLen]                ;handle loop logic based on varLen (number length)
  dec ecx
  mov [printVarLen], ecx
  cmp ecx, 0                            ;if there are still more digits, we loop
  jg writeLoop 

  mov eax, 4                            ;after digits are written, we write a new line
  mov ebx, [fd]
  mov ecx, newLine     
  mov edx, 1
  int 0x80

  jmp continueOutputLoop                ;inner loops are done, jump back to outer loop logic

continueOutputLoop:                     ;continue outer loop logic
  mov eax, [currentCounter]
  dec eax
  mov [currentCounter], eax
  cmp eax, 0                            ;checks if current counter value is greater than 0
  jge outputLoop                        ;if >= 0, continue outer outputLoop
  jmp continueCounterFunc               ;if < 0, counter is done, now move to ending logic

continueCounterFunc:
  mov eax, 6                            ;close file
  mov ebx, [fd]
  int 0x80
  
  leave                                 ;clean-up stack
  ret                                   ;return to _start

section .bss
  fd resd 1
  printVar resd 1
  printVarLen resd 1
  currentCounter resd 1

section .data
  counter dd 20000
  filename db "counter_func.txt", 0h
  newLine db 0xA
```

## counter_rec.asm (recursive)

### Time command

Use this command to append timer to end of output file

```
(time ./run.sh counter_rec) 2>&1 | tee >> counter_rec.txt
```

```assembly
section .text
  global _start

_start:
  mov eax, 8                            ;create new file and get file descriptor
  mov ebx, filename
  mov ecx, 0777o
  int 0x80
  mov [fd], eax                         ;move file descriptor to fd for easy access

  push DWORD[counter]                   ;push counter value as argument to _counter
  call _counter                         ;call _counter func

  mov eax, 1
  int 0x80

_counter:                               ;counter function (prints single value instead of looping through counter)
  push ebp                              ;initialize stack frame
  mov ebp, esp
  sub esp, 4
  mov eax, [ebp+8]
  mov [ebp-4], eax                      ;counter variable in stack

  mov [currentCounter], eax             ;initialize counter (starts at 20,000)

  jmp output

output:                                 ;writing a number to file
  mov eax, [currentCounter]             ;move current counter val to eax
  xor ecx, ecx                          ;clear ecx
  jmp pushLoop                          ;jump to inner pushLoop

pushLoop:                               ;pushing individual digits to stack (inner loop)
  mov ebx, 10
  xor edx, edx
  div ebx
  push edx
  inc ecx                               ;ecx stores length of current number
  cmp eax, 9
  jg pushLoop                           ;loop to push all digits to stack
  push eax
  inc ecx
  mov [printVarLen], ecx                ;move current number length to printVarLen
  jmp writeLoop                         ;after digits are done being pushed, we go to writeLoop

writeLoop:                              ;writing individual digits to file (inner loop)
  pop eax
  add eax, 48
  mov [printVar], eax                   ;printVar now has ascii converted digit

  mov eax, 4                            ;writing individual digit to output file
  mov ebx, [fd]
  mov ecx, printVar
  mov edx, 1
  int 0x80

  mov ecx, [printVarLen]                ;handle loop logic based on varLen (number length)
  dec ecx
  mov [printVarLen], ecx
  cmp ecx, 0                            ;if there are still more digits, we loop
  jg writeLoop

  mov eax, 4                            ;after digits are written, we write a new line
  mov ebx, [fd]
  mov ecx, newLine
  mov edx, 1
  int 0x80

  jmp continueOutput                    ;writing number to file is done

continueOutput:
  mov eax, [currentCounter]
  dec eax
  mov [currentCounter], eax
  cmp eax, 0                            ;checks if current counter value is greater than 0
  jl endCounterFunc                     ;base case (counter < 0) - we end recursion

  push DWORD[currentCounter]            ;push (n-1) counter to stack
  call _counter                         ;call counter to continue recursion

endCounterFunc:
  mov eax, 6                            ;close file
  mov ebx, [fd]
  int 0x80

  leave                                 ;clean-up stack
  ret                                   ;return to _start

section .bss
  fd resd 1
  printVar resd 1
  printVarLen resd 1
  currentCounter resd 1

section .data
  counter dd 20000
  filename db "counter_rec.txt", 0h
  newLine db 0xA
```
## Results Comparison

counter_func.asm

```
real	0m0.151s
user	0m0.031s
sys	0m0.121s
```

counter_rec.asm (52% slower)

```
real	0m0.166s   
user	0m0.047s ~ 52% slower
sys	0m0.119s
```

## Discussion

When comparing the difference in results between my loop and recursion variations, we should use the "user" time as our metric.  The user time reflects the amount of CPU time spent by the program when executing user-level instructions, which is exactly what we should measure if we want to compare the two.  In contrast, both the real and system metrics factor in time spent executing system-level instructions like write, open, close, etc, which have nothing to do with recursion or loops.  Since both of my programs perform mostly system-level instructions, a majority of the "real" time will be occupied by systesm calls.

When comparing the user time, the recursion variation is about 52% slower which is expected.  The difference in speed comes from the numerious stack frames created by the recursion function.  Every time we call _counter with a decremented argument, we introdouce a new stack frame, which includes allocating space, copying arguments, and storing return addresses.  By comparison, the looping variation only generates a single stackframe and lets the loop handle decrementing the counter, this requires less operations per iteration.

## Flowchart
![image](https://github.com/user-attachments/assets/38066b2e-d2a2-4cd5-b55e-afb4979cd41f)


