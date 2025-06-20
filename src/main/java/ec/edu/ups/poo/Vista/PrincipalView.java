package ec.edu.ups.poo.Vista;

import javax.swing.*;

public class PrincipalView extends JFrame {

    private JDesktopPane desktopPane;

    private JMenuItem menuItemAñadirProducto;
    private JMenuItem menuItemListarProducto;
    private JMenuItem menuItemEliminarProducto;
    private JMenuItem menuItemModificarProducto;
    private JMenuItem menuItemItemVista;
    private JMenuItem menuItemCarrito;

    public PrincipalView() {
        setTitle("Sistema de Gestión");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        desktopPane = new JDesktopPane();
        setContentPane(desktopPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuOpciones = new JMenu("Opciones");

        menuItemAñadirProducto = new JMenuItem("Añadir Producto");
        menuItemListarProducto = new JMenuItem("Listar Productos");
        menuItemEliminarProducto = new JMenuItem("Eliminar Producto");
        menuItemModificarProducto = new JMenuItem("Modificar Producto");
        menuItemItemVista = new JMenuItem("Gestión Items");
        menuItemCarrito = new JMenuItem("Carrito");

        menuOpciones.add(menuItemAñadirProducto);
        menuOpciones.add(menuItemListarProducto);
        menuOpciones.add(menuItemEliminarProducto);
        menuOpciones.add(menuItemModificarProducto);
        menuOpciones.addSeparator();
        menuOpciones.add(menuItemItemVista);
        menuOpciones.add(menuItemCarrito);

        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);
    }

    public JMenuItem getMenuItemAñadirProducto() {
        return menuItemAñadirProducto;
    }

    public JMenuItem getMenuItemListarProducto() {
        return menuItemListarProducto;
    }

    public JMenuItem getMenuItemEliminarProducto() {
        return menuItemEliminarProducto;
    }

    public JMenuItem getMenuItemModificarProducto() {
        return menuItemModificarProducto;
    }

    public JMenuItem getMenuItemItemVista() {
        return menuItemItemVista;
    }

    public JMenuItem getMenuItemCarrito() {
        return menuItemCarrito;
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }
}
