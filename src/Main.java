

public class Main {
    public static void main(String[] Args){
        LinkedList<String, String> linkedList = new LinkedList<>();

       linkedList.add("01234", "Ilya");
       linkedList.add("12045", "Max");
       linkedList.add("90343", "Aza");
       linkedList.print();
       linkedList.remove("01234");
       linkedList.print();
       System.out.println("size: " + linkedList.size());
        System.out.println(linkedList.get("01234"));
        linkedList.add("34324", "Angel");
       linkedList.print();

    }
}
