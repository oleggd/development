import com.dolgov.datastructures.list.LinkedList;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {
    LinkedList arrayWithData;

    @Before
    public void before() {
        arrayWithData = new LinkedList();
        arrayWithData.add("str1");
        arrayWithData.add("str2");
        arrayWithData.add("str3");
    }


    @Test
    public void testAddIntoEmptyList() {
        arrayWithData.clear();
        assertEquals(arrayWithData.size(), 0);

        arrayWithData.add("one");
        assertEquals(arrayWithData.get(0), "one");
        assertEquals(arrayWithData.size(), 1);
    }

    @Test
    public void testAddIntoNotEmptyList() {
        arrayWithData.add("str4");
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "str2");
        assertEquals(arrayWithData.get(2), "str3");
        assertEquals(arrayWithData.get(3), "str4");
        assertEquals(arrayWithData.size(), 4);
    }

    @Test
    public void testAddEnsureCapacity() {
        arrayWithData.add("str4");
        arrayWithData.add("str5");
        arrayWithData.add("str6");
        assertEquals(arrayWithData.get(5), "str6");
        assertEquals(arrayWithData.size(), 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexInvalidIndex() {
        arrayWithData.add("str5", 4);
    }

    @Test
    public void testAddIndexEmptyList() {
        arrayWithData.clear();
        assertEquals(arrayWithData.size(), 0);
        arrayWithData.add("begin", 0);
        assertEquals(arrayWithData.get(0), "begin");
        assertEquals(arrayWithData.size(), 1);
    }

    @Test
    public void testAddIndexBegin() {
        arrayWithData.add("begin", 0);
        assertEquals(arrayWithData.get(0), "begin");
        assertEquals(arrayWithData.get(1), "str1");
        assertEquals(arrayWithData.get(2), "str2");
        assertEquals(arrayWithData.get(3), "str3");
        assertEquals(arrayWithData.size(), 4);
    }

    @Test
    public void testAddIndexCenter() {
        arrayWithData.add("center", 1);
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "center");
        assertEquals(arrayWithData.get(2), "str2");
        assertEquals(arrayWithData.get(3), "str3");
        assertEquals(arrayWithData.size(), 4);
    }

    @Test
    public void testAddIndexEnd() {
        arrayWithData.add("end", 3);
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "str2");
        assertEquals(arrayWithData.get(2), "str3");
        assertEquals(arrayWithData.get(3), "end");
        assertEquals(arrayWithData.size(), 4);
    }

    @Test
    public void testIndexOfNull() {
        arrayWithData.add(null);
        arrayWithData.add("str5");
        int actual = arrayWithData.indexOf(null);
        assertEquals(actual, 3);
    }

    @Test
    public void testIndexOf() {
        int actual = arrayWithData.indexOf("str2");
        assertEquals(actual, 1);
    }

    @Test
    public void testIndexOfDoesNotExist() {
        int actual = arrayWithData.indexOf("str50");
        assertEquals(actual, -1);
    }

    @Test
    public void testLastIndexOfNull() {
        arrayWithData.add(null);
        arrayWithData.add(null);
        int actual = arrayWithData.lastIndexOf(null);
        assertEquals(actual, 4);
    }

    @Test
    public void testLastIndexOf() {
        arrayWithData.add("str2", 2);
        int actual = arrayWithData.lastIndexOf("str2");
        assertEquals(actual, 2);
    }

    @Test
    public void testLastIndexOfDoesNotExist() {
        int actual = arrayWithData.lastIndexOf("str50");
        assertEquals(actual, -1);
    }

    @Test
    public void testContainsTrue() {
        assertTrue(arrayWithData.contains("str3"));
    }

    @Test
    public void testContainsFalse() {
        assertFalse(arrayWithData.contains("str50"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetInvalidIndex() {
        arrayWithData.set("str4", 3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetEmptyList() {
        arrayWithData.clear();
        assertEquals(arrayWithData.size(), 0);
        arrayWithData.set("setValue", 0);
        assertEquals(arrayWithData.get(0), "setValue");
        assertEquals(arrayWithData.size(), 1);
    }

    @Test
    public void testSetBegin() {
        arrayWithData.set("setValue", 0 );
        assertEquals(arrayWithData.get(0), "setValue");
        assertEquals(arrayWithData.get(1), "str2");
        assertEquals(arrayWithData.get(2), "str3");
        assertEquals(arrayWithData.size(), 3);
    }

    @Test
    public void testSetCenter() {
        arrayWithData.set( "setValue", 1);
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "setValue");
        assertEquals(arrayWithData.get(2), "str3");
        assertEquals(arrayWithData.size(), 3);
    }

    @Test
    public void testSetEnd() {
        arrayWithData.set("setValue", 2 );
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "str2");
        assertEquals(arrayWithData.get(2), "setValue");
        assertEquals(arrayWithData.size(), 3);
    }

    @Test
    public void testClear() {
        arrayWithData.clear();
        assertEquals(arrayWithData.size(), 0);
    }

    @Test
    public void testGetBegin() {
        Object actual = arrayWithData.get(0);
        assertEquals(actual, "str1");
    }

    @Test
    public void testGetCenter() {
        Object actual = arrayWithData.get(1);
        assertEquals(actual, "str2");
    }

    @Test
    public void testGetEnd() {
        Object actual = arrayWithData.get(2);
        assertEquals(actual, "str3");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetInvalidIndex() {
        arrayWithData.get(50);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmptyList() {
        arrayWithData.clear();
        assertEquals(arrayWithData.size(), 0);
        arrayWithData.remove(0);
    }

    @Test
    public void testRemoveBegin() {
        arrayWithData.remove(0);
        assertEquals(arrayWithData.get(0), "str2");
        assertEquals(arrayWithData.get(1), "str3");
        assertEquals(arrayWithData.size(), 2);
    }

    @Test
    public void testRemoveCenter() {
        arrayWithData.remove(1);
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "str3");
        assertEquals(arrayWithData.size(), 2);
    }

    @Test
    public void testRemoveEnd() {
        arrayWithData.remove(2);
        assertEquals(arrayWithData.get(0), "str1");
        assertEquals(arrayWithData.get(1), "str2");
        assertEquals(arrayWithData.size(), 2);
    }


}

/*
package test.com.dolgov.datastructures.list;

import com.dolgov.datastructures.list.LinkedList;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.NoSuchElementException;

public class LinkedListTest {

        @Test
        public void testAddAndRemove() {
            LinkedList linkedList = new LinkedList();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add("C");
            linkedList.add("D",3);
            // ----
            //System.out.println(linkedList.toString());
            assertEquals(5, linkedList.size());
            //---------------------------------------------------
            assertEquals("B", linkedList.remove(1));
            assertEquals("D", linkedList.remove(2));
            assertEquals(3, linkedList.size());
            assertEquals("C", linkedList.remove(1));
            assertEquals("A", linkedList.remove(0));
            assertEquals(1, linkedList.size());
        }

        @Test
        public void testGetListElement (){
            LinkedList linkedList = new LinkedList();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add("D",3);
            assertEquals("C", linkedList.get(2));

        }

        @Test
        public void testSetListElement (){
            LinkedList linkedList = new LinkedList();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add("D",3);
            linkedList.set("F",2);
            assertEquals("F", linkedList.get(2));

        }

        @Test
        public void testClear (){
            LinkedList linkedList = new LinkedList();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add("D",3);
            assertEquals(4, linkedList.size());
            linkedList.clear();
            assertEquals(0, linkedList.size());
            assertEquals(true, linkedList.isEmpty());

        }

        @Test
        public void testContainsAdnIndex (){
            LinkedList linkedList = new LinkedList();
            linkedList.add("A");
            linkedList.add("B");
            linkedList.add("C");
            linkedList.add("C");
            linkedList.add("D",3);

            assertEquals(5, linkedList.size());
            assertEquals(false, linkedList.contains("F"));
            assertEquals(true, linkedList.contains("D"));
            assertEquals(-1, linkedList.indexOf("F"));
            assertEquals(-1, linkedList.lastIndexOf("F"));
            assertEquals(2, linkedList.indexOf("C"));
            assertEquals(4, linkedList.lastIndexOf("C"));
        }

        */
/*@Test(expected = NoSuchElementException.class)
        public void testPeekOnEmtpyQueue (){
            ArrayQueue arrayQueue = new ArrayQueue();
            arrayQueue.peek();
        }*//*



    }

*/
