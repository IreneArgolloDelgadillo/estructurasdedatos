package edl;


/**
 * Write a description of class Cola here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cola <T> 
{
    private ListaSE<T> cola;
    
    public Cola(){
        cola = new ListaSE<T>();
    }
    public boolean vacio(){
        return cola.vacio();
    }
    public void encolar(T dato){
        cola.insertar(dato);
    }
    public T ver(){
        return cola.getInicio();        
    }
    public T decolar(){
        T res = null;
        res = cola.getInicio();
        cola = cola.getSig();
        return res;
    }
}
