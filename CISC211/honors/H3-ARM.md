# H3 - Assembly Language in ARM

## Task
- Convert x86 asm to it's 32 bit ARM equivalent.
- Explore the differences between x86 and ARM architectures.

### Original program (x86)
```assembly
 section .text
     global _start
 ​
 _start:
     mov eax,[var1]
     add eax,[var2]
     mov dl,[var3]
     mul dl
     mov [var4],eax
     
     mov eax,1
     int 0x80
 ​
 section .data
     var1 DD 5 ; var1 is assigned 5
     var2 DD 2 ; var2 is assigned 2
     var3 DD 3 ; var3 is assigned 3
     
 segment .bss
     var4 resb 1
```

### Converted program (ARM)
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

## Differences between x86 and ARM architecture.

x86 and ARM are the two most widely used CPU architectures in the world today.  The x86 architecture, known for its rich instruction set and fast computing speeds, is commonly used in personal computers and servers.  On the flip side, the ARM architecture dominates the mobile, embedded, and IoT sectors due to it's focus on efficient power consumption and simple instructions.  The difference between these two architectures comes down to their guiding philosphies, and can be observed in their respective instruction set architectures.

The x86 processors can be classified as a "complex instruction set computer", or CISC for short.  This is because many of its instructions combine multiple calculations and operations into one single instruction.  For example, moving data from main memory to registers can be achieved using a single instruction in x86, where as other non-CISC ISA's often require two or more instructions to achieve the same result.  These powerful instructions allow for ease of development as well as a reduced instruction count, which can lead to more efficient memory transfer and faster execution speeds.  Overall these factors give x86 processors the reputation of being highly performant, which is why they're widely used in large servers as well as desktop computers.  This performance comes at a cost of 





