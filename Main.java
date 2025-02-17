import com.dsa.doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        doublyLinkedList list = new doublyLinkedList();

        list.insert(0);
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4,0);

        list.delete();

        list.display();
    }
}
