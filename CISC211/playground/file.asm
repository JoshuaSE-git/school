SECTION .text
global  _start
 
_start:
 
        mov     ecx, 0711o ; set all permissions to read, write, execute (octal format)
        mov     ebx, filename       ; filename we will create
        mov     eax, 8              ; invoke SYS_CREAT (kernel opcode 8)
        int     0x80                ; call the kernel

        mov     eax,1
        int     0x80

SECTION .data
filename db 'readme.txt', 0h    ; the filename to create
