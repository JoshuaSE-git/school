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
