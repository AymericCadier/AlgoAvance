package fr.pantheonsorbonne.cri;

import org.junit.jupiter.api.Test;
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
        alist.add("c");
        alist.add("d");
        alist.add("e");
        alist.add("f");
        
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
    
}
