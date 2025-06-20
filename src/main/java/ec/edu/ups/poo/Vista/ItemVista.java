package ec.edu.ups.poo.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemVista extends JInternalFrame {

    private JPanel panelPrincipal;
    private JButton BtnAgregar, BtnElim;
    private JComboBox<String> CmbxProduct;
    private JSpinner SpnCant;

    public ItemVista() {
        setTitle("Gestión de Items");
        setSize(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(panelPrincipal);

        // Configura Spinner para cantidad entre 1 y 20
        SpinnerNumberModel model = new SpinnerNumberModel(1, 1, 20, 1);
        SpnCant.setModel(model);

        // Evento para el botón agregar
        BtnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarItem();
            }
        });

        // Evento para limpiar campos (botón eliminar)
        BtnElim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
    }

    private void guardarItem() {
        String producto = (String) CmbxProduct.getSelectedItem();
        int cantidad = (Integer) SpnCant.getValue();

        // Aquí iría la lógica para guardar el item
        // Por ejemplo, guardarlo en una lista o base de datos
        JOptionPane.showMessageDialog(this,
                "Producto: " + producto + "\nCantidad: " + cantidad + "\nItem guardado correctamente.");
    }

    private void limpiarCampos() {
        CmbxProduct.setSelectedIndex(0);
        SpnCant.setValue(1);
    }

    // Getters si los necesitas
    public JButton getBtnAgregar() {
        return BtnAgregar;
    }

    public JButton getBtnElim() {
        return BtnElim;
    }

    public JComboBox<String> getCmbxProduct() {
        return CmbxProduct;
    }

    public JSpinner getSpnCant() {
        return SpnCant;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }
}
