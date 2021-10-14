package IteratorPattern;

import java.util.Iterator;

public class DynamicMapIterator implements Iterator {
    private DynamicMap map;
    private int count;

    public DynamicMapIterator(DynamicMap map){
        this.map = map;
        count = 0;
    }

    @Override
    public boolean hasNext() {
        return count < map.size();
    }

    @Override
    public Object next() {
        Integer key = map.getKeyWithIndex(count);
        count++;
        if(key == -1)
            return null;
        else
            return key;
    }

}
