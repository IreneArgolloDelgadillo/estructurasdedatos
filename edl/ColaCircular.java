package edl;

 


/**
 * Clase que describe elementos de la clase cola circular
 * 
 * @author MLBC
 * @version 2008
 */
public class ColaCircular<T> extends Cola<T>
{
    private int frente; // direcciona a la celda 
                        // que contiene el elemento 
                        // a atender
    private int fin;    // direcciona a la celda 
                        // "supuestamente vacia" en 
                        // la que se ingresara un 
                        // nuevo elemento
    private Object[] datos;
    public ColaCircular(int cap)
    {
        datos = new Object[cap];
        frente = fin = 0;
    }
    public boolean vacia()
    {
        return datos[frente] == null;
    }
    public void encolar(T d)
    {
        if(datos[fin] == null)
        {
            datos[fin] = d;
            fin = (fin+1) % datos.length;
        }
    }
    public T decolar()
    {
        T res;
        if(vacia())
           res = null;
        else
        {
            res = (T)datos[frente];
            datos[frente] = null;
            frente = (frente + 1) % datos.length;
        }
        return res;
    }
    public T ver()
    {
        T res;
        if(vacia())
           res = null;
        else
            res = (T)datos[frente];
        return res;
    }
}
