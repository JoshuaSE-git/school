section .text
  global _start

_start:
  
  mov eax, [num]       ;mov value inside num (8) into eax
  test eax, 1          ;use test operation with eax and 1 to check even/odd. sets zero flag (zf)
  jz even              ;use jz operation to jump to "even" label if zf is set to 1 (number is even)

  mov eax, 4           ;mov 4 inside eax (sys_write code)
  mov ebx, 1           ;mov 1 inside ebx (stdout code)
  mov ecx, oddMsg      ;move oddMsg pointer inside ecx
  mov edx, oddLen      ;move oddLen value inside edx
  int 0x80             ;execute sys_write

  mov eax, 1           ;mov 1 inside eax (sys_exit)
  int 0x80             ;execute sys_exit

even:

  mov eax, 4           ;mov 4 inside eax (sys_write code)
  mov ebx, 1           ;mov 1 inside ebx (stdout code)
  mov ecx, evenMsg     ;move evenMsg pointer inside ecx
  mov edx, evenLen     ;move evenLen value inside edx
  int 0x80             ;execute sys_write

  mov eax, 1           ;mov 1 inside eax (sys_exit)
  int 0x80             ;execute sys_exit

section .data
  num dd 8

  evenMsg db "even number", 0xA
  evenLen equ $ - evenMsg

  oddMsg db "odd number", 0xA
  oddLen equ $ - oddMsg

