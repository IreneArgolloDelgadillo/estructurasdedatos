package edl;


/**
 * Write a description of class ListaSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaSE<T> implements Lista<T>,  Comparable<ListaSE<T>>
{
    private T inicio;
    private ListaSE<T> sig;
    
    public ListaSE()
    {
        inicio = null;
        sig = null;       
    }
    
    
    @Override
    public int compareTo(ListaSE<T> lista){
        int res=0;
        if(tamano()< lista.tamano())
            res=-1;
        else
            res=1;
            return res;
    }
    public ListaSE(ListaSE<T> otro)
    {
      inicio = otro.inicio;
      sig = otro.sig;
    }
    public boolean vacio()
    {
        boolean res = false;
        if(inicio == null)
        {
            res = true;
        }
        return res;
    }
    
    public boolean buscar(T d){
        boolean res;
        if(vacio()) res= false;
        else if(inicio.equals(d))  res= true;
        else{
                res= sig.buscar(d);
            }
        return res;
    }
    public int tamano()
    {
        int res = 0;
        if(vacio())
        {
            res = 0;
        }else
        {
            res = 1 + sig.tamano();
        }           
        return res;
    }  
    public void insertar(T dato)
    {
        if(vacio())
        {
            inicio = dato;
            sig = new ListaSE<T>();
        }else
        {
            sig.insertar(dato);        
        }
    }
    public void insertarIni(T dato)
    {
        if(vacio())
        {
            //insertar(dato);
            inicio = dato;
            sig = new ListaSE<T>();
        }else
        {
            sig = new ListaSE<T>(this);
            inicio = dato;
        }
    }
    public T eliminarEn(int k)
    {
        T res = null;
        if(k == 0)
        {
            res = inicio;
            inicio = sig.inicio;
            sig = sig.sig;
        }else
        {
            if(sig.vacio())
            {
                res = inicio;
                inicio = sig.inicio;
                sig = sig.sig;
            }else
            {
                res = sig.eliminarEn(k-1);
            }
        }
        return res;
    }
    
    public T eliminar(T dato){
        T res= null;
        if(!vacio()){
            if(inicio.equals(dato)){
                res= inicio;
                inicio= sig.inicio;
                sig= sig.sig;
            }
            else res= sig.eliminar(dato);
        }
        return res;
    }
    public T eliminarFin()
    {
        T res = null;
        if(!vacio())
        {
            if(sig.vacio())
            {
                res = inicio;
                inicio = null;
                sig = null;
            }else
            {
                res = sig.eliminarFin();
            }
        }
        return res;
    }
    
    
    public int indiceDe(T dato)
    {
        int res;
        if(!vacio())
        {
            if(inicio.equals(dato))  
                res = 0;
            else
            {
                res = sig.indiceDe(dato);
                if(res == -1)
                    res = -1;
                else
                    res = res + 1;
            }
        }
        else
            res = -1;
        return res;
    }
    
    public T acceder(int k){
        T res;
        if(vacio()){
            res = null;
        }else{
            if(k == 0){
                res = inicio;
            }else{
                res = sig.acceder(k-1);
            }
        }
        return res;
    }
   
    public ListaSE<T> invertirLista()
    {
        ListaSE<T>res = new ListaSE<T>();
        return invertirLista(res);
    }
    private ListaSE<T> invertirLista(ListaSE<T>invertido)
    {   
        ListaSE<T>res;
        if(vacio())
        {
            res = invertido;
        }
        else
        {
            invertido.insertarIni(inicio);
            res = sig.invertirLista(invertido);
        }
        return res;
    }
    public T getInicio(){
        return inicio;
    }
    public ListaSE<T> getSig(){
        return sig;
    }
    
    public void concatenar(ListaSE<T> otro){
        if(vacio()){
            inicio = otro.inicio;
            sig = otro.sig;
        }else{
            sig.concatenar(otro);
        }
    }
    public void mostrar(){
        if(!vacio()){
            System.out.print("-"+inicio.toString());
            sig.mostrar();
        }
    }
    public ListaSE<T> invertir(ListaSE<T> lista){
        ListaSE<T> res= new ListaSE<T>();
        while (lista.vacio()==false){
            res.insertar(lista.eliminarEn(lista.tamano()-1));
        }
        return res;
    }
    
    public ListaSE<T> unirSinRepetir(ListaSE<T> l1, ListaSE<T>l2){
        ListaSE<T> res= new ListaSE<T>();
        while(!l1.vacio()){
            if(res.buscar(l1.acceder(0))== false){
                res.insertar(l1.eliminarEn(0));
            }else{
                l1.eliminarEn(0);
            }
        }
        while(!l2.vacio()){
            if(res.buscar(l2.acceder(0))== false){
                res.insertar(l2.eliminarEn(0));
            }else{
                l2.eliminarEn(0);
            }
        }
        return res;
    }
    private ListaSE (T dato){
        inicio= dato;
        sig= null;
    }
    public ListaSE<T> dividirLista(boolean ver1ºmitad, ListaSE<T> orig){
        ListaSE<T> res=new ListaSE<T>();
        ListaSE<T> l1= new ListaSE<T>();
        ListaSE<T> l2= new ListaSE<T>();
        while(!orig.vacio()){
            if(!orig.vacio()){
                l1.insertar(orig.eliminarEn(0));
            }
            if(!orig.vacio()){
                l2.insertar(orig.eliminarEn(0));
            }
        }
        res= ver1ºmitad==true?l1: l2;
        return res;
    }
    public ListaSE<T> clonar(ListaSE<T> original){
        ListaSE<T> otra= new ListaSE<T>(original.getInicio());
        otra.sig=original.sig;
        return otra;
    }
    public void reemplazarEn(T dato, int i){
        if(!vacio()){
            if(i==0){
                inicio= dato;
            }else{
                sig.reemplazarEn(dato, i-1);
            }
        }
    }
    public T sucesor(T dato){
        T res= null;
        if(!vacio()){
            if(dato.equals(inicio)){
                res= sig.inicio;
            }else{
                res= sig.sucesor(dato);
            }
        }
        return res;
    }
    public T antecesor(T dato){
        T res= null;
        if(!vacio()){
            if(sig.inicio.equals(dato)){
                res=inicio;
            }else{
                res= sig.antecesor(dato);
            }
        }
        return res;
    }
}
























