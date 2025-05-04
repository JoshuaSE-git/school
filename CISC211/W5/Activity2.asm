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
