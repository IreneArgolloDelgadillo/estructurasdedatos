package edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testListaCDE.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testListaCDE
{
    ListaCDE<String> lista;
    /**
     * Default constructor for test class testListaCDE
     */
    public testListaCDE()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        lista= new ListaCDE<String>();
        lista.insertar("a");
        lista.insertar("b");
        lista.insertar("c");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        
    }
    @Test
    public void testInsertar(){
        assertEquals("a", lista.acceder(0));
        assertEquals("b", lista.acceder(1));
        assertEquals("c", lista.acceder(2));
    }
    
    @Test
    public void testIndiceDe(){
        assertEquals(0, lista.indiceDe("a"));
    }
    @Test
    public void testAnterior(){
        assertEquals("c", lista.ant("a"));
        assertEquals("b", lista.ant("c"));
        assertEquals(null, lista.ant("k"));
    }
    @Test
    public void testSiguiente(){
        assertEquals("b", lista.suc("a"));
        assertEquals("a", lista.suc("c"));
        assertNull(lista.suc("h"));
    }
    @ Test
    public void testTamano(){
        lista= new ListaCDE<String>();
        assertEquals(0, lista.tamano());
        lista.insertar("s");
        lista.insertar("t");
        lista.insertar("v");
        assertEquals(3, lista.tamano());
        lista.eliminar(0);
        assertEquals(2, lista.tamano());
    }
}
