// Archivo MainApp.java
package ec.edu.ups.poo.Vista;

import ec.edu.ups.poo.Vista.PrincipalView;
import ec.edu.ups.poo.controlador.PrincipalController;
import ec.edu.ups.poo.controlador.ProductoControl;
import ec.edu.ups.poo.dao.ProductoDao;
import ec.edu.ups.poo.dao.impl.ProductoDAOMemoria;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductoDao productoDao = new ProductoDAOMemoria();
            PrincipalView principalView = new PrincipalView();
            PrincipalController principalController = new PrincipalController(principalView, productoDao);

            // Se conecta el controlador del producto
            ProductoControl productoControl = new ProductoControl(
                    productoDao,
                    principalController.getProductoAnadirView(),
                    principalController.getProductoListaView()
            );

            principalView.setVisible(true);
        });
    }
}
