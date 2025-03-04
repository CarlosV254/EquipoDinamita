
import model.Cajero;
import view.CajeroView;
import controller.CajeroController;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> denominaciones = new ArrayList<>(Arrays.asList(500, 200, 100, 50, 20, 10, 5, 2, 1));
        List<Integer> stock = new ArrayList<>(Arrays.asList(5, 50, 30, 100, 20, 50, 50, 20, 100));

        Cajero<Integer> modelo = new Cajero<>(denominaciones, stock);
        CajeroView vista = new CajeroView();
        CajeroController controlador = new CajeroController(modelo, vista, denominaciones, stock);

        controlador.iniciar();
    }
}
