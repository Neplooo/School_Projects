public class RPNCalculator implements RPNops {

    private Link stackTop; //Top of stack
    private int stackSize; //Size of Stack

    /**
     * Constructor to see build an empty calculator with
     */
    public RPNCalculator() { stackTop = null; stackSize = 0; }

    /**
     * Constructor to build a calculator with a pre-defined size.
     * @param size The size you want the stack to be.
     */
    public RPNCalculator(int size) { stackTop = null; stackSize = size; }

    // ------ Stack Related Functions ------

    /**
     * Clear the stack. Set it back to empty.
     */
    public void clear() { stackTop = null; stackSize = 0; } //Reset the stack

    /**
     * Push a number to the stack. 
     * @param num The number being pushed.
     * @return Boolean statement representing if the number was sucessfully pushed.
     */
    public boolean push(Object num) {
        stackTop = new Link(num, stackTop);
        stackSize++;
        return true;
    }

    /**
     * Removes an object from the stack and reveals its value
     * @return The value of the object popped.
     */
    public Object pop(){
        Object returnVal;
        if(stackTop == null) returnVal = 0;
        else{
            returnVal = stackTop.element();
            stackTop = stackTop.next();
            stackSize--;
        }

        return returnVal;

    }

    /**
     * Reveals the value of the top node in the stack.
     * @return The value of the node.
     */
    public Object topValue(){
        Object returnVal;
        if(stackTop == null) returnVal = null;
        else{
            returnVal = stackTop.element();
        }

        return returnVal;

    }

    /**
     * Returns a boolean representing if the stack is empty or not.
     * @return T/F on if the stack is empty.
     */
    public boolean isEmpty() {
        return stackSize == 0;
    }

    // ------ RPN Related Functions ------

    /**
     * Adds 2 numbers together.
     * @return The sum of x and y.
     */
    public float add(float x, float y){
        return x + y;
    }

    /**
     * Substracts 2 numbers together
     * @return The difference between x and y.
     */
    public float subtract(float x, float y){
        return x - y;
    }

    /**
     * Multiplies 2 numbers together.
     * @return The multiplication between x and y
     */
    public float mult(float x, float y){
        return x * y;
    }

    /**
     * Divides 2 numbers
     * @return The division between x and y
     */
    public float div(float x, float y){
        int num = (int) (x / y);
        return (float) (num);
    }

    /**
     * Takes the mod of x by y.
     * @return x mod y
     */
    public float mod(float x, float y){
        return x % y;
    }

    /**
     * Does floating point divison between x and y.
     * @return x / y
     */
    public float fdiv(float x, float y){
        return x / y;
    }
    
    /**
     * Takes the power of x to the y.
     * @return x^y
     */
    public float power(float x, float y){
        return (float) (Math.pow(x, y));
    }

    /**
     * Reveal the top of the stack with a "."
     * @return The top value of the stack.
     */
    public float dot(){
        return (float) topValue();
    }

    /**
     *  Reveals the stack from top to bottom
     * @return The stack from top to bottom.
     */
    public String reveal(){

        String returnString = "[TOS]\n";

        Link temptop = stackTop;

        for(int i = 0; i < stackSize; i++){

            if(i == 0){
                returnString += "[ " + stackTop.element() + " ]\n";
            }else{
                returnString += "[ " + temptop.element() + " ]\n";
            }

            temptop = temptop.next();
            

        }

        returnString += "[BOS]";

        return returnString;
        
    }

    /**
     * Returns the length of the stack.
     */
    public void length(){
        System.out.println("{" + stackSize + "}");
    }

    // ------ Calculator Related Functions ------

    /**
     * Evaluation Function; This function takes the input in RPN or Postfix notation, and solves for the solution.
     * @param input Equation; MUST BE IN POSTFIX NOTATION WITH SPACE DELIMITERS
     * @return The solved equation as a float.
     */
    public float evaluate(String input){

        float digit1;
        float digit2;
        String operator;

        //System.out.println(input.length());

        String[] parsedIn = input.split(" ");


        for(String in : parsedIn){

            //Try pushing a number to the stack
            try {
                float num = Float.parseFloat(in);
                push(num);
            }
            //If it's not a number, it's time to do a operation.
            catch (Exception noNum) {
                
                //If it's a special operation, do one of those.
                if(in.equals(".") || in.equals("$") || in.equals("C") || in.equals("?")){

                    switch (in) {
                        case ".":
                            try {
                                System.out.println(dot());
                            } catch (Exception emptyStack) {
                                System.out.println("[empty]");
                            }
                            break;
                        case "$":
                            System.out.println(reveal());
                            break;
                        case "C":
                            clear();
                            break;
                        case "?":
                            length();
                            break;
                    }

                    if(!in.equals("C")){
                        System.out.println("");
                    }

                //If not, we need to do a numerical operation.
                }else{

                    digit2 = (float) pop();
                    digit1 = (float) pop();
                    operator = in;

                    switch (operator) {
                        case "+":
                            push(add(digit1, digit2));
                            break;
                        case "-":
                            push(subtract(digit1, digit2));
                            break;
                        case "*":
                            push(mult(digit1, digit2));
                            break;
                        case "/":
                            push(div(digit1, digit2));
                            break;
                        case "//":
                            push(fdiv(digit1, digit2));
                            break;
                        case "%":
                            push(mod(digit1, digit2));
                            break;
                        case "^":
                            push(power(digit1, digit2));
                            break;
                        default:
                            break;
                    }

                    //Done

                }



            }

        }

        //Pop the last number
        return (float) pop();

    }


}