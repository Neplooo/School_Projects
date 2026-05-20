.data

result_str:
    .string "The result is: "
    .byte 0x0d # Newline character
    .byte 0x00 # Null terminator

############################################################################################
## NEED TO FIX THIS TO POINT TO THE CORRECT SERVICES AND ADD THESE TAGS TO THE CODE BELOW ##
############################################################################################
SYS_write: .word 0x40
SYS_exit:  .word 0x0a

.text
.globl main
main:
    # Set the two numbers to add
    li a0, 52    # First number (e.g., 5)
    li a1, 60    # Second number (e.g., 3)
    add t0, a0, a1 # t0 = 5 + 3 = 8

    # --- Convert integer to string (simplistic implementation) ---
    # This example converts a single-digit integer into its ASCII representation
    # and places it in a buffer. A more robust routine would handle multi-digit numbers.
    li a0, '0'  # Load the ASCII value of '0' into a0
    
    li t5, 100 # The t5 register will hold the divisor.
    div t2, t0, t5 # Get the hundreths position of the value.
    rem t0, t0, t5 # Remove the Hundreths value.
    li t5, 10 #Set the divisor to 10
    div t3, t0, t5 # Get the tens position of the value.
    rem t0, t0, t5 # Remove the tens value.
    
    
    add t0, t0, a0 # t1 = t0 + a0 -> convert ones digit to ASCII
    add t2, t2, a0 # t1 = t0 + a0 -> convert tens digit to ASCII
    add t3, t3, a0 # t1 = t0 + a0 -> convert hundreds digit to ASCII
    
    #t0: Original Sum (Not ASCII) -> Ones Place digit after operations.
    #t1: Sum in ascii.
    #t2: Hundreths Place Digit
    #t3: Tens Place Digit
    #t5: Divisor
    
    
    
    # Store the characters and a newline in a temporary buffer on the stack
    addi sp, sp, -16  # Allocate stack space (keep 16-byte alignment)
    sb t2, 0(sp)     # Store the ASCII hundreds character
    sb t3, 1(sp)     # Store the ASCII tens character
    sb t0, 2(sp)     # Store the ASCII ones character
    li t2, 0x0a      # Load newline character
    sb t2, 3(sp)     # Store the newline
    
    # --- Print introductory message ---
    # Prepare arguments for the write system call
    li a0, 1          # File descriptor 1 (stdout)
    la a1, result_str # Pointer to the message string
    li a2, 17         # Length of the string "The result is: \n" (16 chars + newline)
    li a7, 64  # System call number for write
    ecall             # Invoke the system call

    # --- Print the calculated result character ---
    # Prepare arguments for the write system call
    li a0, 1          # File descriptor 1 (stdout)
    mv a1, sp         # Pointer to the single-character buffer on the stack
    li a2, 4          # Length of the string (3 character + newline)
    li a7, 64  # System call number for write
    ecall             # Invoke the system call
    
    # Clean up stack
    addi sp, sp, 16
    
    # --- Exit the program ---
    li a7, 10   # System call number for exit
    li a0, 0          # Exit status 0
    ecall             # Invoke the system call
