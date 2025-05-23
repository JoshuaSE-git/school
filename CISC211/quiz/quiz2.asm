section .text
  global _start

_start:

  mov eax, [a]  ;move a into eax
  mul dword [b] ;multiply a by b and store in eax (a x b)
  mov ebx , eax ;move eax value inside ebx (temporary storage of (a x b) term)

  mov eax, [c]  ;move c into eax
  mul dword [d] ;multiply c by d and store in eax (c x d)

  add eax, ebx  ;add stored term in ebx to eax (a x b) + (c x d)
  mov [x], eax  ;move final eax value inside x

  mov eax, 1    ;move 1 (sys_exit call code) into eax
  int 0x80      ;execute sys_exit

section .bss
  x resd 1      ;uninitialized result variable called x

section .data
  a dd 184
  b dd 73
  c dd 111
  d dd 462

;(a x b) + (c x d) = x
;(184 x 73) + (111 x 462) = 64714
