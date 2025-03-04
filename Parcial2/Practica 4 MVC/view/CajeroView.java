package view;

import model.Cajero;
import view.CajeroView;
import controller.CajeroController;
import java.util.List;
import java.util.Scanner;

public class CajeroView {
    private Scanner scanner;

    public CajeroView() {
        scanner = new Scanner(System.in);
    }

    // Método para solicitar la cantidad al usuario.
    public int solicitarCantidad() {
        System.out.print("Introduce la cantidad: ");
        return scanner.nextInt();
    }

    // Método para mostrar el cambio de forma formateada.
    public void mostrarCambio(List<Integer> cambio, List<Integer> denominaciones) {
        System.out.println("Distribución del cambio (cantidad de cada denominación):");
        for (int i = 0; i < denominaciones.size(); i++) {
            if (cambio.get(i) > 0) {
                System.out.println(cambio.get(i) + " de " + denominaciones.get(i));
            }
        }
    }

    // Método para mostrar mensajes genéricos.
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
