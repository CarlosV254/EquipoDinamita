package CodigoTranscrito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ColeccionesEjemplo {
    public static void main(String[] args) {
        // 1. Lista (ArrayList)
        List<String> lista = new ArrayList<>();
        lista.add("Manzana");
        lista.add("Banana");
        lista.add("Naranja");
        System.out.println("Lista de frutas: " + lista);

        // 2. Conjunto (HashSet)
        Set<String> conjunto = new HashSet<>();
        conjunto.add("Manzana");
        conjunto.add("Banana");
        conjunto.add("Naranja");
        conjunto.add("Naranja"); // No se repiten duplicados
        System.out.println("Conjunto de frutas: " + conjunto);

        // 3. Mapa (HashMap)
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Manzana", 10);
        mapa.put("Banana", 5);
        mapa.put("Naranja", 8);
        System.out.println("Mapa de frutas y cantidades: " + mapa);

        // 4. Recorrer una lista
        System.out.println("\nRecorriendo la lista:");
        for (String fruta : lista) {
            System.out.println(fruta);
        }

        // 5. Recorrer un mapa
        System.out.println("\nRecorriendo el mapa:");
        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            System.out.println("Fruta: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }
}
