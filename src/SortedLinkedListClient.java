
import java.util.Random;

public class SortedLinkedListClient {
    public static void main(String[] args) {
        var linkedList = new SortedLinkedList();
        var rnd = new Random();
        for (int i = 0; i < 21; i++) {
            linkedList.Add(rnd.nextInt(50));
        }
        for (var x: linkedList)
            System.out.print(x+" ");
        System.out.println("\nМедиана: "+linkedList.Median());

        var linkedList2 = new SortedLinkedList();
        for (int i = 0; i < 20; i++) {
            linkedList2.Add(rnd.nextInt(50));
        }
        for (var x: linkedList2)
            System.out.print(x+" ");
        System.out.println("\nМедиана: "+linkedList2.Median());
    }
}