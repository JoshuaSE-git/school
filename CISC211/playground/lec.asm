section .text
	global _start

_start:
	mov eax,10
	mov ebx,20
	call sum		;calling sum procedure
	mov eax,1
	int 0x80

sum:
	add eax,ebx
	ret
