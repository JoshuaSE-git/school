SECTION .data
        filename db 'readme.txt', 0h    ; the filename to create
        contents db 'Hello world!', 0h  ; the contents to write
 
SECTION .text
        global  _start
 
_start:
        ;file open operation
        ;assuming that the file has already been created.
        ;If the readme.txt file is not created, then crrate a file
        ;using the example above.
        mov eax, 5					;file handling system call
        mov ebx, filename
        mov ecx, 1
        mov edx, 0777o
        int 0x80

        mov [fd_out],eax

        ;file write operation
        mov eax, 4					;file handling system call
        mov ebx, [fd_out]   ;file descriptor
        mov ecx, contents
        mov edx, 12         ;number of bytes written
        int 0x80

        mov eax, 1
        int 0x80

section .bss
        fd_out resb 1
