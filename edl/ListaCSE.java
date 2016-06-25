package edl;


/**
 * Write a description of class ListaSEC here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ListaCSE<T> implements Lista<T>
{
    private NodoSE<T> inicio;
    private NodoSE<T> fin;
    
    public ListaCSE(){
        inicio = null;
        fin = null;
    }
    public boolean vacio(){
        return inicio == null;       
    }
    public int tamano(){        
        int res = 0;
        if(!vacio()){
            return tamano(inicio);
        }
        return res;
    }
    public int tamano(NodoSE<T> act){        
        int res = 0;
        if(act.equals(fin)){
            res = 1;
        }else{
            res = 1 + tamano(act.getSig()); 
        }
        return res;
    }
    public void insertar(T dato){
        if(vacio()){
            inicio = new NodoSE<T>(dato);
            inicio.setSig(inicio);
            fin =inicio;
        }else{
            NodoSE<T> nuevo = new NodoSE<T>(dato);
            fin.setSig(nuevo);
            nuevo.setSig(inicio);
            fin = nuevo;
        }
        
    }
    public void insertarInicio(T dato){
        if(vacio()){
            inicio = new NodoSE<T>(dato);
            inicio.setSig(inicio);
            fin =inicio;
        }else{
            NodoSE<T> nuevo = new NodoSE<T>(dato);
            nuevo.setSig(inicio);
            fin.setSig(nuevo);
            inicio = nuevo;
        }
    }
    public T eliminarInicio(){
        T res = null;
        if(!vacio()){
            if(inicio.equals(fin)){ // tamano() == 1
                res = inicio.getDato();
                inicio = null;
                fin = null;
            }else{
                res = inicio.getDato(); 
                inicio = inicio.getSig();
                fin.getSig().setSig(null);
                fin.setSig(inicio);
            }
        }
        return res;
    }
    public T eleminarEn(int k){
        T res = null;
        if(!vacio()){
            if(tamano() == 1){
                eliminarInicio();
            }else{
                res = eliminarEn(k-1,inicio);
            }
        }
        return res;
    }
    private T eliminarEn(int k,NodoSE<T> act){
        T res = null;
        if(k==0){           
            res = act.getSig().getDato();
            NodoSE<T> aux = act.getSig();
            act.setSig(act.getSig().getSig());
            aux.setSig(null);
        }else{
            res = eliminarEn(k-1,act.getSig());    
        }
        return res;
    }
    //indice
    /*public int indiceDe(T dato)
    {
        int res; 
        if(vacio()){
            res =  -1;    
        }else{
            res =  indiceDe(dato,inicio);
        }  
        return res;
    }   
    private int indiceDe(T dato,NodoSE<T> act)
    {
        int res = 0;
        if(act.getDato().equals(dato))
        {
            res = 0;
        }else
        {
            if(act.equals(fin))
            {
                res = -1;
            }
            else
            {
                int r = indiceDe(dato,act.getSig());
                if(r != -1)
                {
                    res = 1 + r;
                }else
                {
                    res = -1;
                }
            }
        }
        return res;    
    }*/
    public int indiceDe(T dato)
    {
        int res;
        if(vacio())
            res = -1;
        else
            res = indiceDe(inicio, dato);
        return res;
    }
    private int indiceDe(NodoSE<T>act, T dato)
    {
        int res ;
        if(act.getDato().equals(dato))
            res = 0;
        else
        {
            if(act.equals(fin))
                res = -1;
            else
            {
                int r = indiceDe(act.getSig(),dato);
                if(r == -1)
                    res = -1;
                else
                    res = r + 1;
            }
        }
        return res;
    }
    
}











