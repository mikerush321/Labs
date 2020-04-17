
public class BinaryHeapClient {
    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        int [] Example={1,7,4,3,6,2,5};
        for(int i=0;i<Example.length;i++){
            heap.Add(Example[i]);
        }
        System.out.println("Оптимальная стоимость: "+heap.FindMinCost().toString());
    }
}