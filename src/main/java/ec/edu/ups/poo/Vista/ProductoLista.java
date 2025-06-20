package ec.edu.ups.poo.Vista;

import ec.edu.ups.poo.Models.Producto;
import ec.edu.ups.poo.dao.ProductoDao;

import javax.swing.*;
import java.util.List;

public class ProductoLista extends JInternalFrame {

    private JPanel panelPrincipal;    // panel raíz del .form
    private JTextField textBuscar;    // campo para ingresar código o nombre
    private JButton BtnListar;        // botón "Listar"
    private JTextArea textArea1;      // área donde se imprime el resultado

    private ProductoDao productoDao;

    public ProductoLista(ProductoDao productoDao) {
        this.productoDao = productoDao;

        setContentPane(panelPrincipal);
        setTitle("Buscar Producto");
        setSize(600, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        textArea1.setEditable(false); // solo lectura

        BtnListar.addActionListener(e -> buscarYMostrar());
    }

    private void buscarYMostrar() {
        String criterio = textBuscar.getText().trim();
        if (criterio.isEmpty()) {
            mostrarMensaje("Ingrese un código o nombre para buscar.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        try {
            // Intenta buscar por código (si es número)
            int codigo = Integer.parseInt(criterio);
            Producto producto = productoDao.buscarPorCodigo(codigo);
            if (producto != null) {
                sb.append("Código: ").append(producto.getCodigo())
                        .append(", Nombre: ").append(producto.getNombre())
                        .append(", Precio: $").append(producto.getPrecio()).append("\n");
            } else {
                sb.append("No se encontró ningún producto con código ").append(codigo).append("\n");
            }
        } catch (NumberFormatException ex) {
            // Si no es un número, buscar por nombre (puede haber más de uno)
            List<Producto> encontrados = productoDao.buscarPorNombre(criterio);
            if (encontrados.isEmpty()) {
                sb.append("No se encontró ningún producto con nombre \"").append(criterio).append("\"\n");
            } else {
                for (Producto p : encontrados) {
                    sb.append("Código: ").append(p.getCodigo())
                            .append(", Nombre: ").append(p.getNombre())
                            .append(", Precio: $").append(p.getPrecio()).append("\n");
                }
            }
        }

        textArea1.setText(sb.toString());
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Getters si los necesitas
    public JTextField getTextBuscar() {
        return textBuscar;
    }

    public JButton getBtnListar() {
        return BtnListar;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }
}
