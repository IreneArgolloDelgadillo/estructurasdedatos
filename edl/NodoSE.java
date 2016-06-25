package edl;


/**
 * Write a description of class NodoSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoSE<T>
{
    private T dato;
    private NodoSE<T> sig;
    
    public NodoSE(T dato){
        this.dato=dato;
        sig = null;
    }
    public void setSig(NodoSE<T> sig){
        this.sig = sig;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T nuevo){
        dato = nuevo;
    }
    public NodoSE<T> getSig(){
        return sig;
    }
}
