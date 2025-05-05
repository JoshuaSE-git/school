section .text
  global _start

_start:                     ;main function
  push DWORD[num]
  call _evenOrOdd

  mov eax, 1
  int 0x80

_evenOrOdd:                 ;determines even or odd and prints result
  push ebp
  mov ebp, esp              ;initializing stack frame
  sub esp, 4
  mov eax, DWORD[ebp+8]
  mov DWORD[ebp-4], eax

  test eax, 1               ;logic for even/odd
  jz even
  jmp odd

even:                       ;push evenMsg pointer and evenLen value to stack (arguments)
  push DWORD[ebp-4]
  push msgEven     
  push evenLen
  jmp continueEvenOrOdd     ;jmp back to next instruction in _evenOrOdd

odd:                        ;push oddMsg pointer and oddLen value to stack (arguments)
  push DWORD[ebp-4]
  push msgOdd
  push oddLen
  jmp continueEvenOrOdd     ;jmp back to next instruction in _evenOrOdd

continueEvenOrOdd:          ;continuation after conditional logic
  call _print

  leave
  ret

_print:                     ;print function with msg pointer and msg len as parameters
  push ebp
  mov ebp, esp
  sub esp, 12
  mov eax, DWORD[ebp+16]
  mov DWORD[ebp-4], eax
  mov eax, DWORD[ebp+12]    ;initializing stack frame
  mov DWORD[ebp-8], eax
  mov eax, DWORD[ebp+8]
  mov DWORD[ebp-12], eax

  mov eax, 4                ;print start of message
  mov ebx, 1
  mov ecx, msgStart
  mov edx, startLen
  int 0x80

  push DWORD[ebp-4]
  call _printNum            ;print number

  mov eax, 4                ;print even/odd message
  mov ebx, 1
  mov ecx, DWORD[ebp-8]     ;pointer to msg
  mov edx, DWORD[ebp-12]    ;value of msgLen
  int 0x80

  leave
  ret

_printNum:                  ;function for printing number
  push ebp
  mov ebp, esp
  sub esp, 4
  mov eax, [ebp+8]
  mov [ebp-4], eax

  xor ecx, ecx

pushDigitLoop:              ;push digit loop
  mov ebx, 10
  xor edx, edx
  div ebx
  push edx
  inc ecx                   ;counter for number of digits
  cmp eax, 9
  jg pushDigitLoop
  push eax
  inc ecx
  mov [loopCounter], ecx
  jmp printDigitLoop

printDigitLoop:             ;print digit loop
  pop eax
  add eax, 48
  mov [printVar], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, printVar
  mov edx, 1
  int 0x80

  mov ecx, [loopCounter]   ;handle counter logic
  dec ecx
  mov [loopCounter], ecx
  cmp ecx, 0
  jg printDigitLoop

  leave
  ret

section .bss
  printVar resd 1
  loopCounter resd 1

section .data
  num dd 24881234

  msgStart db "The number "
  startLen equ $ - msgStart
  msgEven db " is even.", 0xA
  evenLen equ $ - msgEven
  msgOdd db " is odd.", 0xA
  oddLen equ $ - msgOdd
