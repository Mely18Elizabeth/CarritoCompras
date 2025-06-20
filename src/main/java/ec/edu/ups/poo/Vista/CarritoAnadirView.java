package ec.edu.ups.poo.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoAnadirView extends JInternalFrame {

    private JTextField txtNombre, txtPrecio, txtSubTotal, txtIva, txtTotal, textCodigo;
    private JSpinner txtCantidad;
    private JButton BtnAñadir, BtnBuscar, BtnGuardar, BtnCancelar;
    private JPanel panelprincipal;
    private JTable TblProducto;

    public CarritoAnadirView() {
        super("Añadir al Carrito", true, true, true, true);
        initComponents();
        cargarCantidad();
    }

    private void initComponents() {
        // Inicializa todos los componentes (sin form, manualmente)
        panelprincipal = new JPanel();
        panelprincipal.setLayout(null); // Puedes usar otro layout para mejor diseño

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(20, 20, 60, 25);
        panelprincipal.add(lblCodigo);

        textCodigo = new JTextField();
        textCodigo.setBounds(90, 20, 150, 25);
        panelprincipal.add(textCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 60, 60, 25);
        panelprincipal.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(90, 60, 150, 25);
        panelprincipal.add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setBounds(20, 100, 60, 25);
        panelprincipal.add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(90, 100, 150, 25);
        panelprincipal.add(txtPrecio);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(20, 140, 60, 25);
        panelprincipal.add(lblCantidad);

        txtCantidad = new JSpinner();
        txtCantidad.setBounds(90, 140, 60, 25);
        panelprincipal.add(txtCantidad);

        BtnAñadir = new JButton("Añadir");
        BtnAñadir.setBounds(270, 20, 100, 25);
        panelprincipal.add(BtnAñadir);

        BtnBuscar = new JButton("Buscar");
        BtnBuscar.setBounds(270, 60, 100, 25);
        panelprincipal.add(BtnBuscar);

        BtnGuardar = new JButton("Guardar");
        BtnGuardar.setBounds(270, 100, 100, 25);
        panelprincipal.add(BtnGuardar);

        BtnCancelar = new JButton("Cancelar");
        BtnCancelar.setBounds(270, 140, 100, 25);
        panelprincipal.add(BtnCancelar);

        TblProducto = new JTable();
        JScrollPane scrollPane = new JScrollPane(TblProducto);
        scrollPane.setBounds(20, 190, 550, 150);
        panelprincipal.add(scrollPane);

        JLabel lblSubTotal = new JLabel("Subtotal:");
        lblSubTotal.setBounds(20, 360, 60, 25);
        panelprincipal.add(lblSubTotal);

        txtSubTotal = new JTextField();
        txtSubTotal.setBounds(90, 360, 150, 25);
        txtSubTotal.setEditable(false);
        panelprincipal.add(txtSubTotal);

        JLabel lblIva = new JLabel("IVA (12%):");
        lblIva.setBounds(270, 360, 60, 25);
        panelprincipal.add(lblIva);

        txtIva = new JTextField();
        txtIva.setBounds(340, 360, 150, 25);
        txtIva.setEditable(false);
        panelprincipal.add(txtIva);

        JLabel lblTotal = new JLabel("Total:");
        lblTotal.setBounds(20, 400, 60, 25);
        panelprincipal.add(lblTotal);

        txtTotal = new JTextField();
        txtTotal.setBounds(90, 400, 150, 25);
        txtTotal.setEditable(false);
        panelprincipal.add(txtTotal);

        setContentPane(panelprincipal);
        setSize(600, 480);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Modelo tabla con columnas
        String[] columnas = {"Código", "Nombre", "Precio", "Cantidad", "Subtotal"};
        TblProducto.setModel(new DefaultTableModel(null, columnas));
    }

    private void cargarCantidad() {
        SpinnerNumberModel modeloCantidad = new SpinnerNumberModel(1, 1, 20, 1);
        txtCantidad.setModel(modeloCantidad);
    }

    // Getters para manejar eventos y actualizar UI desde el controlador
    public JTextField getTxtNombre() { return txtNombre; }
    public JTextField getTxtPrecio() { return txtPrecio; }
    public JTextField getTextCodigo() { return textCodigo; }
    public JSpinner getTxtCantidad() { return txtCantidad; }
    public JButton getBtnAñadir() { return BtnAñadir; }
    public JButton getBtnBuscar() { return BtnBuscar; }
    public JButton getBtnGuardar() { return BtnGuardar; }
    public JButton getBtnCancelar() { return BtnCancelar; }
    public JTable getTblProducto() { return TblProducto; }
    public JTextField getTxtSubTotal() { return txtSubTotal; }
    public JTextField getTxtIva() { return txtIva; }
    public JTextField getTxtTotal() { return txtTotal; }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        textCodigo.setText("");
        txtNombre.setText("");
        txtPrecio.setText("");
        txtCantidad.setValue(1);
        txtSubTotal.setText("");
        txtIva.setText("");
        txtTotal.setText("");
    }
}
