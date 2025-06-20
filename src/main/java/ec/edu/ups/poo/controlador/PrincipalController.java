package ec.edu.ups.poo.controlador;

import ec.edu.ups.poo.Vista.*;
import ec.edu.ups.poo.dao.ProductoDao;

import javax.swing.*;

public class PrincipalController {

    private PrincipalView principalView;
    private ProductoDao productoDao;

    private ProductoAnadir productoAnadirView;
    private ProductoLista productoListaView;
    private EliminarProducto eliminarProductoView;
    private ModificarProducto modificarProductoView;
    private ItemVista itemVista;
    private CarritoAnadirView carritoAnadirView;

    public PrincipalController(PrincipalView principalView, ProductoDao productoDao) {
        this.principalView = principalView;
        this.productoDao = productoDao;
        initViews();
        initController();
    }

    private void initViews() {
        productoAnadirView = new ProductoAnadir();
        productoListaView = new ProductoLista(productoDao);   // PASAMOS EL DAO
        eliminarProductoView = new EliminarProducto();
        modificarProductoView = new ModificarProducto(productoDao); // DAO INYECTADO
        itemVista = new ItemVista();
        carritoAnadirView = new CarritoAnadirView();

        JDesktopPane desktop = principalView.getDesktopPane();

        desktop.add(productoAnadirView);
        desktop.add(productoListaView);
        desktop.add(eliminarProductoView);
        desktop.add(modificarProductoView);
        desktop.add(itemVista);
        desktop.add(carritoAnadirView);

        productoAnadirView.setVisible(false);
        productoListaView.setVisible(false);
        eliminarProductoView.setVisible(false);
        modificarProductoView.setVisible(false);
        itemVista.setVisible(false);
        carritoAnadirView.setVisible(false);
    }


    private void initController() {
        principalView.getMenuItemAñadirProducto().addActionListener(e -> mostrarVentana(productoAnadirView));
        principalView.getMenuItemListarProducto().addActionListener(e -> mostrarVentana(productoListaView));
        principalView.getMenuItemEliminarProducto().addActionListener(e -> mostrarVentana(eliminarProductoView));
        principalView.getMenuItemModificarProducto().addActionListener(e -> mostrarVentana(modificarProductoView));
        principalView.getMenuItemItemVista().addActionListener(e -> mostrarVentana(itemVista));
        principalView.getMenuItemCarrito().addActionListener(e -> mostrarVentana(carritoAnadirView));
    }

    private void mostrarVentana(JInternalFrame ventana) {
        productoAnadirView.setVisible(false);
        productoListaView.setVisible(false);
        eliminarProductoView.setVisible(false);
        modificarProductoView.setVisible(false);
        itemVista.setVisible(false);
        carritoAnadirView.setVisible(false);

        ventana.setVisible(true);
        try {
            ventana.setSelected(true);
            ventana.toFront();
        } catch (java.beans.PropertyVetoException ex) {
            ex.printStackTrace();
        }
    }

    // Getters
    public ProductoAnadir getProductoAnadirView() {
        return productoAnadirView;
    }

    public ProductoLista getProductoListaView() {
        return productoListaView;
    }

    public ModificarProducto getModificarProductoView() {
        return modificarProductoView;
    }

    public CarritoAnadirView getCarritoAnadirView() {
        return carritoAnadirView;
    }
}
