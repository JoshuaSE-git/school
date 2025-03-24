# Mock Exam

## Calculate the mean of the following dataset using assembly language

$Mean=Sum of students/number of students$

|Name|score|
|----|-------|
|Student 1|60|
|Student 2|70|
|Student 3|90|
|Student 4|40|
|Student 5|65|

# Solution

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

