package edl;





    /**
 * Write a description of class ListaCDE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCDE<T> implements Lista<T>
{
    private NodoDE<T> ini;
    private int tam;
    public ListaCDE()
    {
        ini = null;
    }
    public boolean vacia()
    {
        return ini == null;
    }
    
    public void insertar(T d)
    {
        NodoDE<T> p = new NodoDE<T>(d);
        if(vacia())
        {
            ini = p;
            ini.setSig(ini);
            ini.setAnt(ini);
            tam++;
        }
        else
        {
            NodoDE<T> q = ini.getAnt();
            q.setSig(p);
            p.setAnt(q);
            p.setSig(ini);
            ini.setAnt(p);
            tam++;
        }
    }
    
    public T acceder(int i)
    {
        T res;
        if (vacia())
            res = null;
        else
        {
            NodoDE<T> q = buscar(i, ini);
            res = q.getDato();
        }
        return res;
    }
    public T eliminar(int i)
    {
        T res;
        if (vacia())
            res = null;
        else
        {
            NodoDE<T> q = buscar(i, ini);
            res = q.getDato();
            (q.getAnt()).setSig(q.getSig());
            q.getSig().setAnt(q.getAnt());
            if (q == ini)
                ini= q.getSig();
            tam--;
        }
        return res;
    }
    public int tamano(){
        return tam ;
    }
    public int indiceDe(T dato)
    {
        return indiceDe(dato, ini);
    }
    private int indiceDe(T dato, NodoDE<T> nodo){
        int res=-1;
        if(!vacia() && buscar(dato)!=null){
            
            if(dato.equals(nodo.getDato())){
                res=res+1;
            }else{
               res=1+ indiceDe(dato, nodo.getSig());
            }
        }
        return res;
    }
    
    public String toString()
    {
        return "";
    }
    public T ant(T d)
    {
        return ant(d, ini);
    }
    private T ant(T d, NodoDE<T> nodo){
        T res=null;
        if(!vacia() && buscar(d)!=null){
            if(nodo.getDato().equals(d)){
                res= nodo.getAnt().getDato();
            }   else{
                res= ant(d, nodo.getSig());
            }
        }
        return res;
    }
    public T suc(T d)
    {
        return suc(d, ini);
    }
    private T suc(T d, NodoDE<T> nodo){
        T res=null;
        if(!vacia()&& buscar(d)!=null){
            if(nodo.getDato().equals(d)){
                res= nodo.getSig().getDato();
            }else{
                res= suc(d, nodo.getSig());
            }
        }
        return res;
    }
    public T buscar(T d)
    {
        return buscar(d, ini);
    }
    public T buscar(T d, NodoDE<T> nodo){
        T res=null;
        if(!vacia()){
            if(nodo.equals(ini.getAnt()))
            {
                if(nodo.getDato().equals(d))
                    res = nodo.getDato();
            }else
                if(nodo.getDato().equals(d)){
                    res= nodo.getDato();
                }else{
                    res= buscar(d, nodo.getSig());
                }
        }
        return res;
    }

    private NodoDE<T> buscar(int i, NodoDE<T> q)
    {
        NodoDE<T> res;
        if(i == 0)
            res = q;
        else
            res = buscar(i-1, q.getSig());
        return res;
    }
}
