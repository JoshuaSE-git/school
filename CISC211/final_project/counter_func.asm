section .text
  global _start

_start:
  push DWORD[counter]
  call _counter

  mov eax, 1
  int 0x80

_counter:  ;counter function
  push ebp
  mov ebp, esp
  sub esp, 4
  mov eax, [ebp+8]
  mov [ebp-4], eax   ;counter num
  
  mov [currentCounter], eax

  mov eax, 8
  mov ebx, filename
  mov ecx, 0777o
  int 0x80

  mov [fd], eax

  jmp outputLoop

outputLoop:  ;outer loop for writing counter to file
  mov eax, [currentCounter]
  xor ecx, ecx
  jmp pushLoop

pushLoop:  ;pushing individual digits to stack (inner loop)
  mov ebx, 10
  xor edx, edx
  div ebx
  push edx
  inc ecx                  ;ecx stores our counter number length
  cmp eax, 9
  jg pushLoop
  push eax
  inc ecx
  mov [printVarLen], ecx   ;move counter number length to printVarLen
  jmp writeLoop            ;after digits are done being pushed, we go to writeLoop

writeLoop:  ;writing individual digits to file (inner loop)
  pop eax
  add eax, 48
  mov [printVar], eax      ;printVar now has ascii converted digit

  mov eax, 4
  mov ebx, [fd]
  mov ecx, printVar
  mov edx, 1
  int 0x80

  mov ecx, [printVarLen]   ;handle loop logic based on varLen
  dec ecx
  mov [printVarLen], ecx
  cmp ecx, 0               ;if there are still more digits, we loop
  jg writeLoop 

  mov eax, 4               ;after digits are done, we write a new line    
  mov ebx, [fd]
  mov ecx, newLine     
  mov edx, 1
  int 0x80

  jmp continueOutputLoop    

continueOutputLoop:  ;continue outer loop logic
  mov eax, [currentCounter]
  dec eax
  mov [currentCounter], eax
  cmp eax, 0
  jge outputLoop
  jmp continueCounterFunc

continueCounterFunc:
  mov eax, 6           ;close file 
  mov ebx, [fd]
  int 0x80
  
  leave
  ret

section .bss
  fd resd 1
  printVar resd 1
  printVarLen resd 1
  currentCounter resd 1

section .data
  counter dd 20000
  filename db "counter_func.txt", 0h
  newLine db 0xA
