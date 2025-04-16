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
