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
