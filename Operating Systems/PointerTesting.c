#include <stdio.h>
#include <stdlib.h>

void main(){

    //Create an integer
    int num1 = 100;

    //Initialize an Integer Pointer
    int *pnum;

    //Point to the num1 variable.
    pnum = &num1;

    //Printing without the asterisk gets you the address.
    //With an Asterisk gives you the Value
    printf("Pnum address = %d \n", pnum);
    printf("Pnum value = %d \n", *pnum);

}