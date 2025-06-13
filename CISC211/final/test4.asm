section .text
        global _start

_start:
        mov eax,65
        mov [res],eax
        mov ecx,res
        call output
        call exit

        mov eax,10
        mov [res],eax
        mov ecx,res
        call output

        mov eax,66
        mov [res],eax
        mov ecx,res
        call output
        call exit

output:
        mov edx,1
        mov ebx,1
        mov eax,4
        int 0x80
        ret

exit:
        mov eax,1
        int 0x80

segment .bss
        res resb 1