# W9-a Conditional Instructions

## Task

Perform the following tasks:

1. Generate a sequence of even or odd numbers up to 20. 
2. Find the largest number among the **five integer numbers**. Use initialize variables, and the output goes to the largest un-initialize variable. 

## Task 1 Solution
```assembly
section .text
  global _start

_start:
  mov eax, [val]
  cmp eax, 9
  jg pushNum             ;if val is 2 digit number, then we need to execute push/pop logic

  add eax, 48            ;otherwise, we do print logic for single digit val
  mov [printVar], eax
  call printNum
  call linefeed
  jmp continue           ;jump to loop logic

pushNum:                 ;push individual digits to stack, then pop and print
  mov ebx, 10
  xor edx, edx           ;clear edx register (set to 0)
  div ebx
  push edx
  push eax

  pop eax                ;pop and print from stack (ones place)
  add eax, 48
  mov [printVar], eax
  call printNum

  pop eax                ;pop and print from stack (tens place)
  add eax, 48            ;add 48 for ASCII representation of number
  mov [printVar], eax
  call printNum

  call linefeed          ;print line feed for new line

  jmp continue           ;go to loop logic

printNum:                ;print value inside printVar
  mov eax, 4
  mov ebx, 1
  mov ecx, printVar 
  mov edx, 1
  int 0x80
  ret

linefeed:                ;print linefeed using space variable (0xa)
  mov eax, 4
  mov ebx, 1
  mov ecx, space         ;0xa
  mov edx, 1
  int 0x80
  ret

continue:                ;add two to val, if val > 20 then exit, else continue loop
  mov eax, [val]
  add eax, 2
  cmp eax, 20
  jg exit
  mov [val], eax
  jmp _start

exit:                    ;exit program
  mov eax, 1
  int 0x80

section .bss
  printVar resd 1

section .data
  val dd 0
  space db 0xa

```
### Solution 1 Output
![image](https://github.com/user-attachments/assets/bb77a3ff-7312-430d-bddf-f207e68eacce)

## Task 2 Solution
```assembly
section .text
  global _start

_start:
  mov eax, [var1]   ;compare var1 and var2, greatest goes to eax
  cmp eax, [var2]
  jg label1
  mov eax, [var2]
  jmp label1

label1:             ;compare eax and var3, greatest goes to eax
  cmp eax, [var3]
  jg label2
  mov eax, [var3]
  jmp label2

label2:             ;compare eax and var4, greatest goes to eax
  cmp eax, [var4]
  jg label3
  mov eax, [var4]
  jmp label3

label3:             ;compare eax and var5, greatest goes to eax
  cmp eax, [var5]
  jg exit
  mov eax, [var5]
  jmp exit

exit:               ;print greatest val (eax)
  add eax, 48
  mov [result], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, result
  mov edx, 1
  int 0x80

  mov eax, 4         ;print newline
  mov ebx, 1
  mov ecx, space
  mov edx, 1
  int 0x80

  mov eax, 1
  int 0x80

section .bss
  result resd 1

section .data
  var1 dd 2
  var2 dd 4
  var3 dd 7
  var4 dd 4
  var5 dd 1
  space db 0xa
```
### Solution 2 Output
![image](https://github.com/user-attachments/assets/04a5a885-d0d8-4f2e-bbf5-c0b357bfc563)


## Lab Questions

Q: What were your challenges in performing the lab (from design to the implementation phases)? (1 mark)

A: The hardest part was breaking down the problem into smaller components.  For example, the even/odd task required us to increment numbers and print them to the screen, and each of those tasks require their own subtasks such as pushing/popping individual digits to/from the stack.  Managing that complexity in assembly was unfamiliar to me coming from a background in higher level languages such as Python.  I had to learn how to compose conditional logic, function calls, returns, and managing memory in an organized and efficient way.  In python these challenges are trivial, but since assembly is a low level language, I had to learn how to perform these functionalities in a completely different way.

