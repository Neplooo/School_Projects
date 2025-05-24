/**
 * This class comes with all the functions to run a wildfire simulation on different sized grids.
 * @author Alberto
 * @category Simulation
 * @version 1.1
 */
public class WildFire {

    private int gridSize;
    private int[][] grid;
    private int iterations = 0;
    private int initEmptyTiles;

    /**
     * Create an empty wildfire grid
     * @param size The size of the grid
     */
    public WildFire(int size){

        gridSize = size; //Set the grid size
        grid = new int[size][size]; //Create the grid

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y <grid[0].length; y++){
                grid[x][y] = 0; //Fill the grid with empty units (for now)
            }
        }

    }

    /**
     * Create an empty wildfire grid and initialize it randomly with
     * the default parameters of 0.5
     * @param size The size of the grid.
     * @param initRandom Boolean on wether you would like to initialize the grid.
     */
    public WildFire(int size, boolean initRandom){

        gridSize = size; //Set the grid size
        grid = new int[size][size]; //Create the grid

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y <grid[0].length; y++){
                grid[x][y] = 0; //Fill the grid with empty units (for now)
            }
        }

        if(initRandom == true){
            initRandomGrid(0.5, 0.5); //Initialize the grid with the default stats
        }

    }

    /**
     * Initializes the wildfire randomly with parameters that YOU provide!
     * @param size The size of the grid.
     * @param initRandom Boolean representing if you want to initialize the field.
     * @param probTree The probability of randomly spawning a tree.
     * @param probBurning The probability of randomly spawning a burning tree.
     */
    public WildFire(int size, boolean initRandom, double probTree, double probBurning){ //Who up overloading their constructors??

        gridSize = size; //Set the grid size
        grid = new int[size][size]; //Create the grid

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y <grid[0].length; y++){
                grid[x][y] = 0; //Fill the grid with empty units (for now)
            }
        }

        if(initRandom == true){
            initRandomGrid(probTree, probBurning); //Init the random grid with the custom probabilities
        }

    }

    /**
     * Prints out the grid in a human readable context.
     */
    public void printGrid(){
        for(int x = 0; x < grid.length; x++){ 
            for(int y = 0; y <grid[0].length; y++){ //Iterate through every unit
                if(grid[x][y] == 1){ //If tree
                    System.out.print("^"); //Print Tree
                    System.out.print("  ");
                }else if(grid[x][y] == 0){ // If nothing
                    System.out.print(" "); // Print Nothing
                    System.out.print("  ");
                }
                else if(grid[x][y] == 2){ //If Fire
                    System.out.print("*"); // Print Fire
                    System.out.print("  ");
                }
            }
            System.out.println("");
        }
        System.out.println("Iteration: " + getIterations()); //Print the iteration too because information.
        System.out.println("=============================================================");
    }

    /**
     * Iterates the grid and sets new tiles on fire.
     * @param probCatch The probability that a tree catches fire (Must be a double between 0.0 and 1.0)
     * @return The new field
     */
    public int[][] iterateFire(double probCatch){

        int[][] gridCopy = grid;

            for(int x = 0; x < grid.length; x++){
                for(int y = 0; y < grid[0].length; y++){

                    //Check to see if the trees around it are burning

                    boolean isNeighborOnFire = false;

                    //North
                    if(x - 1 >= 0 ){
                        if(grid[x-1][y] == 2){
                            isNeighborOnFire = true;
                        }
                    }
                    //East
                    if(x >= 0 && y-1 >= 0){
                        if(grid[x][y-1] == 2){
                            isNeighborOnFire = true;
                        }
                    }
                    //West
                    if(x - 1 >= 0 && y + 1 < grid[0].length){
                        if(grid[x][y+1] == 2){
                            isNeighborOnFire = true;
                        }
                    }
                    //South
                    if(x + 1 < grid.length && y >= 0){
                        if(grid[x+1][y] == 2){
                            isNeighborOnFire = true;
                        }
                    }

                
                    //If the index was already burning last time, stop the fire there.
                    if(gridCopy[x][y] == 2 && grid[x][y] == 2){
                        gridCopy[x][y] = 0;
                    }

                    if(gridCopy[x][y] == 1){ //If The current index is a tree
                        if(isNeighborOnFire && Math.random() <= probCatch){ //And a neighbor is on fire AS WELL AS the tree decides to catch fire
                            gridCopy[x][y] = 2; // The tree is now on fire
                        }
                    }

                }
            }
        
            grid = gridCopy; //Set the grid to the copy now that we're done.
            iterations++; //Update the iteration counter
            return grid; //Return the grid for funzies

        }

    /**
     * Sets a random coordinate on the field on fire
     * @param x X-Coordinate
     * @param y Y-Coordinate
     */
    public void setFire(int x, int y){
        grid[x][y] = 2; //Set somewhere on fire
    }

    /**
     * Randomly initializes a grid with trees and fire.
     * @param probTree The probability of the tree (0.0-0.1)
     * @param probBurning The probability of a burning tree (0.0-0.1)
     */
    public void initRandomGrid(double probTree, double probBurning){

        //Creating two variables to see if we will have a tree or not
        double isTree;
        double isBurning;

        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                isTree = Math.random(); //Generate a new random number every loop iteration
                isBurning = Math.random();

                if(isTree <= probTree){ //If there is a tree
                    if(isBurning <= probBurning){ //If it's burning
                        //System.out.println("Fire set at: " + x + ", " + y + "!");
                        grid[x][y] = 2; //Make it burn
                    }else{
                        grid[x][y] = 1; //Just put a normal tree
                    }
                }else{
                    grid[x][y] = 0; //Put Nothing
                    initEmptyTiles++; //Update the counter for empty tiles for later
                }
            }
        }
    }

    /**
     * This function calculates and gets the percentages of the field burnt.
     * Note: This takes into account the amount of trees that did not spawn.
     * @return Integer representing the percent of field burnt.
     */
    public int percentOfFieldBurnt(){

        //Calculation variables
        double treesBurnt = 0.0; 
        double burntRatio = 0.0;
        int burntPercent = 0;


        for(int x = 0; x < grid.length; x++){
            for(int y = 0; y < grid[0].length; y++){
                if(grid[x][y] == 0){
                    treesBurnt++; //Find the amount of burnt trees.
                }
            }
        }

        burntRatio = (treesBurnt-initEmptyTiles) / (gridSize*gridSize); //Get the ratio of burnt trees (Don't take into account the default empty tiles)
        burntPercent = (int) (burntRatio * 100); //Turn the ratio into a percentage.

        return burntPercent; //Return it.

    }

    /**
     * Gets the iterations on the field
     * @return iterations
     */
    public int getIterations(){
        return iterations; //Oh getter what would I ever do without you...
    }


    public static void main(String[] args) {
        
        WildFire fire1 = new WildFire(17); //Make a grid.

        fire1.initRandomGrid(1.0, 0.1); //Initialize it.
        fire1.printGrid(); //Print it.

        for(int i = 1; i <= 10; i++){ //Do this 10 times
            fire1.iterateFire(0.6); //Iterate the fire.
            fire1.printGrid(); //Print the results
        }

        //Print some stats out at the end.
        System.out.println("The percentage of trees burnt is: " + fire1.percentOfFieldBurnt() + "% (Accounting for trees that did not spawn)");

    }

}