section .text
        global _start

_start:
  mov eax,10
  push eax
  mov eax,20
  pop eax

  mov eax,1
  int 0x80