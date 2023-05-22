import java.util.ArrayList;
import java.util.List;

public class biblioteca {
private List<libro> arrayDeLibros=new ArrayList<libro>();
    public boolean agregarLibros(libro lb){
        if(busquedaLibroPorNombre(lb.getNombre())==null){
                arrayDeLibros.add(lb);
                return true;
            }else{
                return false;
            }
    }
    public libro busquedaLibroPorNombre(String nombre){
        for (libro libro1 : arrayDeLibros) {
            if(libro1.getNombre().equals(nombre)){
                return libro1;
            }
        }
        return null;
    }
    public libro busquedaPorIdBinario(int Id){
        int izquierda = 0;
        int derecha = arrayDeLibros.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arrayDeLibros.get(medio).getId() == Id) {
                return arrayDeLibros.get(medio);
            } else if (arrayDeLibros.get(medio).getId() < Id) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return null;
    }
    public libro eliminarPorNombre(String nombre){
        libro libro1;
        for (int i=0;i<arrayDeLibros.size();i++) {
            libro1=arrayDeLibros.get(i);
            if(libro1.getNombre().equals(nombre)){
                arrayDeLibros.remove(i);
                return libro1;
            }
        }
        return null;
    }
    public libro eliminarLibroPorId (int id){
        libro lb;
        for (int i=0;i<arrayDeLibros.size();i++) {
            lb=arrayDeLibros.get(i);
            if(lb.getId()==id){
                arrayDeLibros.remove(i);
                return lb;
            }
        }
        return null;
    }


    public int sumaRecursivo(List<libro> libros, int i){
        if(i==0){
            return libros.get(0).getPaginas();
        }else{
            return libros.get(i).getPaginas()+sumaRecursivo(libros,i-1);
        }
    }


public void datosQuemados(){
    arrayDeLibros.add(new libro(10,"Cien años de soledad"));
    arrayDeLibros.add(new libro(23,"El amor en los tiempos del cólera"));
    arrayDeLibros.add(new libro(33,"Almas muertas"));
    arrayDeLibros.add(new libro(45,"Don Quijote de la Mancha"));
    arrayDeLibros.add(new libro(51,"El Señor de los Anillos"));
    arrayDeLibros.add(new libro(60,"Fausto"));
}

    public List<libro> getLibros() {
        return arrayDeLibros;
    }

    @Override
    public String toString() {
        return "biblioteca{" +
                "arrayDeLibros=" + arrayDeLibros +
                '}';
    }
}
