# W5a-Activity First AL program

## Task

Write a code in Assembly and display the following content on the screen.

```
I came,
I saw,
I conquered.
```

## Solution

```Assembly
section .text
  global _start

_start:

  MOV EAX, 4 ;move 4 to EAX (system call number for SYS_WRITE)
  MOV EBX, 1 ;move 1 to EBX (file descriptor number for STDOUT)
  MOV ECX, msg ;move msg's pointer to ECX
  MOV EDX, len ;move len value (28) to EDX
  INT 0x80

  MOV EAX, 1 ;move 1 to EAX (system call number for SYS_EXIT)
  INT 0x80

section .data
  msg DB "I came,", 0xA, "I saw,", 0xA, "I conquered.", 0xA ;stores 28 chars (1 byte each) in memory
                                                            ;msg points to first char address

  len EQU $ - msg ;takes current memory address and subtracts address of msg (28)
```

## Lab Questions

Q: What were your challenges in performing the lab (from design to the implementation phases)?

A: One thing I found challenging when doing this lab was the data section of my assembly code, I didn't understand how string literals were being stored in memory.  I knew that each character takes up 1 byte, so I was confused as to why we only use DB instead of something bigger to store our message. I later found out that each individual character gets stored in its own memory location, and that our named variable "msg" simply points to the first character in the string literal.  In a way, the line, `msg DB "I came,", 0xA, "I saw,", 0xA, "I conquered.", 0xA`, essentially acts as an "array" builder for characters, with each slot in the array being 1 byte wide.

## Flowchart
![image](https://github.com/user-attachments/assets/3a0bdbac-4748-4223-a6e1-5e38325de97d)

