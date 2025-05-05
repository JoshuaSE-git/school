section .data
  num dd 27

  msgEven db "even", 0xA
  evenLen equ $ - msgEven
  msgOdd db "odd", 0xA
  oddLen equ $ - msgOdd

section .text
  global _start

_start:
  push DWORD [num]
  call _evenOrOdd

  mov eax, 1
  xor ebx, ebx
  int 0x80

_evenOrOdd:
  push ebp
  mov ebp, esp
  sub esp, 4
  mov eax, [ebp+8]
  mov [ebp-4], eax

  test eax, 1
  jz even
  jmp odd

even:
  push evenLen
  push msgEven
  jmp continueEvenOrOdd

odd:
  push oddLen
  push msgOdd
  jmp continueEvenOrOdd

continueEvenOrOdd:
  call _print
  leave
  ret

_print:
  push ebp
  mov ebp, esp

  mov ecx, [ebp+8]    ; msg pointer
  mov edx, [ebp+12]   ; msg length
  mov eax, 4
  mov ebx, 1
  int 0x80

  pop ebp
  ret
