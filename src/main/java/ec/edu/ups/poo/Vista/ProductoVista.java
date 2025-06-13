package ec.edu.ups.poo.Vista;

import javax.swing.*;

public class ProductoVista  extends JFrame {

    private JPanel paneLPrincipal;
    private JPanel panel2;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton guardarButton;
    private JButton eliminarButton;

    public ProductoVista() {
        setTitle("Datos del Producto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ProductoVista();
    }

}