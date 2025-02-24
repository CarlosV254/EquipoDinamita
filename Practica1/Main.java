import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cajero banamex = new Cajero();

        System.out.print("Introduce la cantidad : ");
        banamex.setCantidad(scanner.nextInt());

        int[] cambio = banamex.darCambio();
        System.out.println("Distribución del cambio (cantidad de cada denominación):");
        System.out.println(Arrays.toString(cambio));
        banamex.mostrarCambio(cambio);
    }
}
