package Lesson3;

public class ArrayListTest {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        process(arrayList);
    }

    static void process(List list) {
        String separator = "-----------------------------------------------------------------------------";
        System.out.println(separator);
        System.out.println("Process list");
        System.out.println("Add 6 objects "); // 3
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("C");
        System.out.println("List size : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Add J objects into 3rd position "); // 3
        list.add("J", 3);
        System.out.println("List size : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Remove objects from  3rd position "); // 3
        Object removed = list.remove(3);
        System.out.println("Removed object  : " + removed.toString()); // 3
        System.out.println("List size : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Get object in 4th position"); // 3
        Object someObject  = list.get(4);
        System.out.println("Object 4  : " + someObject.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Set object G into 3rd position "); // 3
        list.set("G",3);
        System.out.println("Set object G in 3rd index : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Set object G into 3rd position "); // 3
        list.set("G",3);
        System.out.println("Set object G in 3rd index : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Check if list contains E : " + list.contains("E")); // 3
        //
        System.out.println(separator);
        System.out.println("indexOf E : " + list.indexOf("E")); // 3
        //
        System.out.println(separator);
        System.out.println("LastIndexOf C : " + list.indexOf("C")); // 3
        //
        System.out.println(separator);
        System.out.println("Check if list is empty : " + list.isEmpty()); // 3
        //
        System.out.println(separator);
        System.out.println("Clear list"); // 3
        list.clear();
        System.out.println("Cleared list : " + list.size() + " list : "+ list.toString()); // 3
        //
        System.out.println(separator);
        System.out.println("Check if list is empty : " + list.isEmpty()); // 3
    }
}