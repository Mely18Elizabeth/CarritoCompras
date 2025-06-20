package ec.edu.ups.poo.controlador;

import ec.edu.ups.poo.Models.Producto;
import ec.edu.ups.poo.Vista.ProductoAnadir;
import ec.edu.ups.poo.Vista.ProductoLista;
import ec.edu.ups.poo.dao.ProductoDao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductoControl {

    private final ProductoAnadir productoAnadirView;
    private final ProductoLista productoListaView;
    private final ProductoDao productoDAO;

    public ProductoControl(ProductoDao productoDAO, ProductoAnadir productoAnadirView, ProductoLista productoListaView) {
        this.productoDAO = productoDAO;
        this.productoAnadirView = productoAnadirView;
        this.productoListaView = productoListaView;

        configurarEventos();
    }

    private void configurarEventos() {
        productoAnadirView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        productoAnadirView.getBtnLimpiar().addActionListener(e -> productoAnadirView.limpiarCampos());

        // Nota: productoListaView ya tiene la búsqueda implementada en su botón BtnListar,
        // así que no necesitas añadir más lógica aquí.
    }

    private void guardarProducto() {
        try {
            int codigo = Integer.parseInt(productoAnadirView.getTxtCodigo().getText());
            String nombre = productoAnadirView.getTxtNombre().getText();
            double precio = Double.parseDouble(productoAnadirView.getTxtPrecio().getText());

            productoDAO.crear(new Producto(codigo, nombre, precio));
            productoAnadirView.mostrarMensaje("Producto guardado correctamente.");
            productoAnadirView.limpiarCampos();

        } catch (NumberFormatException e) {
            productoAnadirView.mostrarMensaje("Error: Código o precio inválido.");
        }
    }
}
