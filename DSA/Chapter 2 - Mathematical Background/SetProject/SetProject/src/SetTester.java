public class SetTester {
    public static void main(String[] args){
        Set setthingy = new Set();
        Set setthingy2 = new Set();
        Set setthingy3 = new Set();
        // setthingy.addElt("George");
        // System.out.println(setthingy);
        // System.out.println("size of my set is: "+setthingy.cardinality());
        // System.out.println(setthingy.contains("George"));
        // System.out.println(setthingy.contains("Gabriel"));
        // System.out.println("Delete Element: "+ setthingy.delElt("HELLO WORLD"));
        // setthingy.addElt("a");
        // setthingy.addElt("b");
        // setthingy.addElt("c");
        // setthingy.addElt("d");
        // setthingy.addElt("e");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("f");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("a");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("e");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("c");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // System.out.println("is the set empty? "+setthingy.isEmpty());
        // setthingy.delElt("d");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("b");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // setthingy.delElt("c");
        // System.out.println("set is: "+setthingy);
        // System.out.println("size size is: "+ setthingy.cardinality());
        // System.out.println("is the set empty? "+setthingy.isEmpty());

        // Create First Set
        setthingy.addElt("a");
        setthingy.addElt("b");
        setthingy.addElt("c");
        setthingy.addElt("d");
        setthingy.addElt("e");
        setthingy.addElt("g");

        // Create Second Set
        setthingy2.addElt("a");
        setthingy2.addElt("f");
        setthingy2.addElt("c");
        setthingy2.addElt("h");

        //Create third Set
        setthingy3.addElt("a");
        setthingy3.addElt("b");
        setthingy3.addElt("c");

        //Print Sets
        System.out.println(setthingy);
        System.out.println(setthingy2);
        System.out.println(setthingy3);

        //Test Set Operations
        System.out.println(setthingy.getIntersect(setthingy2));
        System.out.println(setthingy.getUnion(setthingy2));
        System.out.println(setthingy.getDifference(setthingy2));
        System.out.println("Is the 3rd set a subset of set 2? " + setthingy3.isSubset(setthingy));
        System.out.println("First Set Complement: " + setthingy.getComplement());
    }
}
