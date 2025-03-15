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
