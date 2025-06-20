package ec.edu.ups.poo.dao.impl;

import ec.edu.ups.poo.dao.ProductoDao;
import ec.edu.ups.poo.Models.Producto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductoDAOMemoria implements ProductoDao {

    private List<Producto> productos;


    public ProductoDAOMemoria() {
        productos = new ArrayList<>();
    }

    @Override
    public void crear(Producto producto) {
        productos.add(producto);
    }

    @Override
    public Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) return p;
        }
        return null;
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        List<Producto> encontrados = new ArrayList<>();
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrados.add(p);
            }
        }
        return encontrados;
    }

    @Override
    public void actualizar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo() == producto.getCodigo()) {
                productos.set(i, producto);
            }
        }
    }

    @Override
    public void eliminar(int codigo) {
        Iterator<Producto> it = productos.iterator();
        while(it.hasNext()) {
            if (it.next().getCodigo() == codigo) it.remove();
        }
    }

    @Override
    public List<Producto> listarTodos() {
        return productos;
    }
}
