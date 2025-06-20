package ec.edu.ups.poo.Vista;

import ec.edu.ups.poo.Models.Producto;
import ec.edu.ups.poo.dao.ProductoDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ModificarProducto extends JInternalFrame {

    private JTextField txtBuscar;
    private JButton BtnBuscar, BtnActual;
    private JTextArea producto;
    private JTextField txtNom, txtPrecio;
    private Producto productoEncontrado;

    private ProductoDao productoDao;

    public ModificarProducto(ProductoDao productoDao) {
        this.productoDao = productoDao;

        setTitle("Modificar Producto");
        setSize(400, 400);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(9, 1, 5, 5));

        txtBuscar = new JTextField();
        BtnBuscar = new JButton("Buscar");
        producto = new JTextArea(3, 20);
        producto.setEditable(false);
        txtNom = new JTextField();
        txtPrecio = new JTextField();
        BtnActual = new JButton("Actualizar");

        panel.add(new JLabel("Buscar (Código o Nombre):"));
        panel.add(txtBuscar);
        panel.add(BtnBuscar);
        panel.add(new JLabel("Producto encontrado:"));
        panel.add(new JScrollPane(producto));
        panel.add(new JLabel("Nuevo Nombre:"));
        panel.add(txtNom);
        panel.add(new JLabel("Nuevo Precio:"));
        panel.add(txtPrecio);
        panel.add(BtnActual);

        add(panel, BorderLayout.CENTER);

        // Buscar producto
        BtnBuscar.addActionListener((ActionEvent e) -> {
            String valor = txtBuscar.getText().trim();
            productoEncontrado = null;

            try {
                int codigo = Integer.parseInt(valor);
                productoEncontrado = productoDao.buscarPorCodigo(codigo);
            } catch (NumberFormatException ex) {
                List<Producto> encontrados = productoDao.buscarPorNombre(valor);
                if (!encontrados.isEmpty()) {
                    productoEncontrado = encontrados.get(0);
                }
            }

            if (productoEncontrado != null) {
                producto.setText("Código: " + productoEncontrado.getCodigo()
                        + "\nNombre: " + productoEncontrado.getNombre()
                        + "\nPrecio: " + productoEncontrado.getPrecio());
            } else {
                producto.setText("Producto no encontrado.");
            }
        });

        // Actualizar producto
        BtnActual.addActionListener((ActionEvent e) -> {
            if (productoEncontrado != null) {
                String nuevoNombre = txtNom.getText().trim();
                String nuevoPrecioStr = txtPrecio.getText().trim();

                if (!nuevoNombre.isEmpty() && !nuevoPrecioStr.isEmpty()) {
                    try {
                        double nuevoPrecio = Double.parseDouble(nuevoPrecioStr);
                        productoEncontrado.setNombre(nuevoNombre);
                        productoEncontrado.setPrecio(nuevoPrecio);
                        productoDao.actualizar(productoEncontrado);

                        producto.setText("Producto actualizado:\nCódigo: " + productoEncontrado.getCodigo()
                                + "\nNombre: " + nuevoNombre
                                + "\nPrecio: " + nuevoPrecio);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "El precio debe ser numérico.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Completa ambos campos para actualizar.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Primero busca un producto válido.");
            }
        });
    }
}
