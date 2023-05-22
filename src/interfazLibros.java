import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class interfazLibros extends JFrame{
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtNombreLibro;
    private JTextField txtPaginasLibro;
    private JButton btnAgregarLibro;
    private JButton btnDatosPredef;
    private JTextArea taLibrosAgregados;
    private JTextField txtNombrePorBuscar;
    private JTextField txtIdPorBuscar;
    private JButton btnBuscarPorNombre;
    private JButton btnBuscarPorId;
    private JTextArea taBuscarPorNombre;
    private JTextArea taBuscarporId;
    private JTextField txtNombrePorEliminar;
    private JTextField txtIdPorEliminar;
    private JButton btnEliminarPorNombre;
    private JButton btnEliminarPorId;
    private JButton btnMostrarpaginas;
    private JTextArea taPaginasTotales;
    private JTextArea taEliminados;
    private biblioteca b;

    public interfazLibros(String titulo) {
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel1);
        this.pack();
        b=new biblioteca();

        btnAgregarLibro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               boolean respuesta= b.agregarLibros(new libro(Integer.parseInt(txtPaginasLibro.getText()),txtNombreLibro.getText()));
               if (respuesta){
                   taLibrosAgregados.setText(b.toString());
                   JOptionPane.showMessageDialog(null, "Libro agregado correctamente");
               }else{
                   taLibrosAgregados.setText("Libro ya existente");
               }

            }
        });
        btnDatosPredef.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.datosQuemados();
                JOptionPane.showMessageDialog(null, "Datos Quemados cargados correctamente");
                btnDatosPredef.setEnabled(false);
                taLibrosAgregados.setText(b.toString());
            }
        });
        btnBuscarPorNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libro lb1=b.busquedaLibroPorNombre(txtNombrePorBuscar.getText());
                if (lb1!=null){
                    taBuscarPorNombre.setText("Libro encontrado"+lb1.toString());
                }
                else {
                    taBuscarPorNombre.setText("Libro no encontrado");
                }
            }
        });
        btnBuscarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libro lb1=b.busquedaPorIdBinario(Integer.parseInt(txtIdPorBuscar.getText()));
                if (lb1!=null){
                    taBuscarporId.setText("Libro encontrado"+lb1.toString());
                }
                else {
                    taBuscarporId.setText("Libro no encontrado");
                }
            }
        });
        btnEliminarPorNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libro lb1= b.eliminarPorNombre(txtNombrePorEliminar.getText());
                if (lb1!=null){
                    taEliminados.setText("Libro eliminado"+lb1.toString());
                }
                else {
                    taEliminados.setText("Libro no encontrado");
                }
            }
        });
        btnEliminarPorId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                libro lb1= b.eliminarLibroPorId(Integer.parseInt(txtIdPorEliminar.getText()));
                if (lb1!=null){
                    taEliminados.setText("Libro eliminado"+lb1.toString());
                }
                else {
                    taEliminados.setText("Libro no encontrado");
                }
            }
        });
        btnMostrarpaginas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indice=b.getLibros().size()-1;
                taPaginasTotales.setText("Paginas Totales en la Biblioteca: "+ b.sumaRecursivo(b.getLibros(),indice));
            }
        });
    }
}
