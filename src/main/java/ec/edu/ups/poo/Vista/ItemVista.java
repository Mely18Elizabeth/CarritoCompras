package ec.edu.ups.poo.Vista;

import javax.swing.*;

public class ItemVista extends JFrame{
    private JPanel paneLPrincipal;
    private JPanel panel2;
    private JTextField textField3;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JComboBox comboBox1;
    private JSpinner spinner1;

    public ItemVista() {
        setTitle("Items");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ProductoVista();
    }
}

