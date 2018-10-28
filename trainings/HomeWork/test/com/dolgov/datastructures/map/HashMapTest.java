package test.com.dolgov.datastructures.map;

import com.dolgov.datastructures.map.HashMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class HashMapTest {
    HashMap<String, Integer> hashMapWithData;

    @Before
    public void before() {
        hashMapWithData = new HashMap();
        hashMapWithData.put("A",1);
        hashMapWithData.put("B",2);
        hashMapWithData.put("C",3);
    }

    @Test
    public void put() {
        hashMapWithData.put("D",4);
        hashMapWithData.put("E",5);
        hashMapWithData.put("F",6);
        assertEquals(6,hashMapWithData.size());
    }

    @Test
    public void putIfAbsent() {
        hashMapWithData.put("D",4);
        hashMapWithData.put("E",5);
        hashMapWithData.put("F",6);
        hashMapWithData.put("E",55);
        hashMapWithData.put("H",7);
        assertEquals(7,hashMapWithData.size());
    }

    @Test
    public void get() {
        hashMapWithData.put("D",4);
        hashMapWithData.put("E",5);
        hashMapWithData.put("F",6);
        hashMapWithData.put("E",55);
        hashMapWithData.put("G",7);
        Object getResult = hashMapWithData.get("F");
        assertEquals(6,(int)getResult);
    }

    @Test
    public void remove() {
        hashMapWithData.put("D",4);
        hashMapWithData.put("E",5);
        hashMapWithData.put("F",6);
        hashMapWithData.put("G",7);
        Object getResult = hashMapWithData.remove("E");
        assertEquals(5,(int)getResult);
        assertEquals(6,hashMapWithData.size());
    }

    @Test
    public void size() {
        assertEquals(3,hashMapWithData.size());
    }

    @Test
    public void containsKey() {
        assertEquals(false,hashMapWithData.containsKey("H"));
        assertEquals(true,hashMapWithData.containsKey("A"));
    }

    @Test
    public void iterator() {
        Iterator iterator = hashMapWithData.iterator();
        int entryCount = 0;

        for (Object element : hashMapWithData ) {
            entryCount +=1;
        };
        assertEquals(entryCount , 3);
    }
}