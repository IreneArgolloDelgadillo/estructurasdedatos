package ednl;

import edl.*;
/**
 * Write a description of class ArbolN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArbolN<T>
{
    private T raiz;
    private ArbolN<T>[] hijos;
    
    public ArbolN(int n){
        raiz= null;
        hijos=new ArbolN[n];
    }
    
    public boolean vacio(){
        return raiz==null;
    }
    public void insertar(T dato){
        Cola<ArbolN<T>> cola= new Cola<ArbolN<T>>();
        cola.encolar(this);
        insertar(dato, cola);
    }
    private void insertar(T d,Cola<ArbolN<T>>c){
        ArbolN<T>arb = c.decolar();
        if(arb.vacio()){
            arb.raiz = d;
            arb.llenarHijos(0);
        }else{
            arb.encolarHijos(c,0);
            insertar(d,c);
        }
    }
    private void llenarHijos(int i){
        if(i < hijos.length){
            hijos[i] = new ArbolN<T>(hijos.length);
            llenarHijos(i+1);
        }
    }
    
    public T buscar(T d){
        T res = null;
        if(!vacio()){
            if(raiz.equals(d))
                res = raiz;
            else{
                int i = 0;
                while(i < hijos.length && res == null){
                    if(!hijos[i].vacio()){
                        if(hijos[i].raiz.equals(d))
                            res = hijos[i].raiz;
                        else
                            res = hijos[i].buscar(d);
                    }
                    i++;
                }
            }
        }
        return res;
    }
     public ListaSE<T>recorridoProf(){
        ListaSE<T>res = new ListaSE<T>();
        if(!vacio()){
            //res.insertarFinal(raiz);
            res.concatenar(recorridoProfHijos(0));
        }
        return res;
    }
    private ListaSE<T>recorridoProfHijos(int i){
        ListaSE<T>res = new ListaSE<T>();
        while(i < hijos.length){
            res.insertar(raiz);
            res.concatenar(hijos[i].recorridoProf());
            //res.concatenar(recorridoProfHijos(i+1));
            i++;
        }
        return res;
    }
    public ListaSE<T>recorridoProf2(){
        ListaSE<T>res = new ListaSE<T>();
        if(!vacio()){
            Cola<ArbolN<T>>c = new Cola<ArbolN<T>>();
            c.encolar(this);
            ArbolN<T>arb = c.decolar();
            res.insertar(arb.raiz);
            for(int i = 0;i < hijos.length ; i++){
                if(!hijos[i].vacio())
                    res.concatenar(hijos[i].recorridoProf2());
            }
        }
        return res;
    }
    public void mostrarRecorridoProf(){
        ListaSE<T>res = new ListaSE<T>();
        res = recorridoProf();
        System.out.println(res.toString());
    }
    public void mostrarRecorridoProf2(){
        ListaSE<T>res = new ListaSE<T>();
        res = recorridoProf2();
        System.out.println(res.toString());
    }
    public boolean nodoHoja(){
        boolean res=false;
        if(!vacio()){
            for(int i=0; i<= hijos.length; i++)
                if(this.hijos[i]==null)
                    res=true;
                else 
                    res= false;
         }
        return res;
    }
    private void encolarHijos(Cola<ArbolN<T>>c,int i){
        if(i < hijos.length){
            c.encolar(hijos[i]);
            encolarHijos(c,i+1);
        }
    }
    public int nivel(){
        int res=-1;
        if(!vacio()){
            if(nodoHoja()== false){
                res=nivel()+1;
            }
        }
        return res;
    }
}
