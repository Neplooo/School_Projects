public class Dog {
    
    private String sex;
    private String name;
    private String breed;
    private int age;
    private boolean isDead;

    public Dog(){

    }

    public Dog(String name, String sex, String breed, int age, boolean isDead){
        this.name = name;
        this.sex = sex;
        this.breed = breed;
        this.age = age;
        this.isDead = isDead;
    }

    public String toString(){
        return "This is " + name + ". It is a " + sex + ". It has the breed of " + breed + ".";
    }

    public String getName(){
        return name;
    }

    public String getSex(){
        return sex;
    }

    public String getBreed(){
        return breed;
    }

    public int getAge(){
        return age;
    }

    public boolean getIsDead(){
        return isDead;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setBreed(String breed){
        this.breed = breed;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setDeath(boolean isDead){
        this.isDead = isDead;
    }

    public void speak(){
        System.out.println("Bark!");
    }
    

}
