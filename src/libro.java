import java.util.ArrayList;

public class libro {
    private int id;
    private int paginas;
    private String nombre;
    private static int contador=0;

    public libro(int paginas, String nombre) {
        this.id = asignarId();
        this.paginas = paginas;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getPaginas() {
        return paginas;
    }

    public String getNombre() {
        return nombre;
    }

    private int asignarId(){
        contador=contador+1;
        return contador;
    }

    @Override
    public String toString() {
        return "Libro: \n" +
                "Nombre: " + nombre+
                "\nId: " + id +
                "\nPáginas: " + paginas ;
    }
}
