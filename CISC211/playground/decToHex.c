/* Converts decimal to hexadecimal
*/

#include <stdio.h>

int main(void) {

	int userValue;

	printf("Enter a nmber in decimal: ");
	scanf("%d", &userValue);

	printf("%d = %X\n", userValue, userValue);
}
