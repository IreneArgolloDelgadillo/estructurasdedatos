package ednl;

import edl.*;
/**
 * Write a description of class ArbolB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolB<T> 
{
    private T raiz;
    private ArbolB<T> izq;
    private ArbolB<T> der;
    
    public ArbolB(){
        izq = null;
        der = null;
        raiz = null;
    }
    public boolean vacio(){
        return raiz == null;
    }
    public void insertarIzq(T dato){
        if(vacio()){
            raiz = dato;
            izq = new ArbolB<T>();
            der = new ArbolB<T>();           
        }else{
            izq.insertarIzq(dato);                        
        }
    }
    public void insertarDer(T dato){
        if(vacio()){
            raiz = dato;
            izq = new ArbolB<T>();
            der = new ArbolB<T>();           
        }else{
            der.insertarDer(dato);                        
        }
    }
    public ArbolB<T> getIzq(){
        return izq;
    } 
    public ArbolB<T> getDer(){
        return der;
    }
    public T eliminar(){
        T res = raiz;
        raiz = null;
        izq = null;
        der = null;
        return res;
    }
    public boolean esHoja(){
        boolean res = false;
        if(izq.vacio() && der.vacio()){
            res = true;
        }
        return res;
    }    
    public void preorden(){               
        if(!esHoja()){
            if(izq.vacio()){
                System.out.println(raiz);
                der.preorden();                
            }else{
                izq.preorden();
                System.out.println(raiz);
                if(!der.vacio()){
                    der.preorden();
                }
            }            
        }else{
            System.out.println(raiz);
        }
    }
    public ListaSE<T> postOrden(){
        ListaSE<T> res=new ListaSE<T>();
        if(!vacio()){
            if(esHoja()){
                res.insertar(raiz);
            }else{                

                res.concatenar(izq.postOrden());                
                res.concatenar(der.postOrden());
                res.insertar(raiz);
            }
        }
        return res;
    }
    public ListaSE<T> getListaNivel(int k){
        ListaSE<T> res = new ListaSE<T>();
        if(!vacio()){
            if(k == 0){
                res.insertar(raiz);
            }else{
                res.concatenar(izq.getListaNivel(k-1));
                res.concatenar(der.getListaNivel(k-1));
            }
        }
        return res;
    }
    public int estados(){
        int res = -1;
        if(!vacio()){
            if(izq.vacio()){
                if(der.vacio()){
                    res = 0;
                }else{
                    res = 2;
                }
            }else{
                if(der.vacio()){
                    res = 1;
                }else{
                    res = 3;
                }
            }      
        }
        return res;
    }
}
