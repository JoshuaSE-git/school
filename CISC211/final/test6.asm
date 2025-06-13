section .text
    global _start

_start:
    mov ecx, 0600o
    mov ebx, filename
    mov eax, 8
    int 0x80

    mov eax, 1
    int 0x80

section .data
    filename db 'file.txt', 0h