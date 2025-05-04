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

