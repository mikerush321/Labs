package lab6;

import java.rmi.NoSuchObjectException;

public class BSTBreaker<T extends Comparable<T>> extends SimpleBST<T>{
    public void Replace(T find, T replace) throws NoSuchObjectException {
        if(find == null || replace==null)
            throw new NullPointerException("Найден или заменен ноль");
        if(Root()==null)
            throw new NullPointerException("Корень нуловой");

        var node = Find(Root(), find);
        if(node==null)
            throw new NoSuchObjectException("Не смог найти"+find+" объект");
        node.SetValue(replace);
    }
    private TreeNode Find(TreeNode root, T find){
        if(root==null)
            return null;
        if(root.GetValue().compareTo(find)==0) return root;
        if(root.GetValue().compareTo(find)>0){
            return Find(root.GetLeft(),find);
        }
        else
            return Find(root.GetRight(),find);
    }
}
