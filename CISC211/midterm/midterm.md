# Midterm

## Q1) Arithmetic Code
### Code
```assembly
section .text
  global _start

; result = (var1 + 2) / (var3  - var2)
; result = (398 + 2) / (30 - 25)
; result = 400 / 5
; result = 80

; ASCII 80 = 'P'

_start:

  mov eax, [var1]
  add eax, 2
  mov ebx, eax
  
  mov eax, [var3]
  sub eax, [var2]
  mov ecx, eax

  mov eax, ebx
  div ecx
  mov [result], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, result
  mov edx, 1
  int 0x80

  mov eax, 1
  int 0x80

section .bss
  result resd 1

section .data
  var1 dd 398
  var2 dd 25
  var3 dd 30
```
### Register Table
![IMG_0022](https://github.com/user-attachments/assets/fdd330ed-ff79-4892-b076-03cc9787c8da)
### GDB Registers
![MidtermQ1GDB](https://github.com/user-attachments/assets/bcfb7e52-6f12-4ce8-83b3-493a15a45972)

## Q2)
### K-Map Simplification
![IMG_0024](https://github.com/user-attachments/assets/3c1e1951-e93a-4cd7-a7e9-3e87ea3b0290)
Simplified: a + b


## Q3)
### Design 
![IMG_0023](https://github.com/user-attachments/assets/57fff7c2-ae22-413a-9ece-b21bc54563ce)
### Code
```assembly
section .text
  global _start

_start:
  
  mov eax, [num]       ;mov value inside num (8) into eax
  test eax, 1          ;use test operation with eax and 1 to check even/odd. sets zero flag (zf)
  jz even              ;use jz operation to jump to "even" label if zf is set to 1 (number is even)

  mov eax, 4           ;mov 4 inside eax (sys_write code)
  mov ebx, 1           ;mov 1 inside ebx (stdout code)
  mov ecx, oddMsg      ;move oddMsg pointer inside ecx
  mov edx, oddLen      ;move oddLen value inside edx
  int 0x80             ;execute sys_write

  mov eax, 1           ;mov 1 inside eax (sys_exit)
  int 0x80             ;execute sys_exit

even:

  mov eax, 4           ;mov 4 inside eax (sys_write code)
  mov ebx, 1           ;mov 1 inside ebx (stdout code)
  mov ecx, evenMsg     ;move evenMsg pointer inside ecx
  mov edx, evenLen     ;move evenLen value inside edx
  int 0x80             ;execute sys_write

  mov eax, 1           ;mov 1 inside eax (sys_exit)
  int 0x80             ;execute sys_exit

section .data
  num dd 8

  evenMsg db "even number", 0xA
  evenLen equ $ - evenMsg

  oddMsg db "odd number", 0xA
  oddLen equ $ - oddMsg
```


