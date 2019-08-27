
public class Main {

    public static void main(String[] args) {

        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);
    }
}