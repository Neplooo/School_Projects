#include <stdio.h>

int main()
{
	/* your code */
	
	int sum;
	int num1 = -1;
	int num2 = -1;
	
	while(num1 != 0 && num2 != 0){
	    
	    scanf("%d", &num1);
	    scanf("%d", &num2);
	    
	    if(num1 == 99 && num2 == 0){
	        printf("Finish.");
	        break;
	    }
	    
	    sum = num1 + num2;
	    
	    printf("%d\n", sum);
	    
	}
	
	return 0;
}