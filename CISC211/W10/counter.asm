section .text
  global _start

_start:          ;initialize counter
  mov ebx, 0

counter:         ;counter loop
  inc ebx
  cmp ebx, 10
  jl counter 

  mov eax, 1     ;exit
  int 0x80
