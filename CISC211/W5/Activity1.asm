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
