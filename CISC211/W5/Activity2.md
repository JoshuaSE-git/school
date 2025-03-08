# W5b - Activity Variables and Constants

## Task

Write a code in Assembly that uses uninitialized and initialized variables.

## Solution

```Assembly
section .text
  global _start

_start:

  MOV EAX, [num1] ;dereference num1 and store 4 byte value in EAX
  MOV EBX, [num2] ;dereference num2 and store 4 byte value in EBX
  ADD EAX, EBX ;add EBX to EAX and store in EAX

  MOV [result], EAX ;store EAX value (134) in result's memory space

  MOV EAX, 1 ;move 1 to EAX (SYS_EXIT)
  INT 0x80

segment .bss
  result RESD 1 ;reserve double word because EAX is 4 bytes

section .data
  num1 DD 50 ;define double word because EAX is 4 bytes
  num2 DD 84 ;define double word because EBX is 4 bytes
```

## Lab Questions

Q: What were your challenges in performing the lab (from design to the implementation phases)?

A: Initially, I defined my integer variables using DB (Define Byte), which allocates only 1 byte per variable. This caused issues when attempting to store those values inside the EAX and EBX registers because these registers are 4 bytes wide and expect the same amount of data when using the MOV instruction.

Since my variables were only 1 byte each (DB) and stored next to each other in memory, when I moved the first variable into EAX, the instruction retrieved 4 bytes from memory instead of just 1. This caused EAX to store not only the first variable but also the adjacent memory bytes, which included the second variable and other uninitialized data.

Because of this, arithmetic operations such as ADD EAX, EBX produced incorrect results. The solution was to define my variables as DD (doubleword, 4 bytes) to match the size of EAX, ensuring that each variable occupied exactly the expected space in memory.

## Flowchart
![image](https://github.com/user-attachments/assets/b48692f3-8825-4726-939d-55cc636f26ae)

