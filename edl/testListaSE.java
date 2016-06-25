package edl;

/**
 * The test class testListaSE.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testListaSE extends junit.framework.TestCase
{
    ListaSE<String> l1;
    ListaSE<String> l2;
    /**
     * Default constructor for test class testListaSE
     */
    public testListaSE()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
   
    public void setUp()
    {
        l1= new ListaSE<String>();
        l1.insertar("a"); 
        l1.insertar("e");
        l1.insertar("i");
        l2= new ListaSE<String>();
        l2.insertar("o");
        l2.insertar("u");
        l2.insertar("i"); 
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */

    public void tearDown()
    {
    }
    

    public void testElimina(){
        assertEquals("a", l1.eliminar("a"));
        assertNull(l1.eliminar("k"));
    }

    public void testIndiceDe(){
        assertEquals(2, l1.indiceDe("i"));
        assertEquals(-1, l1.indiceDe("j"));
    }
    public void testUnirSinRepetir(){
        ListaSE<String> lista= new ListaSE<String>();
        lista=lista.unirSinRepetir(l1, l2);
        assertEquals(true, lista.buscar("a"));
    }

    public void testDividirLista(){
        ListaSE<String> otra= new ListaSE<String>();
        otra= otra.clonar(l1);
        
        ListaSE<String> res= new ListaSE<String>();
        res=res.dividirLista(true, l1);
        assertEquals("a", res.acceder(0));
        assertEquals("i", res.acceder(1));
        
        l1= otra;
        res=res.dividirLista(false, l1);
        assertEquals("e", res.acceder(0));
    }

    public void testClonar(){
        ListaSE<String> otra= new ListaSE<String>();
        otra= otra.clonar(l1);
        assertEquals("a", otra.acceder(0));
    }
    

    public void testReemplazarEn(){
        l1.reemplazarEn("A", 0);
        l1.reemplazarEn("I", 2);
        assertEquals("A", l1.acceder(0));
        assertEquals("e", l1.acceder(1));
        assertEquals("I", l1.acceder(2));
    }
    
    public void testAntecesor(){
        assertEquals("a", l1.antecesor("e"));
    }
    
    
    public void testSucesor(){
        assertEquals("e", l1.sucesor("a"));
    }
    
    
}

