# W6-Activity Arithmetic Instructions

## Task

Implement the following arithmetic instructions

1. $result = -var1*10$
2. $result = var1+var2+var3+var4$
3. $result = (-var1*var2)+var3$
4. $result = (var1*2)/(var2-3)$, choose $var1$ and $var2$ in such a way that the $result$ datatype is an integer.

## Solutions

### 1) $result = -var1*10$

-115\*10 = -1150

```assembly
section .text
  global _start

_start:

  MOV EAX, [var1] ;move value inside var1 (115) to eax register
  NEG EAX ;negate the value inside eax
  MOV EBX, 10 ;move immediate value 10 into ebx
  IMUL EBX ;since we are working with signed integers, use imul instead of mul
  MOV [result], EAX ;move value inside eax (-1150) to result's memory space

  MOV EAX, 1 ;move 1 (sys_exit code) to eax
  INT 0x80 ;execute sys call in eax

section .bss
  result RESD 1 ;reserve dword in memory

section .data
  var1 DD 115 ;define var1 to be a dword sized value of 115
```

### 2) $result = var1+var2+var3+var4$

10+20+30+40 = 100

```assembly
section .text
  global _start

_start:

  MOV EAX, [var1] ;move value inside var1 (10) to eax
  ADD EAX, [var2] ;add value inside var2 (20) to eax
  ADD EAX, [var3] ;add value inside var3 (30) to eax
  ADD EAX, [var4] ;add value inside var4 (40) to eax
  MOV [result], EAX ;move value in eax register (100) to result's memory space

  MOV EAX, 1 ;move 1 (sys_exit code) to eax
  INT 0x80 ;execute sys_call in eax

section .bss
  result RESD 1 ;reserve dword in memory for result's value

section .data
  var1 DD 10 ;var1 size dword value 10
  var2 DD 20 ;var2 size dword value 20
  var3 DD 30 ;var3 size dword value 30
  var4 DD 40 ;var4 size dword value 40
```

### 3) $result = (-var1*var2)+var3$

(-15\*103)+84 = -1461

```assembly
section .text
  global _start

_start:

  MOV EAX, [var1] ;move value inside var1 (15) to eax
  NEG EAX ;negate value inside eax
  IMUL DWORD [var2] ;in order to use a var in memory as mul operand, we must specify size (dword)
  ADD EAX, [var3] ;add value inside var3 (84) to value inside eax (-1545)
  MOV [result], EAX ;move value inside eax (-1461) to result's memory space

  MOV EAX, 1 ;move 1 (sys_exit code) inside eax
  INT 0x80 ;execute sys call inside eax

section .bss
  result RESD 1 ;reserve dword for result

section .data
  var1 DD 15 ;define var1 dword size value 15
  var2 DD 103 ;define var1 dword size value 15
  var3 DD 84 ;define var1 dword size value 15
```

### 4) $result = (var1*2)/(var2-3)$

(50\*2)/(8-3) = 20

```assembly
section .text
  global _start

_start:

  MOV EAX, [var1] ;move value inside var1 (50) to eax
  MOV EBX, 2 ;move 2 inside ebx
  MUL EBX ;multiple value inside eax (50) by value inside ebx (2), store result in eax (100)
  MOV EBX, [var2] ;move value inside var2 (8) inside ebx
  SUB EBX, 3 ;subtract value inside ebx by 3
  DIV EBX ;divide value inside eax (100) by value inside ebx (5), store result in eax (20)
  MOV [result], EAX ;move value inside eax (20) inside result's memory space

  MOV EAX, 1 ;move 1 (sys_exit code) to eax
  INT 0x80 ;execute sys call inside eax

section .bss
  result RESD 1 ;reserve dword of space in memory

section .data
  var1 DD 50 ;define var1 size dword value 50
  var2 DD 8 ;define var2 size dword value 8
```

## Lab Questions

Q) What were your challenges in performing the lab (from design to the implementation phases)?

A) My main challenge was understanding how the MUL, IMUL, and DIV instructions work. At first, I thought the MUL/IMUL instructions only worked with register operands, but I later found out it was possible to use variables from memory instead. However, when using memory operands, MUL and IMUL need information about the size of the operand, because memory addresses alone don't carry size information—they're just sequences of bytes. To fix this, you explicitly specify the operand size by adding keywords like BYTE, WORD, DWORD, or QWORD to the instruction. This is not necessary when using register operands, because the register itself inherently implies the operand size to the assembler.

![image](https://github.com/user-attachments/assets/dd74cc5a-60e0-4eb4-acce-544817db7de3)

