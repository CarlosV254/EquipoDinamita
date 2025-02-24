package Views;

import Controllers.ProductoController;

import java.util.Scanner;

public class VistaProducto {
    private final ProductoController controlador;
    private final Scanner scanner;

    public VistaProducto(ProductoController controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    // Mostrar el menú principal de opciones
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Menú de Opciones (Productos) ---");
            System.out.println("1. Consultar productos");
            System.out.println("2. Insertar producto");
            System.out.println("3. Actualizar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> controlador.consultarProductos();
                case 2 -> insertarProducto();
                case 3 -> actualizarProducto();
                case 4 -> eliminarProducto();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // Vista para insertar un producto
    private void insertarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();

        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();
        controlador.insertarProducto(nombre, precio, stock);
    }

    // Vista para actualizar un producto
    private void actualizarProducto() {
        System.out.print("Ingrese el ID del producto a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();

        System.out.print("Ingrese el nuevo stock del producto: ");
        int nuevoStock = scanner.nextInt();
        scanner.nextLine();

        controlador.actualizarProducto(id, nuevoNombre, nuevoPrecio, nuevoStock);
    }

    // Vista para eliminar un producto
    private void eliminarProducto() {
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        controlador.eliminarProducto(id);
    }
}
