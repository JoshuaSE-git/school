section .text
  global _start

_start:                   ;initialize fib loop data
  mov ecx, 9
  mov eax, 0
  mov ebx, 1

fib:                      ;main loop logic, shifting values around
  add eax, ebx
  mov edx, eax
  mov eax, ebx 
  mov ebx, edx
  
  loop fib
  mov [result], ebx
  jmp display

display:                  ;printing logic
  mov eax, [result]
  xor edx, edx
  mov ebx, 10
  div ebx
  push edx
  push eax

  pop eax                 ;pop/push method
  add eax, 48
  mov [displayVar], eax
  call print

  pop eax,
  add eax, 48
  mov [displayVar], eax
  call print

  mov eax, 4              ;linefeed
  mov ebx, 1
  mov ecx, space
  mov edx, 1
  int 0x80

  jmp exit

print:
  mov eax, 4
  mov ebx, 1
  mov ecx, displayVar
  mov edx, 1
  int 0x80
  ret

exit:                    ;exit
  mov eax, 1
  int 0x80

section .bss
  result resd 1
  displayVar resd 1

section .data
  space dd 0xa


