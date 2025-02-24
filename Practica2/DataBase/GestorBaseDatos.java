package DataBase;

import Models.Producto;
import java.sql.*;

public class GestorBaseDatos {
    private Connection conexion;

    public GestorBaseDatos() {
        String url = "jdbc:mysql://localhost:3306/siises";
        String usuario = "root";
        String contrasena = "kolker";

        try {
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a MySQL");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public boolean existeProducto(int idProducto) {
        String sql = "SELECT COUNT(*) FROM productos WHERE id_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void consultarProductos() {
        String sql = "SELECT * FROM productos";
        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Listado de Productos:");
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("stock")
                );
                System.out.println(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.executeUpdate();
            System.out.println("Producto insertado correctamente: " + producto.getNombre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProducto(Producto producto) {
        if (!existeProducto(producto.getIdProducto())) {
            System.out.println("El producto con ID " + producto.getIdProducto() + " no existe. No se puede actualizar.");
            return;
        }

        String sql = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, producto.getNombre());
            pstmt.setDouble(2, producto.getPrecio());
            pstmt.setInt(3, producto.getStock());
            pstmt.setInt(4, producto.getIdProducto());
            pstmt.executeUpdate();
            System.out.println("Producto actualizado correctamente: ID " + producto.getIdProducto());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProducto(int idProducto) {
        if (!existeProducto(idProducto)) {
            System.out.println("El producto con ID " + idProducto + " no existe.");
            return;
        }

        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, idProducto);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Producto eliminado correctamente: ID " + idProducto);
            } else {
                System.out.println("No se pudo eliminar el producto con ID " + idProducto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
