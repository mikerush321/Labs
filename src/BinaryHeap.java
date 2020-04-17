

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryHeap {
    private List<Integer> list = new ArrayList<Integer>();
    public int HeapSize(){ return list.size(); }
    public void Add(Integer value){
        list.add(value);
        int i = HeapSize()-1;
        int p = (i-1)/2;
        while(i>0 && list.get(p) <list.get(i))
        {
            var tmp = list.get(p);
            list.set(p, list.get(i));
            list.set(i, tmp);
            i=p;
            p = (i-1)/2;
        }
    }
    private boolean HasLeftDescendant(int rI){
        var i = rI*2+1;
        if(i > list.size()-1)
            return false;
        return true;
    }
    private Integer FindMin(int rI, int min){
        if(!HasLeftDescendant(rI)){
            if(rI+1>list.size()-1)
                return Math.min(min, list.get(rI));
            return Math.min(min, Math.min(list.get(rI),list.get(rI+1)));
        }
        min = FindMin(rI*2+1, min);
        if(!HasLeftDescendant(rI+1))
            min = Math.min(list.get(rI+1),min);
        else
            min = FindMin(rI+1, min);
        return min;
    }
    public Integer FindMinCost(){
        if(list.size()==0)
            return 0;
        var c = 0;
        while(!list.isEmpty()) {
            var min1 = FindMin(0, list.get(0));
            list.remove(list.lastIndexOf(min1));
            if(list.isEmpty())
                break;
            var min2 = FindMin(0, list.get(0));
            list.remove(list.lastIndexOf(min2));
            c+=min1+min2;
            Add(min1+min2);
        }
        return c;
    }
}