section .text
  global _start

_start:
  mov eax, 5         ;open quotes.txt file and return file descriptor to eax
  mov ebx, filename
  mov ecx, 2
  mov edx, 0777o
  int 0x80

  mov [fd], eax      ;store file descriptor in fd variable

  mov eax, 19        ;sys_lseek to move file pointer (offset) to end of file
  mov ebx, [fd]
  mov edx, 2         ;move file pointer to end of file
  mov ecx, 0         ;0 offset from current file pointer
  int 0x80

  mov eax, 4         ;write quote3 at current file pointer
  mov ebx, [fd]
  mov ecx, quote3
  mov edx, len3
  int 0x80

  mov eax, 4         ;write quote4 at current file pointer
  mov ebx, [fd]
  mov ecx, quote4
  mov edx, len4
  int 0x80

  mov eax, 6         ;close file
  mov ebx, [fd]
  int 0x80

  mov eax, 1         ;exit
  int 0x80

section .bss
  fd resd 1

section .data
  filename db "quotes.txt", 0h

  quote3 db 0xA, "Better three hours too soon than a minute too late.", 0xA, 0xA
  len3 equ $ - quote3

  quote4 db "No legacy is so rich as honesty.", 0xA
  len4 equ $ - quote4

