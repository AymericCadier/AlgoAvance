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
        alist.ajout("c");
        alist.ajout("d");
        alist.ajout("e");
        alist.ajout("f");
        
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
    
}
