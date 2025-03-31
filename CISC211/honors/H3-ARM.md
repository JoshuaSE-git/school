```assembly
.section .text
  .global _start

_start:
  ldr r0, =var1   @load var1 address into r0
  ldr r1, [r0]    @load value of r0's stored address into r1 (var1 value)
  ldr r2, =var2   @load var2 address into r2
  ldr r3, [r2]    @load value of r2's stored address into r3 (var2 value)
  add r0, r1, r3  @add r1 + r3 and store result in r0 (var1 + var2)

  ldr r1, =var3   @load var3 address into r1
  ldr r2, [r1]    @load value of r1's stored address into r2 (var3 value)
  mul r0, r0, r2  @multiply r0 and r2 and store result in r0 (var1 + var2) * var3

  ldr r4, =var4   @load var4 address into r4
  str r0, [r4]    @store r0 value inside r4's stored address (result goes into var4)

  mov r7, #1      @move 1 (sys_exit code) inside r7
  swi 0           @execute sys_exit

.section .bss
var4:
  .space 4        @reserve 4 bytes of data for var4

.section .data
var1:
  .word 5
var2:
  .word 2
var3:
  .word 3
```
