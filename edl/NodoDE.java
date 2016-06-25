package edl;


/**
 * Write a description of class NodoDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoDE<T>
{
    private T dato;
    private NodoDE<T> sig;
    private NodoDE<T> ant;
    
    public NodoDE(T dato){
        this.dato = dato;
        sig = null;
        ant = null;
    }
    public void setSig(NodoDE<T> s){
        sig = s;
    }
    public void setAnt(NodoDE<T> a){
        ant = a;
    }
    public NodoDE<T> getSig(){
        return sig;
    }
    public NodoDE<T> getAnt(){
        return ant;
    }
    public T getDato(){
        return dato;
    }
    public void setDato(T d){
        dato= d;
    }
    
}
