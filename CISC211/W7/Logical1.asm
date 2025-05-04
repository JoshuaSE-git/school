section .text
  global _start

_start:

  mov eax, 256         ;move 256 into eax
  xor eax, eax         ;bitwise xor with eax and eax. sets zf flag if result is zero.
  jz zero              ;checks if zf flag is set, if so, jump to zero label

  mov eax, 4           ;move 4 (sys_write code) to eax
  mov ebx, 1           ;move 1 (stdout file descriptor) to ebx
  mov ecx, msgNonZero  ;move beginning memory address of msgNonZero to ecx
  mov edx, lenNonZero  ;move length of msgNonZero to edx
  int 0x80             ;execute sys call in eax

  mov eax, 1           ;move 1 (sys_exit code) to eax
  int 0x80             ;execute sys call in eax
  
zero:
  mov eax, 4           ;move 4 (sys_write code) to eax
  mov ebx, 1           ;move 1 (stdout file descriptor) to ebx
  mov ecx, msgZero     ;move beginning memory address of msgZero to ecx
  mov edx, lenZero     ;move length of msgZero to edx
  int 0x80             ;execute sys call in eax

  mov eax, 1           ;move 1 (sys_exit code) to eax
  int 0x80             ;execute sys call in eax

section .data
  msgZero db "eax register is zero.", 0xA
  lenZero equ $ - msgZero
  msgNonZero db "eax register is not zero.", 0xA
  lenNonZero equ $ - msgNonZero
