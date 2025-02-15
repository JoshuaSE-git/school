/* Program that takes in hexadecimal and outputs decimal
*/

#include <stdio.h>

int main(void) {
	
	int userValue;

	printf("Enter a number in hexadecimal: ");
	scanf("%x", &userValue);

	printf("%X = %d\n", userValue, userValue);

	return 0;
}
