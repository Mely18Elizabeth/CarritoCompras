package ec.edu.ups.poo.Vista;

import ec.edu.ups.poo.Models.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoAnadir extends JInternalFrame {

    private JPanel PanelPrincipal;
    private JTextField txtNombre, txtPrecio, txtCodigo;
    private JButton btnGuardar, btnLimpiar;

    public ProductoAnadir() {
        setContentPane(PanelPrincipal);
        setTitle("Añadir Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void guardarProducto() {
        String codigoStr = txtCodigo.getText().trim();
        String nombre = txtNombre.getText().trim();
        String precioStr = txtPrecio.getText().trim();

        if (codigoStr.isEmpty() || nombre.isEmpty() || precioStr.isEmpty()) {
            mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        int codigo;
        try {
            codigo = Integer.parseInt(codigoStr);
            if (codigo < 0) {
                mostrarMensaje("El código debe ser un número entero positivo.");
                return;
            }
        } catch (NumberFormatException ex) {
            mostrarMensaje("Código inválido. Ingrese un número entero válido.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(precioStr);
            if (precio < 0) {
                mostrarMensaje("El precio debe ser un número positivo.");
                return;
            }
        } catch (NumberFormatException ex) {
            mostrarMensaje("Precio inválido. Ingrese un número válido.");
            return;
        }

        Producto nuevoProducto = new Producto(codigo, nombre, precio);

        // Aquí guardas el producto en tu lista o base de datos

        mostrarMensaje("Producto guardado correctamente:\n" +
                "Código: " + nuevoProducto.getCodigo() +
                "\nNombre: " + nuevoProducto.getNombre() +
                "\nPrecio: " + nuevoProducto.getPrecio());
    }


    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
    }

    public JPanel getPanelPrincipal() {
        return PanelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.PanelPrincipal = panelPrincipal;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }


}
