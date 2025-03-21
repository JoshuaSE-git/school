# W7-Activity Logical Instructions

## Task

1. Prove that XORing an operand with itself changes the operand to 0.
2. Create a case where you can implement a TEST instruction.

## Solution

### Prove that XORing an operand with itself changes the operand to 0.

Tests whether or not eax is zero after XOR operation and writes result to stdout.

```assembly
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
```

### Create a case where you can implement a TEST instruction.

Performs arithmetic operations with eax and checks if result is zero using test instruction.

```assembly
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
```
