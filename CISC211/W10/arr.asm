section .text
  global _start

_start:                ;initialize loop data
  mov ecx, 0
  mov eax, arr
  jmp greaterLoop

greaterLoop:           ;main loop logic for comparing max and current
  mov ebx, [eax]
  cmp ebx, edx
  jg swap
  jmp continue

swap:                  ;conditonal logic for swapping max and curr
  mov edx, ebx
  jmp continue

continue:              ;end of loop logic for managing counter and arr address
  inc ecx
  cmp ecx, len
  je exit
  add eax, 4
  jmp greaterLoop

exit:                  ;exit logic
  mov [result], edx
  mov eax, 1
  int 0x80

section .bss
  result resd 1

section .data
  arr dd 4, 8, 12, 3, 42, 2, 0
  len equ 7

