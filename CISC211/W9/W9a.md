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

![image](https://github.com/user-attachments/assets/bb77a3ff-7312-430d-bddf-f207e68eacce)

