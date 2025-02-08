
# W1-a Numbering Systems Assignment
## Encryption
1) Create a secret one word "message" **(vector)** and convert it to binary form using ASCII representation

   - `vector` → `01110110 01100101 01100011 01110100 01101111 01110010`
	
	For reference: `"v" = 118 | "e" = 101 | "c" = 99 | "t" = 116 | "o" = 111 | "r" = 114`

2) Create a secret one word "key" **(linear)** and convert it to binary form using ASCII representation

   - `linear` → `01101100 01101001 01101110 01100101 01100001 01110010`

	For reference: `"l" = 108 | "i" = 105 | "n" = 110 | "e" = 101 | "a" = 97 | "r" = 114`
	
5) Encrypt message by applying bitwise XOR operation on binary key and message. We'll go byte by byte starting with the left most character "v" and XOR'ing it with the character "l"

   - `"v" 01110110 XOR 01101100 "l" → 00011010`  
   - `"e" 01100101 XOR 01101001 "i" → 00001100` 
   - `"c" 01100011 XOR 01101110 "n" → 00001101` 
   - `"t" 01110100 XOR 01100101 "e" → 00010001`
   - `"o" 01101111 XOR 01100001 "a" → 00001110`
   - `"r" 01110010 XOR 01110010 "r" → 00000000`
   
   After encryption: `00011010 00001100 00001101 00010001 00001110 00000000`
   

6) Convert encrypted binary message to hexadecimal for easy sharing

   - `00011010 → 1A`
   - `00001100 → 0C`
   - `00001101 → 0D`
   - `00010001 → 11`
   - `00001110 → 0E`
   - `00000000 → 00`
   
   After conversion:  `1A 0C 0D 11 0E 00`

## Decryption

1) Receive encrypted hexadecimal message

   - `1A 0C 0D 11 0E 00`

2) Convert message to binary for decryption

   - `1A → 00011010`
   - `0C → 00001100`
   - `0D → 00001101`
   - `11 → 00010001`
   - `0E → 00001110`
   - `00 → 00000000`
   
   After conversion: `00011010 00001100 00001101 00010001 00001110 00000000`

3) Recall secret key  **(linear)** and convert it into binary form for bitwise XOR operation

   - `linear → 01101100 01101001 01101110 01100101 01100001 01110010`

	For reference: `"l" = 108 | "i" = 105 | "n" = 110 | "e" = 101 | "a" = 97 | "r" = 114`
	
4) Decrypt message by applying bitwise XOR operation on encrypted message and key
   - `00011010 XOR 01101100 "l" → 01110110`
   - `00001100 XOR 01101001 "i" → 01100101`
   - `00001101 XOR 01101110 "n" → 01100011`
   - `00010001 XOR 01100101 "e" → 01110100`
   - `00001110 XOR 01100001 "a" → 01101111`
   - `00000000 XOR 01110010 "r" → 01110010`

	After decryption: `01110110 01100101 01100011 01110100 01101111 01110010`

6) Convert decrypted message to plain text

   - `01110110 → 118 → "v"`
   - `01100101 → 101 → "e"`
   - `01100011 → 099 → "c"`
   - `01110100 → 116 → "t"`
   - `01101111 → 111 → "o"`
   - `01110010 → 114 → "r"`

	After conversion: `vector`

	For reference: `"v" = 118 | "e" = 101 | "c" = 99 | "t" = 116 | "o" = 111 | "r" = 114`

## Questions

### Q1) What strategies will you use to perform a bitwise XOR operation when plaintext and key have different lengths?

**A1)** One solution would be to use empty characters (8 0 bits) to fill in the difference in lengths. For example, if your message consists of 8 bits, but your key only consists of 4 bits, we would "fill in" our key using empty characters. This would ensure there is no information loss when we apply the bitwise XOR operation.

A more secure way of handling varying key/message lengths would be to truncate the key when the message is shorter than the key, and to repeat the key when the message is longer than the key. For example, if our message is "hi" and our key is "hello", we would truncate our key to "he" to match the message length, and if our message is "hello" and our key is "hi", we would repeat our key to match the message length "hihih".

### Q2) What were your challenges in performing the lab?

**A2)** The lab itself was fairly straightforward to design and implement. However, the question about varying key/message lengths was challenging to think about. I came to the solution of "zero-padding" the shorter of the two, but quickly realized this would be an insecure encryption. After googling, I came across the repeating key method which I wrote about in my answer above.

![W1A](https://github.com/user-attachments/assets/246e45fd-4657-47ff-9f38-3f104acee1c2)

![Screenshot 2025-02-08 at 2 55 35 PM](https://github.com/user-attachments/assets/53e76d17-1d1b-4e56-8872-7bed517a6ca8)
