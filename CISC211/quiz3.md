```assembly
section .text
  global _start

_start:
  mov eax, 1
  mov ebx, 1 
  mov ecx, [factNum]

factLoop:
  mul ebx
  inc ebx

  loop factLoop
  jmp stackLoop

stackLoop:
  mov ebx, 10
  xor edx, edx
  div ebx
  push edx
  cmp eax, 9
  jg stackLoop
  push eax
  jmp displayNum

displayNum:
  pop eax
  add eax, 48
  mov [printVar], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, printVar
  mov edx, 1
  int 0x80

  pop eax
  add eax, 48
  mov [printVar], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, printVar
  mov edx, 1
  int 0x80

  pop eax
  add eax, 48
  mov [printVar], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, printVar
  mov edx, 1
  int 0x80

  call linefeed
  call exit

linefeed:
  mov eax, 4
  mov ebx, 1
  mov ecx, space
  mov edx, 1
  int 0x80
  ret

exit:
  mov eax, 1
  int 0x80

section .bss
  printVar resd 1

section .data
  factNum dd 6
  space dd 0xA
```

## Output
6! = 720
![image](https://github.com/user-attachments/assets/dbec8003-b672-4659-96bb-214d2930af72)

