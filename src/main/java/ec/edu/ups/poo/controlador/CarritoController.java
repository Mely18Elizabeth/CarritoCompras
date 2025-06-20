package ec.edu.ups.poo.controlador;

import ec.edu.ups.poo.Models.ItemCarrito;
import ec.edu.ups.poo.Models.Producto;
import ec.edu.ups.poo.Vista.CarritoAnadirView;
import ec.edu.ups.poo.servicio.CarritoService;
import ec.edu.ups.poo.servicio.CarritoServiceImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoController {

    private CarritoAnadirView view;
    private CarritoService service;

    public CarritoController(CarritoAnadirView view) {
        this.view = view;
        this.service = new CarritoServiceImpl();

        initController();
    }

    private void initController() {
        view.getBtnAñadir().addActionListener(e -> agregarProductoAlCarrito());
        view.getBtnGuardar().addActionListener(e -> guardarCompra());
        view.getBtnCancelar().addActionListener(e -> cancelarCompra());
        // Puedes implementar botón buscar si quieres
    }

    private void agregarProductoAlCarrito() {
        try {
            int codigo = Integer.parseInt(view.getTextCodigo().getText().trim());
            String nombre = view.getTxtNombre().getText().trim();
            double precio = Double.parseDouble(view.getTxtPrecio().getText().trim());
            int cantidad = (Integer) view.getTxtCantidad().getValue();

            if(nombre.isEmpty()) {
                view.mostrarMensaje("El nombre no puede estar vacío");
                return;
            }
            if(precio <= 0) {
                view.mostrarMensaje("El precio debe ser mayor que cero");
                return;
            }

            Producto producto = new Producto(codigo, nombre, precio);
            service.agregarProducto(producto, cantidad);

            actualizarTabla();
            view.limpiarCampos();
            view.mostrarMensaje("Producto agregado al carrito");
        } catch (NumberFormatException ex) {
            view.mostrarMensaje("Ingrese datos válidos en código y precio");
        }
    }

    private void actualizarTabla() {
        DefaultTableModel model = (DefaultTableModel) view.getTblProducto().getModel();
        model.setRowCount(0);

        for (ItemCarrito item : service.obtenerItems()) {
            Object[] fila = new Object[]{
                    item.getProducto().getCodigo(),
                    item.getProducto().getNombre(),
                    item.getProducto().getPrecio(),
                    item.getCantidad(),
                    item.getProducto().getPrecio() * item.getCantidad()
            };
            model.addRow(fila);
        }
    }

    private void guardarCompra() {
        double subtotal = service.calcularTotal();
        double iva = subtotal * 0.12; // IVA 12%
        double total = subtotal + iva;

        view.getTxtSubTotal().setText(String.format("%.2f", subtotal));
        view.getTxtIva().setText(String.format("%.2f", iva));
        view.getTxtTotal().setText(String.format("%.2f", total));

        view.getTxtSubTotal().setEditable(false);
        view.getTxtIva().setEditable(false);
        view.getTxtTotal().setEditable(false);

        view.mostrarMensaje("Compra guardada correctamente");
    }

    private void cancelarCompra() {
        service.vaciarCarrito();
        actualizarTabla();
        view.limpiarCampos();
        view.mostrarMensaje("Carrito y campos limpiados");
    }
}
