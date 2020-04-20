

public class BSTClient {
    public static void main(String[] args)
    {
        BST<Integer, Integer> bst = new BST();
        int MAX=7;
        int [] Example={4,7,3,6,1,2,5};
        for(int i=0;i<Example.length;i++){
            bst.put(Example[i],Example[i]);
        }
        for (int a:bst.keys(1,7)){
        System.out.print(a+" ");
    }
        bst.Rever();
        System.out.print("\n");
        for (int a:bst.keys(1,7)){
            System.out.print(a+" ");
        }
        System.out.println("\n"+bst.min().toString()+" "+bst.max().toString());
    }
}
