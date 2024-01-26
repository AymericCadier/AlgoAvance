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
        alist.ajout("a");
        assertEquals(alist.toString(), "a");        
    }

    @Test
    void TestAjout(){
        ArrayList alist = new ArrayList();
        assertFalse(alist.ajout(null));
        assertTrue(alist.ajout("b"));
        assertTrue(alist.contains("b"));
        assertTrue(alist.ajout("c"));
        assertTrue(alist.ajout("d"));
        assertTrue(alist.ajout("e"));
        assertTrue(alist.ajout("f"));
        assertTrue(alist.ajout("g"));
        assertTrue(alist.ajout("h"));
        assertTrue(alist.size()>4);
        
    }

    @Test
    void TestGet(){
        ArrayList alist = new ArrayList();
        alist.ajout("a");
        alist.ajout("b");
        alist.ajout("c");
        assertEquals(alist.get(1), "b");
        assertEquals(alist.get(8),"erreur");
        assertEquals(alist.get(-2),"erreur");
    }

    @Test
    void TestindexOf(){
        ArrayList alist = new ArrayList();
        alist.ajout("a");
        alist.ajout("b");
        alist.ajout("ab");
        assertEquals(alist.indexOf("b"),1);
        //assertEquals(alist.indexOf("c"),-1);
    }
    
    @Test
    void TestisEmpty(){
        ArrayList alist = new ArrayList();
        assertTrue(alist.isEmpty());
        alist.ajout("a");
        assertFalse(alist.isEmpty());
    }

    @Test
    void Testremove(){
        ArrayList alist = new ArrayList();
        alist.ajout("a");
        alist.ajout("b");
        alist.ajout("c");
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
        alist.ajout("a");
        alist.ajout("b");
        assertEquals(alist.size(),2);
    }

    @Test 
    void Testset(){
        ArrayList alist = new ArrayList();
        alist.ajout("a");
        alist.ajout("b");
        assertEquals(alist.set(1,"c"),"b");
        assertEquals(alist.toString(),"ac");
    }
}
