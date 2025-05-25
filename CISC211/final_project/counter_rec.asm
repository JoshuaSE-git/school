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

_counter:                               ;counter function
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
