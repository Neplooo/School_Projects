#include <stdio.h>
#include <stdlib.h>

int main(){

    int numbers[5], sum = 0, i;
    
    for(i = 0; i < 5; i++){
        numbers[i] = i*i;
    }


    // The pointer is telling C to look for the zeroth index of numbers.
    // Look for the address of numbers rather than the array object.

    *numbers = -5; // Sets the zero value of numbers to -5
    *(numbers + 3) = 2; // Sets the third value of numbers to two
    
    for(i = 0; i < 5; i++){
        sum += numbers[i];
        printf("numbers[%d] = %d \n", i, numbers[i]);
        
    }

    return(0);
    
}