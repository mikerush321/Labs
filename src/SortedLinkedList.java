

import java.util.Iterator;

public class SortedLinkedList<Sll extends Comparable> implements Iterable<Sll>{
    protected class Node<Sll>{
        public Node(Sll value){
            _value = value;
        }
        private Sll _value;
        public Sll Get(){ return _value; }
        private Node<Sll> left;
        public Node<Sll> Left() { return left; }
        private Node<Sll> right;
        public Node<Sll> Right(){ return right; }
    }
    private int _length;
    public int Length() { return _length; }
    protected int leftCount,rightCount;
    private Node<Sll> root,median;
    public void Add(Sll value){
        InternalAdd(value);
    }
    public int Median() {
        if (median == null)
            return 0;
        if (leftCount == rightCount && Length() % 2 != 0)
            return (int)median.Get();
        if (Length() % 2 == 0 && leftCount > rightCount) {
            return ((int)median.Get() + (int)median.Left().Get()) / 2;
        }
        else
            return ((int)median.Get() + (int)median.Right().Get()) / 2;
    }
    private void InternalAdd(Sll value){
        var node = new Node<Sll>(value);
        if(root==null){
            root = node;
            median=root;
            _length++;
            return;
        }
        var insertPtr = root;
        while(insertPtr.right != null
                && (insertPtr.right._value.compareTo(value)==-1
                || insertPtr.right._value.compareTo(value)==0))
        {
            insertPtr = insertPtr.right;
        }
        if(insertPtr==root && insertPtr._value.compareTo(value)==1){
            root.left=node;
            node.right=root;
            root=node;
        }
        else if(insertPtr.right==null){
            node.left=insertPtr;
            insertPtr.right=node;
        }
        else{
            node.right=insertPtr.right;
            insertPtr.right.left=node;
            insertPtr.right = node;
            node.left = insertPtr;
        }
        ++_length;
        RestoreMedian(value);
    }
    private void RestoreMedian(Sll value){
        if (value.compareTo(median._value)==0 || value.compareTo(median._value) == 1)
            rightCount++;
        else leftCount++;

        if(leftCount-rightCount==2)
        {
            median = median.left;
            rightCount++;
            leftCount--;
        }
        else if(leftCount-rightCount==-2)
        {
            median = median.right;
            rightCount--;
            leftCount++;
        }
    }
    @Override
    public Iterator iterator() {
        return new Iterator();
    }
    private class Iterator implements java.util.Iterator<Sll> {
        public Iterator(){
            _localRoot = root;
        }
        private Node<Sll> _localRoot;
        @Override
        public boolean hasNext() {
            return _localRoot!=null;
        }
        @Override
        public Sll next() {
            var value = _localRoot._value;
            _localRoot = _localRoot.right;
            return value;
        }
    }
}
