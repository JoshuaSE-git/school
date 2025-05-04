section .text
  global _start

_start:
  mov eax, 256       ;move 256 into eax register
  mov ebx, 12        ;move 12 into ebx register
  mul ebx            ;multiply eax by ebx and store result in eax

  test eax, 1        ;performs AND with eax and 1 (checks if eax is even/odd), does not overwrite eax register
  mov [result], eax  ;since eax retains value after test, result will hold correct value
  jz even            ;jumps to even label if zf is set to 1 (test instruction sets zf if eax was even)

  mov eax, 4         ;move 4 (sys_write code) to eax
  mov ebx, 1         ;move 1 (stdout file descriptor) to ebx
  mov ecx, msgOdd    ;move beginning address of msgOdd to ecx
  mov edx, lenOdd    ;move length of msgOdd to edx
  int 0x80           ;execute syscall in eax

  mov eax, 1         ;move 1 (sys_exit code) to eax
  int 0x80           ;execute syscall in eax

even:
  mov eax, 4         ;move 4 (sys_write code) to eax
  mov ebx, 1         ;move 1 (stdout file descriptor) to ebx
  mov ecx, msgEven   ;move beginning address of msgEven to ecx
  mov edx, lenEven   ;move length of msgEven to edx
  int 0x80           ;execute syscall in eax

  mov eax, 1         ;move 1 (sys_exit code) to eax
  int 0x80           ;execute syscall in eax

section .bss
  result resd 1

section .data
  msgEven db "The number is even.", 0xA
  lenEven equ $ - msgEven
  msgOdd db "The number is odd.", 0xA
  lenOdd equ $ - msgOdd
