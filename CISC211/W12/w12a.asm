section .text
  global _start

_start:                     ;main function
  push DWORD[num]
  call _evenOrOdd

  mov eax, 1
  int 0x80

_evenOrOdd:                 ;determines even or odd and prints result
  push ebp
  mov ebp, esp              ;initializing stack frame
  sub esp, 4
  mov eax, DWORD[ebp+8]
  mov DWORD[ebp-4], eax

  test eax, 1               ;logic for even/odd
  jz even
  jmp odd

even:                       ;push evenMsg pointer and evenLen value to stack (arguments)
  push msgEven     
  push evenLen
  jmp continueEvenOrOdd     ;jmp back to next instruction in _evenOrOdd

odd:                        ;push oddMsg pointer and oddLen value to stack (arguments)
  push msgOdd
  push oddLen
  jmp continueEvenOrOdd     ;jmp back to next instruction in _evenOrOdd

continueEvenOrOdd:          ;continuation after conditional logic
  call _print

  leave
  ret

_print:                     ;print function with msg pointer and msg len as parameters
  push ebp
  mov ebp, esp
  sub esp, 8
  mov eax, DWORD[ebp+12]    ;initializing stack frame
  mov DWORD[ebp-4], eax
  mov eax, DWORD[ebp+8]
  mov DWORD[ebp-8], eax

  mov eax, 4                ;sys_write
  mov ebx, 1
  mov ecx, DWORD[ebp-4]     ;pointer to msg
  mov edx, DWORD[ebp-8]     ;value of msgLen
  int 0x80

  leave
  ret

section .data
  num dd 27

  msgEven db "The number is even.", 0xA
  evenLen equ $ - msgEven
  msgOdd db "The number is odd.", 0xA
  oddLen equ $ - msgOdd
