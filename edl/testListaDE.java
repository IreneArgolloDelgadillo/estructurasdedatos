package edl;



import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testListaDE.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testListaDE
{
    ListaDE<Integer> lista;
    /**
     * Default constructor for test class testListaDE
     */
    public testListaDE()
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
        lista= new ListaDE<Integer>();
        lista.insertar(7);
        lista.insertar(8);
        lista.insertar(9);
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
    public void testBuscar(){
        assertEquals(true , lista.buscar(7));
         assertEquals(false , lista.buscar(78));
    }
    @Test
    public void testAcceder(){
        //lista= new ListaDE<Integer>();
        assertEquals(8, (int)lista.acceder(1));
        assertNull((int) lista.acceder(3));
    }
}
