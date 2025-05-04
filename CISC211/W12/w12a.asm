section .text
  global _start

_start:
  mov eax, [num]
  push eax
  call _func

_func:
  push ebp
  mov ebp, esp
  sub esp, 4

  mov eax, DWORD[ebp+8]
  mov DWORD[ebp-4], eax

  test eax, 1
  jz even
  jmp odd

  leave
  ret

even:
  
  

section .data
  num dd 27

  msg db "Number "
