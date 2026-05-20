###################################################################
#
# Fibonacci Sequence
#
# This program takes two seed values and and end integer.
# The program will calculate the fibonacci sequence up to the 
# end integer.
#
# Author: Big Bert
#
###################################################################



.text
.globl fibb
fibb:
	# Index the integers into registers.
	lb a0, seed1
	lb a1, seed2
	lb a2, numval
	
here:
	add a3, a0, a1 # Add the fib values into a3.
	mv a0, a1 # The first number becomes the second number.
	mv a1, a3 # The second number becomes the fib value.
	addi a2, a2, -1 #Decrement from the tracker (numval).
	bnez a2, here # loop through the function if the tracks != 0.
	
done:
	mv a0, a1 # Move the final sum into a0.
	ret # Return register a0 from the script.

.data
	# Create Data that represents information being passed in.
	seed1: .byte 1 # Seed 1 (First Digit)
	seed2: .byte 2 # Seed 2: (Second Digit)
	numval: .byte 10 # Num Val: End Integer
	
	
	
	
	