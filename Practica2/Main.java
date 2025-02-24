import Controllers.ProductoController;
import DataBase.GestorBaseDatos;
import Views.VistaProducto;

public class Main {
    public static void main(String[] args) {
        GestorBaseDatos gestorBD = new GestorBaseDatos();

        ProductoController controlador = new ProductoController(gestorBD);

        VistaProducto vista = new VistaProducto(controlador);

        vista.mostrarMenu();

        gestorBD.cerrarConexion();
    }
}
