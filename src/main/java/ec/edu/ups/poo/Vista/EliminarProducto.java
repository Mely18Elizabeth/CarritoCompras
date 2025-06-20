package ec.edu.ups.poo.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarProducto extends JInternalFrame {

    private JTextField textBuscar;
    private JButton BtnBuscar, BtnEliminar;
    private JTextArea txtAreaProducto;
    private JPanel panelPrincipal;

    public EliminarProducto() {
        setTitle("Eliminar Producto");
        setSize(400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);

        BtnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProducto();
            }
        });

        BtnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    private void buscarProducto() {
        String codigoBuscado = textBuscar.getText().trim();

        // Simulación: Buscar producto por código
        // Aquí iría la lógica real para buscar en base de datos o lista
        if (codigoBuscado.isEmpty()) {
            mostrarMensaje("Ingrese un código para buscar.");
            return;
        }

        // Ejemplo de producto encontrado (simulado)
        String producto = "Código: " + codigoBuscado + "\nNombre: Producto Ejemplo\nPrecio: $100.00";

        txtAreaProducto.setText(producto);
    }

    private void eliminarProducto() {
        String textoProducto = txtAreaProducto.getText().trim();
        if (textoProducto.isEmpty()) {
            mostrarMensaje("Primero debe buscar y mostrar el producto a eliminar.");
            return;
        }

        // Aquí iría la lógica real para eliminar el producto (por ejemplo, de una lista o base de datos)

        mostrarMensaje("Producto eliminado correctamente.");
        limpiarCampos();
    }

    private void limpiarCampos() {
        textBuscar.setText("");
        txtAreaProducto.setText("");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // Getters si los necesitas

    public JTextField getTextBuscar() {
        return textBuscar;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public JButton getBtnEliminar() {
        return BtnEliminar;
    }

    public JTextArea getTxtAreaProducto() {
        return txtAreaProducto;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
