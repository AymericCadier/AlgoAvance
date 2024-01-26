package fr.pantheonsorbonne.cri;

import org.junit.jupiter.api.Test;

import fr.pantheonsorbonne.cri.ArrayList.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
public class ArrayListTest {


    @Test
    void TesttoString(){
        ArrayList alist = new ArrayList();
        assertEquals(alist.toString(), "");
        alist.add("a");
        assertEquals(alist.toString(), "a");        
    }

    @Test
    void Testadd(){
        ArrayList alist = new ArrayList();
        assertFalse(alist.add(null));
        assertTrue(alist.add("b"));
        assertTrue(alist.contains("b"));
        assertTrue(alist.add("c"));
        assertTrue(alist.add("d"));
        assertTrue(alist.add("e"));
        assertTrue(alist.add("f"));
        assertTrue(alist.add("g"));
        assertTrue(alist.add("h"));
        assertTrue(alist.size()>4);
        
    }

    @Test
    void TestGet(){
        ArrayList alist = new ArrayList();
        alist.add("a");
        alist.add("b");
        alist.add("c");
        assertEquals(alist.get(1), "b");
        assertEquals(alist.get(8),"erreur");
        assertEquals(alist.get(-2),"erreur");
    }

    @Test
    void TestindexOf(){
        ArrayList alist = new ArrayList();
        alist.add("a");
        alist.add("b");
        alist.add("ab");
        assertEquals(alist.indexOf("b"),1);
        //assertEquals(alist.indexOf("c"),-1);
    }
    
    @Test
    void TestisEmpty(){
        ArrayList alist = new ArrayList();
        assertTrue(alist.isEmpty());
        alist.add("a");
        assertFalse(alist.isEmpty());
    }

    @Test
    void Testremove(){
        ArrayList alist = new ArrayList();
        alist.add("a");
        alist.add("b");
        alist.add("c");
        String temp = alist.toString();
        assertNotEquals(alist.remove(1),temp);
        assertFalse(alist.contains("b"));
        assertEquals(alist.get(1),"c");
        assertEquals(alist.get(2),null);
        assertEquals(alist.toString(),"ac");        
    }

    @Test
    void Testsize(){
        ArrayList alist = new ArrayList();
        alist.add("a");
        alist.add("b");
        assertEquals(alist.size(),2);
    }

    @Test 
    void Testset(){
        ArrayList alist = new ArrayList();
        alist.add("a");
        alist.add("b");
        assertEquals(alist.set(1,"c"),"b");
        assertEquals(alist.toString(),"ac");
    }
}
