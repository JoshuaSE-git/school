# Quiz 4

## Solution
x = 25
y = 183
z = 93
x+y+z = 301
```assembly
section .text
  global _start

; x + y + z = result
; 25 + 183 + 93 = 301

_start:
  push DWORD[x]   ;push arguments to stack
  push DWORD[y]
  push DWORD[z]
  call _add       ;call _add and push return address to stack

  mov [result], eax  ;move (x+y+z) to result variable

  mov eax, 1      ;exit program
  int 0x80

_add:
  push ebp        ;push stack base ptr to stack
  mov ebp, esp    ;mov base ptr to stack ptr
  sub esp, 12     ;allocate memory on stack for x,y,z

  mov eax, [ebp+16]   ;copy arguments to stack param variables
  mov [ebp-4], eax    ;x  
  mov eax, [ebp+12]
  mov [ebp-8], eax    ;y
  mov eax, [ebp+8]
  mov [ebp-12], eax   ;z

  mov eax, [ebp-4]    ;move x to eax
  add eax, [ebp-8]    ;add y to x (x+y)
  add eax, [ebp-12]   ;add z to (x+y) = (x+y+z)

  leave               ;deallocate stack mem ;(x+y+z) is still in eax
  ret                 ;pop and continue from return address

section .bss
  result resd 1

section .data
  x dd 25
  y dd 183
  z dd 93
```

## Result
![image](https://github.com/user-attachments/assets/2b2f695d-2c56-4710-81a3-eb42fb10cb1a)
