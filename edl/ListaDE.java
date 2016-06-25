package edl;


/**
 * Write a description of class ListaDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ListaDE<T> implements Lista<T>
{
    private NodoDE<T> inicio;
    private NodoDE<T> fin;
    
    public ListaDE(){
        inicio = null;
        fin = null;
    }
    public boolean vacio(){
        return inicio == null;
    }
    public T acceder(int p){
        return acceder(p, inicio);
    }
        private T acceder(int p ,NodoDE<T> inicio){
        T res;
        if(inicio.getDato()==null || p>= tamano())
            res= null;
        else{//if(inicio.getDato()!=null || )
            if(p==0){
                res= inicio.getDato();
                
            }else if(p<0)   res= null;
            else{
                res= acceder(p-1, inicio.getSig());
            }
        }
        return res;
    }
    
    public int tamano(){
        int res = 0;
        if(vacio()){
            res  = 0;
        }else{
            res = tamano(inicio);
        }
        return res;
    }
    private int tamano(NodoDE<T> act){
        int res = 0;
        if(act.equals(fin)){
            res = 1;
        }else{
            res = tamano(act.getSig()) + 1;
        }
        return res;
    }
    public void insertar(T dato){
        NodoDE<T> nuevo = new NodoDE<T>(dato);
        if(vacio()){
            inicio = nuevo;
            fin = nuevo;
        }else{
            nuevo.setAnt(fin);
            fin.setSig(nuevo);
            fin = nuevo;
        }        
    }
    public void insertarIni(T dato){
        if(vacio()){
            insertar(dato);
        }else{
            NodoDE<T> nuevo = new NodoDE<T>(dato);
            nuevo.setSig(inicio);
            inicio.setAnt(nuevo);
            inicio = nuevo;
        }
    }
    public T eliminarEn(int k){
        T res = null;
        if(vacio()){        
            res = null;
        }else{
            if(k >= 1 && k < tamano() -1){
                res = eliminarEn(k,inicio);
            }else{
                if(k == 0){
                    res = eliminarIni();     
                }else{
                    if(k == tamano()-1 ){
                        //res = eliminarFin();
                    }else{
                        res = null;
                    }
                }    
            }
        }
        return res;
    }
    private T eliminarEn(int k,NodoDE<T> act){
        T res = null;
        if(k == 0){
            res = act.getDato();
            act.getAnt().setSig(act.getSig());
            act.getSig().setAnt(act.getAnt());
            act.setSig(null);
            act.setAnt(null);
        }else{
            res = eliminarEn(k-1,act.getSig());
        }
        return res;
    }
    public T eliminarIni(){
        T res = null;
        if(vacio()){
            res = null;
        }else{
            if(tamano() == 1){
                res = inicio.getDato();
                inicio = null;
                fin = null;
            }else{
                res = inicio.getDato();
                inicio = inicio.getSig();
                inicio.getAnt().setSig(null);
                inicio.setAnt(null);
            }
        }
        return res;
    }
    public boolean buscar(T dato){
        return buscar(dato, inicio);
    }
    public boolean buscar(T dato, NodoDE<T> nodo){
        boolean res= false;
        if(!vacio() ){
            if(nodo.getDato().equals(dato)){
               res= true; 
            }else
                res= buscar(dato, nodo.getSig());
        }
        return res;
    }
}
