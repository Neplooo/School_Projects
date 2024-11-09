public class Person {

    //If the variables are being created in a class; USE PRIVATE!!!
    private String name;
    private int age;

    //Standard Constructor
    public Person(){}

    //Contstructor with variables being defined
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    /** Standard Getter for the person's name
     * Preconditions: None
     * Postconditions: Name will be returned
     * @return String name
     */
    public String getName(){
        return name;
    }

    /** Standard Getter for the person's age
     * Preconditions: None
     * Postconditions: Age will be returned
     * @return int age
     */
    public int getAge(){
        return age;
    }

    /**
     * Sets the name of the person
     * @param name String to set name to
     */
    public void setName(String name){
        this.name = name; //This refers to the object. It is telling the program that the name variable belongs to the class.
    }

    /**
     * Sets the age of the person
     * @param age Integer to set age to
     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * Prints the attributes of the person.
     */
    public String toString(){
        return "This is " + name + ". They are " + age + " years old.";
    }

}
