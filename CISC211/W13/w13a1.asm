section .text
  global _start

_start:
  mov eax, 8           ;create file and return file descriptor to eax
  mov ebx, filename
  mov ecx, 0777o
  int 0x80

  mov [fd], eax        ;move file descriptor to fd variable

  mov eax, 4           ;write the first quote to the file
  mov ebx, [fd]
  mov ecx, quote1
  mov edx, len1
  int 0x80

  mov eax, 4           ;write the second quote to file (file descriptor still in ebx)
  mov ebx, [fd]
  mov ecx, quote2
  mov edx, len2
  int 0x80

  mov eax, 6           ;close file (file descriptor still in ebx)
  mov ebx, [fd]
  int 0x80

  mov eax, 1           ;exit
  int 0x80

section .bss
  fd resd 1

section .data
  filename db "quotes.txt", 0h

  quote1 db "To be, or not to be, that is the question.", 0xA, 0xA
  len1 equ $ - quote1

  quote2 db "A fool thinks himself to be wise, but a wise man knows himself to be a fool.", 0xA
  len2 equ $ - quote2
