package ec.edu.ups.poo.dao;

import ec.edu.ups.poo.Models.Producto;

import java.util.List;

public interface ProductoDao {

    void crear(Producto producto);

    Producto buscarPorCodigo(int codigo);

    List<Producto> buscarPorNombre(String nombre);

    void actualizar(Producto producto);

    void eliminar(int codigo);

    List<Producto> listarTodos();

}