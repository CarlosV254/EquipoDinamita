package Controllers;

import DataBase.GestorBaseDatos;
import Models.Producto;

public class ProductoController {
    private GestorBaseDatos gestorBD;

    public ProductoController(GestorBaseDatos gestorBD) {
        this.gestorBD = gestorBD;
    }

    // Consultar todos los productos
    public void consultarProductos() {
        gestorBD.consultarProductos();
    }

    // Insertar un producto
    public void insertarProducto(String nombre, double precio, int stock) {
        Producto producto = new Producto(nombre, precio, stock);
        gestorBD.insertarProducto(producto);
    }

    // Actualizar un producto
    public void actualizarProducto(int id, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        Producto producto = new Producto(id, nuevoNombre, nuevoPrecio, nuevoStock);
        gestorBD.actualizarProducto(producto);
    }

    // Eliminar un producto
    public void eliminarProducto(int id) {
        gestorBD.eliminarProducto(id);
    }
}
