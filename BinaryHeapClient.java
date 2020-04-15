

import java.util.Random;


public class BinaryHeapClient {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
      /*  heap.Add(5);
        heap.Add(7);
        heap.Add(8);
        heap.Add(3);
        heap.Add(4);
        heap.Add(9);
        heap.Add(1);
*/
        heap.Add(1);
        heap.Add(2);
        heap.Add(3);
        heap.Add(4);
        heap.Add(5);
        heap.Add(6);
        heap.Add(7);
        StdOut.println(" "+heap.FindMinCost().toString());
    }
}