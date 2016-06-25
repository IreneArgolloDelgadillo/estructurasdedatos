package edl;


/**
 * Write a description of class Pila here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pila<T> 
{
    private T tope;
    private Pila<T> base;
    private int tam;
    public Pila(){
        tope = null;
        base = null;
    }
    public Pila(Pila<T> otro){
        tope = otro.tope;
        base = otro.base;
    }
    public boolean empty(){
        return tope == null;
    }
    public void push(T dato){
        if(empty()){
            tope = dato;
            base = new Pila<T>();
            tam++;
        }else{
            base = new Pila(this);
            tope = dato;
            tam++;
        }
    }
    public T top(){
        return tope;
    }
    public T pop(){
        T res = null;
        if(empty()){
            res = null;
            tam--;
        }else{
            res = tope;
            tope = base.tope;
            base = base.base;
            tam--;
        }
        return res;
    }
    public int tamano(){
        return tam;
    }
}
