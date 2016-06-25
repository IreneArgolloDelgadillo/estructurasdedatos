package edl;


/**
 * Write a description of class ColaDePrioridad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ColaDePrioridad<T extends Comparable> 
{
    ListaSE<T> cola;
    //private int tam;
    public ColaDePrioridad(){
        cola = new ListaSE<T>();
    }
    public boolean vacio(){
        return cola.vacio();
    }
    
    
    public void insertar(T dato){
        if(cola.vacio()){
            cola.insertar(dato);
        }else{
            int tam = cola.tamano();
            int i = 0;
            while(cola.acceder(i).compareTo(dato) > 0){
                i++;    
            }
            insertarEn(dato,i);
        }        
    }
    private void insertarEn(T dato,int k){
        insertarEn(cola,dato,k);
    }   
    private void insertarEn(ListaSE<T> act,T dato,int k){
        if(act.vacio()){
            act.insertar(dato);
        }else{
            if(k == 0){
                act.insertarIni(dato);    
            }else{
                insertarEn(act.getSig(),dato,k-1);
            }
        }
    }
}
