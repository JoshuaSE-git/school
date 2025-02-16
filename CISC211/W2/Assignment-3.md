# W2-Activity Boolean Algebra
## Part 1
**Simplify the following equation:**

$F = A'B'C' + A'B'C + A'BC + AB'C + ABC'$

**Process:**
1) Boolean expression is given as sum of minterms with no duplicate terms
2) We can simplify by using K-map

![IMG_0009](https://github.com/user-attachments/assets/e2d198e3-a593-4843-a9fd-7b3f136a941b)

### Final:  $F = A'B' + A'C + B'C + ABC'$

![Screenshot 2025-02-15 at 3 27 54 PM](https://github.com/user-attachments/assets/c3dc30e9-f4a1-4187-9aee-1670890001dd)

## Part 2
**Simplifying an equation using Boolean algebra properties: Motion-sensing light**

- Inputs: m: motion sensed, t: test mode

- Outputs: i: illuminate lamp

- Goal: Illuminate lamp if motion and not test mode, or if test mode and no motion, or if test mode and motion  

Write the equation and then simplify the original equation

**Process:**
1) Identify inputs and outputs

	 - Inputs: m = motion sensed, t = test mode
	 - Output: i = illuminate lamp

2) Model boolean function

	 - M'T = "motion and not test mode"
	 - M'T = "test mode and no motion"
	 - MT = "test mode and motion"

	### Model: $I = MT' + M'T + MT$

3) Simplify

	 - Model expression in sum of minterms
	 - Use K-Map or Boolean Algebra properties to simplify
		 - ***Note: K-Map method on left, B.A. method on right***
  
![IMG_0010](https://github.com/user-attachments/assets/a9fc7763-de87-401d-9f26-ac94ed5bbbb8)
	
### Final: $I = M + T$

![Screenshot 2025-02-15 at 5 11 12 PM](https://github.com/user-attachments/assets/56520e63-623b-4264-94a6-7463eb4fe8ad)

## Post-lab Questions

**1.  What were your challenges in performing the lab (from design to the implementation phases)? (1 mark)**

Since this was my first time encountering K-Maps, I was initially confused about the specific rules and steps needed to use them correctly. I learned that you can arrange the columns and rows in any order, provided each one differs by exactly one bit from its adjacent columns or rows. I also learned that the minterms must be grouped in powers of two (1, 2, 4, etc.).
