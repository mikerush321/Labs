
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryHeap {
    private List<Integer> _list = new ArrayList<Integer>();
    public int HeapSize(){ return _list.size(); }

    public void Add(Integer value){
        _list.add(value);
        int i = HeapSize()-1;
        int parent = (i-1)/2;
        while(i>0 && _list.get(parent) <_list.get(i))
        {
            var tmp = _list.get(parent);
            _list.set(parent, _list.get(i));
            _list.set(i, tmp);
            i=parent;
            parent = (i-1)/2;
        }
    }
    private boolean HasLeftDescendant(int rootIndex){
        var i = rootIndex*2+1;
        if(i > _list.size()-1)
            return false;
        return true;
    }
    public Integer FindMinCost(){
        if(_list.size()==0)
            return 0;
        var cost = 0;
        while(!_list.isEmpty()) {
            var min1 = FindMin(0, _list.get(0));
            _list.remove(_list.lastIndexOf(min1));
            if(_list.isEmpty())
                break;
            var min2 = FindMin(0, _list.get(0));
            _list.remove(_list.lastIndexOf(min2));
            cost+=min1+min2;
            Add(min1+min2);
        }
        return cost;
    }
    private Integer FindMin(int rootIndex, int minToCompare){
        if(!HasLeftDescendant(rootIndex)){
            if(rootIndex+1>_list.size()-1)
                return Math.min(minToCompare, _list.get(rootIndex));
            return Math.min(minToCompare, Math.min(_list.get(rootIndex),_list.get(rootIndex+1)));
        }
        minToCompare = FindMin(rootIndex*2+1, minToCompare);
        if(!HasLeftDescendant(rootIndex+1))
            minToCompare = Math.min(_list.get(rootIndex+1),minToCompare);
        else
            minToCompare = FindMin(rootIndex+1, minToCompare);
        return minToCompare;
    }
}