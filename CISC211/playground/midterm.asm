section .text
  global _start

; result = (var1 + 2) / (var3  - var2)
; result = (398 + 2) / (30 - 25)
; result = 400 / 5
; result = 80

; ASCII 80 = 'P'

_start:

  mov eax, [var1]      ;move var1 inside eax
  add eax, 2           ;add 2 to eax (var1 + 2)
  mov ebx, eax         ;move eax value to ebx for storage
  
  mov eax, [var3]      ;move var3 inside eax
  sub eax, [var2]      ;subtract var2 from eax (var3 - var2)
  mov ecx, eax         ;move eax value to ecx for storage

  mov eax, ebx         ;move value inside ebx (var1 + 2) to eax
  div ecx              ;divide eax by ecx (var1 + 2) / (var3 - var2)
  mov [result], eax    ;move value inside eax (quotient = 80) to result variable

  mov eax, 4           ;move 4 inside eax (sys_write code)
  mov ebx, 1           ;move 1 inside ebx (stdout code)
  mov ecx, result      ;move pointer to result var inside ecx
  mov edx, 1           ;move 1 inside edx
  int 0x80             ;execute sys_write  (Should print 'P' to stdout)

  mov eax, 1           ;move 1 inside eax (sys_exit)
  int 0x80             ;execute sys_exit

section .bss
  result resd 1

section .data
  var1 dd 398
  var2 dd 25
  var3 dd 30

