public class App {
    public static void main(String[] args) throws Exception {
        SomeLinkedList sll = new SomeLinkedList<>();
        sll.add("первый");
        sll.add("второй");
        sll.add("третий");
        sll.add("четвертый");
        sll.add("пятый");

        System.out.println(sll.size());
        for (Object item : sll) {
            System.out.println(item);
        }
    }
}
