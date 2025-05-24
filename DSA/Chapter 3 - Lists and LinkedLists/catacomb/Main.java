import catacomb.*;

public class Main {
   /* Change this constant to contain your name.
    *
    * WARNING: Once you've set set this constant and started exploring your maze,
    * do NOT edit the value of YourName. Changing YourName will change which
    * maze you get back, which might invalidate all your hard work!
    * 
    */
   public static final String YOUR_NAME = "Albert";  //MUST BE PUBLIC

   /* Change these constants to contain the paths out of your mazes. These variables MUST BE PUBLIC*/
   public static final String PATH_OUT_OF_MAZE  = "ESWSESWENWWWSEWNNNESN";
   public static final String  PATH_OUT_OF_TWISTY_MAZE = "SWNSESNNEWWSS";

   public static void main(String[] args) {
      MazeCell startLocation = MazeUtilities.mazeFor(YOUR_NAME);
      
      /* Set a breakpoint here to explore your maze! */
      
      if (myEscape(startLocation, PATH_OUT_OF_MAZE)) {
         System.out.println("Congratulations! You've found a way out of your catacomb.");
      } else {
         System.out.println("Sorry, but you're still stuck in your catacomb.");
      }
      
      
      MazeCell twistyStartLocation = MazeUtilities.twistyMazeFor(YOUR_NAME);
      
      /* Set a breakpoint here to explore your twisty maze! */
      
      if (myEscape(twistyStartLocation, PATH_OUT_OF_TWISTY_MAZE)) {
         System.out.println("Congratulations! You've found a way out of your twisty catacomb.");
      } else {
         System.out.println("Sorry, but you're still stuck in your twisty catacomb.");
      }
   }
   
   /* TODO: IMPLEMENT THIS METHOD TO DETERMINE IF YOUR ESCAPE SEQUENCE IS VALID.
    *       > DID YOU COLLECT ALL THE ITEMS? ORDER SHOULD NOT MATTER.
    *       > DID YOU MAKE ANY INVALID MOVES? YOUR PROGRAM SHOULD NOT CRASH! */
   public static boolean myEscape(MazeCell start, String moves){

      //final variable that determines if the escape worked or not.
      boolean escapeSuccess;

      //Booleans that store info on wether the objects are found or not.
      boolean isSpellbookFound = false;
      boolean isWandFound = false;
      boolean isPotionFound = false;
      boolean isAllObjFound = isPotionFound && isWandFound && isSpellbookFound;

      //Boolean checking if the path is legal.
      boolean isPathIllegal = false;

      //Marker for the path and dependencies for moving and such.
      MazeCell path = start;
      int pathLength = moves.length();
      int moveCounter = 0;

      //While the path has not been finished and the items have not been found -> Iterate
      while(!isAllObjFound && (moveCounter < pathLength) && !isPathIllegal){

         //See if there is something here.
         switch (path.whatsHere) {
            case "Spellbook": //If there is a spell book;
               //System.out.println("Spellbook Found!");
               isSpellbookFound = true; //Add it to our collection
               break;
            case "Potion":
               //System.out.println("Potion Found!");
               isPotionFound = true;
               break;
            case "Wand":
               //System.out.println("Wand Found!");
               isWandFound = true;
               break;
            default:
               //System.out.println(path.whatsHere);
               break;
         }

         //Parse the moves string depending on where we are in the code.
         String direction = moves.substring(moveCounter, moveCounter+1);

         //Check the direction
         switch (direction) {
            case "N": //If the path is north
               if(path.north != null){ //And there is a path northwards
                  path = path.north; //Increment the path northwards
               }else{
                  isPathIllegal = true; //You tried to move in an invalid direction.
               }
               break;
            case "E": //If the path is east
               if(path.east != null){ //And there is a path 
                  path = path.east; //Increment the path 
               }else{
                  isPathIllegal = true; //You tried to move in an invalid direction.
               }
               break;
            case "W": // If the path is west.
               if(path.west != null){ //And there is a path 
                  path = path.west; //Increment the path 
               }else{
                  isPathIllegal = true; //You tried to move in an invalid direction.
               }
               break;
            case "S": //If the path is south
               if(path.south != null){ //And there is a path 
                  path = path.south; //Increment the path 
               }else{
                  isPathIllegal = true; //You tried to move in an invalid direction.
               }
               break;
            default:
               break;
               
         }

         moveCounter++; //Increment the moves.

      }

      if(isPotionFound && isWandFound && isSpellbookFound){//If all objects are found, We're good to go.
         escapeSuccess = true;
      }else{ //If not, the path is not good.
         escapeSuccess = false;
      }

      return escapeSuccess; //Return the success or failure.
   }
}
