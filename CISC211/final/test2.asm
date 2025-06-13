section .text
        global _start

_start:
        mov ecx, array

        mov ebx, [ecx]   ;5
        add ecx, 4
        cmp ebx, [ecx]   ; 5, 10
        jg label1

        mov ebx, [ecx]   ;10
        jmp label1

label1:
        add ecx, 4
        cmp ebx, [ecx]   ;5, 15
        jg end
        mov ebx, [ecx]
        jmp end

end:
        mov [variable], ebx
        mov eax, 1
        int 0x80

section .data
        array dd 10,15,5

segment .bss
        variable resd 1