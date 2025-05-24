/**
 * Conway's Game Of Life: A programming game that runs simulations on creatures
 * in order to practice the ideas of dimensional arrays in java.
 * 
 * @author Alberto
 * @version 1.0
 */
public class Conway{

    //Counter Variables that keep track of the game statistics.
    private static int generation = 0;
    public static int totalBirths = 0;
    public static int totalDeaths = 0;

    /**
     * This function prints out the current state of the field
     * @param field Array containing the current field
     */
    public static void printField(int[][] field){

        //Info
        System.out.println("Current Generation: " + generation + " Total Births: " + totalBirths + " Total Deaths: " + totalDeaths);
        System.out.println("==========================================");

        for (int i = 0; i < field.length; i++){
            for (int x = 0; x < field[0].length; x++){
                if(field[i][x] == 0){
                    System.out.print(" . "); //If the index is empty, print "no life"
                }else{
                    System.out.print(" * "); //If the index is full, print an object.
                }
            }
            System.out.println(""); //Make sure the field looks accurate.
        }

    }

    /**
     * Randomly fills 1/3 of the field with bacteria
     * @param field the field being manipulated
     */
    public static void placeObjects(int[][] field){

        for(int i = 0; i < 33; i++){
            int randX = (int) (Math.random()*10);
            int randY = (int) (Math.random()*10);

            field[randX][randY] = 1;

        }

        generation = 1;
        totalBirths = 33;
        totalDeaths = 0;

    }

    /**
     * Increments the existing objects on the field by refrencing them to Conway's Rules
     * @param field Your array representing the field.
     */
    public static void nextGen(int[][] field){

        //Make a copy so we don't break the main array.
        int[][] fieldCopy = new int[field.length][field[0].length];

        //Values to keep count of births and deaths.
        int birthCount = 0;
        int deathCount = 0;

        for(int x = 0; x<field.length; x++){
            for(int y = 0; y < field[0].length; y++){
                int neighbors = 0;

                //GG if statements.
                //Basically check to see if there is a neighbor to each object using if statements

                //Top Rows
                if(x - 1 >= 0 && y -1 >= 0){
                    neighbors += field[x-1][y-1];
                }if(x - 1 >= 0){
                    neighbors += field[x-1][y];
                }if(x - 1 >= 0 && y + 1 < field[0].length){
                    neighbors += field[x-1][y+1];
                }
                //Middle Rows
                if(x >= 0 && y-1 >= 0){
                    neighbors += field[x][y-1];
                }if(x - 1 >= 0 && y + 1 < field[0].length){
                    neighbors += field[x][y+1];
                }
                //Bottom Rows
                if(x + 1 < field.length && y - 1 >= 0){
                    neighbors += field[x+1][y-1];
                }if(x + 1 < field.length && y >= 0){
                    neighbors += field[x+1][y];
                }if(x + 1 < field.length && y + 1 < field.length){
                    neighbors += field[x+1][y+1];
                }

                //Debuggin it rn
                //System.out.println("Row: " + x + " Collumn: " + y + " Neighbors: " + neighbors);

                //Outcomes for how to change the field from generation to generation.
                if(neighbors == 2){
                    fieldCopy[x][y] = field[x][y]; //Keep the field the same.
                }else if(neighbors == 3){
                    fieldCopy[x][y] = 1; //Create new object.
                    birthCount++;
                }else{
                    fieldCopy[x][y] = 0; //Kill object.
                    deathCount++;
                }

            }
        }

        //Set the field to the new one on the copy.
        for(int x = 0; x < field.length; x++){
            for(int y = 0; y < field[0].length; y++){
                field[x][y] = fieldCopy [x][y];
            }
        }

        generation++;
        totalBirths += birthCount;
        totalDeaths += deathCount;


    }

    /**
     * Function that checks if the field is "Dead" (No remaining creatures).
     * @param field Array representing your field.
     * @return Boolean represeting if the field is dead or not.
     */
    public static Boolean checkIfFieldDead(int[][] field){
        
        int deadBlocks = 0; //Counter to check if a block is dead.
        boolean fieldDead;

        //Itterate through the whole field to see if the blocks are dead or not. If it is, add to
        //the death counter.
        for(int x = 0; x < field.length; x++){
            for(int y = 0; y < field[0].length; y++){
                if(field[x][y] == 0){
                    deadBlocks++;
                }
            }
        }

        //If the amount of dead blocks is equal to the size of the field, the whole field is dead.
        if(deadBlocks >= field.length * field[0].length){
            fieldDead = true;
        }else{
            fieldDead = false;
        }

        return fieldDead;

    }

    /*
     * Getters and setters in order to get analytical data.
     */

    public static int getGeneration() {
        return generation;
    }

    public static int getTotalBirths() {
        return totalBirths;
    }

    public static int getTotalDeaths() {
        return totalDeaths;
    }


    public static void main(String[] args){


        int mySize = 10; //Field size is 10x10

        int[][] field = new int[mySize][mySize]; //Create an empty field.

        placeObjects(field); //Place objects on the field.


        //Increment through the field.
        for(int i = 0; i <=100; i++){

            printField(field);
            nextGen(field);

            if(checkIfFieldDead(field)){
                printField(field);
                System.out.println("======== Field Is Dead ========");
                break;
            }

        }
    }

}