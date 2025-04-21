section .text
  global _start

_start:
  mov eax, 65           ;intialize starting value 65 - 'A'

mainLoop:               ;main looping logic
  mov [printVar], eax
  call display
  call linefeed
  call handleLoop

handleLoop:             ;handles incrementing, exit, and looping logic
  mov eax, [printVar]
  inc eax
  cmp eax, 90
  jg exit
  jmp mainLoop

display:                ;display logic
  mov eax, 4
  mov ebx, 1
  mov ecx, printVar
  mov edx, 1
  int 0x80
  ret

linefeed:               ;display new line
  mov eax, 4
  mov ebx, 1
  mov ecx, space
  mov edx, 1
  int 0x80
  ret

exit:                   ;exit logic
  mov eax, 1
  int 0x80

section .bss
  printVar resd 1

section .data
  space dd 0xA
