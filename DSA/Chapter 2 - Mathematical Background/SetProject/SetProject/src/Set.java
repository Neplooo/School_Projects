import java.util.Arrays;

/**
 * The Set Class. This class contains a list that can be operated on as a set. These operations include things like intersects and complements.
 * @author Albert Mathisz
 */
public class Set
{

   //Constants for max setsize and the Universal Set
   public static  final int SETSIZE = 10000;
   public static final String[] UNIVERSAL_SET = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
   public static final int UNIVERSAL_SET_SIZE = 26; 
   
   //Variables for the object's set and it's size
   private String[] mySet;
   private int size;
   

   /**
    * The standard set constructor. It creates the set and sets the size to 0.
    */
   public Set()
   {
      mySet = new String[SETSIZE];
      size = 0;
   }
   
   /**
    * Gets the size of the function
    * @return size
    */
   public int cardinality()
   {
      return size;
   }
   
   /**
    * Checks to see if the set contains a certain object.
    * @param elt The element the function will check for.
    * @return a boolean representing if the set contains the character or not.
    */
   public boolean contains(String elt)
   {
      boolean response = false;
      int pos = 0;
      while (pos < size && !response)
      {
         //if(mySet[pos] == null){}
         if(mySet[pos].equals(elt))
            response = true;
         else
            pos++;
      }
      return response;
   }
   
   /**
    * Gets the intersect of the current set compared to another set.
    * @param inputSet the other set you would like to compare the current set to.
    * @return A set containing the common characters.
    */
   public Set getIntersect(Set inputSet){

        Set commonChars = new Set();

         for(int i = 0; i<= size; i++){
            if(inputSet.contains(mySet[i]) && !commonChars.contains(mySet[i])){
               commonChars.addElt(mySet[i]);
            }
         }

        return commonChars;

   }

   /**
    * Gets all of the values in the current set compared to another set once.
    * @param inputSet set that the current set is being compared to.
    * @return All values
    */
   public Set getUnion(Set inputSet){

      Set allChars = new Set();

      for(int i = 0; i<= size; i++){
         allChars.addElt(mySet[i]);
      }

      for(int i = 0; i <= inputSet.size; i++){
         if(!allChars.contains(inputSet.getElement(i)) && inputSet.getElement(i) != null){ //If the element isn't already in the common set, add it.
            allChars.addElt(inputSet.getElement(i));
         }
      }

      return allChars;

   }
   
   /**
    * Gets the substraction of the current set to another set.
    * @param inputSet the set being compared to.
    * @return The difference between the two sets.
    */
   public Set getDifference(Set inputSet){

      Set remainingChars = new Set();

      for(int i = 0; i <= size; i++){
         if(!inputSet.contains(mySet[i])){
            remainingChars.addElt(mySet[i]);
         }
      }

      return remainingChars;

   }

   /**
    * Checks to see if the current set is a subset of another set.
    * @param inputSet the set being compared to.
    * @return Boolean representing if the current set is a subset of another set.
    */
   public Boolean isSubset(Set inputSet){

      int valsInSuperSet = 0; //Create a counter to keep track of the amount of values in the superset

      //Each time there is a value in the superset, add to the counter
      for(int i = 0; i <= size; i++){
         if(inputSet.contains(mySet[i])){
            valsInSuperSet++;
         }
      }

      //If all the values of the set are in the input set, it is a subset.
      if(valsInSuperSet == size){
         return true;
      }else{
         return false;
      }

   }

   /**
    * Gets all of the values in the master set that are not in the current set.
    * @return Set containing part of the MASTER_SET
    */
   public Set getComplement(){

      Set complementSet = new Set();

      for(int i = 0; i < UNIVERSAL_SET_SIZE; i++){
         if(!Arrays.stream(mySet).anyMatch(UNIVERSAL_SET[i]::equals)){ //This streams the set to an ArrayList and checks to see if the value provided is in there,
            complementSet.addElt(UNIVERSAL_SET[i]);
         }
      }

      return complementSet;

   }

   /**
    * Appends an element to the end of the set
    * @param elt the element being apppended.
    */
   public void addElt(String elt)
   {
      if(elt != null){
         mySet[size] = elt;
         size += 1;
      }
   }
    

    /**
     * Deletes the element in the set
     * @param elt element being deleted
     * @return The element?
     */
   public String delElt(String elt)
   {
      String retval ="";
      if (this.contains(elt))
      {
         int pos= 0;
         boolean found = false;
         while (pos <size && !found)
            if(mySet[pos].equals(elt))
               found = true;
            else
               pos++;
         for (int np = pos+1; np < size; np++)
         {
            mySet[pos] = mySet[np];
            pos = np;
         }
         size--;
      }
      return retval;
   } 
    
   /**
    * Checks to see if a set is empty
    * @return Boolean representing if the set is empty or not.
    */
   public boolean isEmpty()
   {
      boolean answer = false;
      if (size == 0)
         answer = true;
      return answer;
   }

   /**
    * Gets a value stored in the set
    * @param index The location of the value you are trying to get.
    * @return The value
    */
   private String getElement(int index){

      return mySet[index];

   }
    
    
   public String toString()
   {
      String setOut ="{ ";
      for (int i = 0; i < size; i++){
         if(i == size - 1){
            setOut += mySet[i];
         }else{
         setOut += mySet[i]+ " , ";
         }
      }
      setOut += " }";
      return setOut;
   }
    
}
