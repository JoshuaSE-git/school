# Mock Exam

## Q1) Calculate the mean of the following dataset using assembly language

$Mean=Sum of students/number of students$

|Name|score|
|----|-------|
|Student 1|60|
|Student 2|70|
|Student 3|90|
|Student 4|40|
|Student 5|65|

### Solution
TODO: USE VARS

```assembly
section .text
  global _start

_start:
  
  mov eax, 60
  add eax, 70
  add eax, 90
  add eax, 40
  add eax, 65
  mov ebx, 5
  div ebx
  mov [result], eax

  mov eax, 4
  mov ebx, 1
  mov ecx, result
  mov edx, 1 
  int 0x80

  mov eax, 1
  int 0x80
  
section .bss
  result resb 1
```

## Q2) Convert the following
- Convert 575 decimal into binary and hexadecimal
- Convert 0x80 into binary

### Solution

575 (dec) -> 0010 0011 1111 (binary) -> 0x23F (hex)

0x80 (hex) -> 1000 0000 (binary)

## Q3) Represent the following into negative numbers
- Convert -10 into binary using 1's and 2's complements

### Solution

-10 (dec) -> 1111 0101 (1's complement)
-10 (dec) -> 1111 0110 (2's complement)

## Q4) Identify error(s) in the following code
```assembly
section .text
    global _start

_start:
    mov eax,10
    mov ebx,20
    add eax,ebx
    mov result,eax
    
    mov eax,1
    int 0x80

section .data
    result resb 1
```

1) Must dereference result variable to move data into it
2) Must use section .bss instead of section .data for uninitialized variables

### Solution
```assembly
section .text
    global _start

_start:
    mov eax,10
    mov ebx,20
    add eax,ebx
    mov [result],eax  ;need to dereference result variable to move data into it
    
    mov eax,1
    int 0x80

section .bss          ;must use section .bss for uninitialized variables
    result resb 1
```

## Q5) Transfer the bits into the Cache memory
- 10111
- 10000
- 11101

### Solution
![image](https://github.com/user-attachments/assets/b031c447-82f4-4411-bae2-002c5c12f54c)

