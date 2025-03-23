import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;
import java.time.Month;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Buscar al vendedor 11
        Vendedor vendedor11 = null;
        for (Vendedor v : vendedores) {
            if (v.getNumeroVendedor() == 11) {
                vendedor11 = v;
                break;
            }
        }

        // Verificar si se encontró al vendedor 11
        if (vendedor11 == null) {
            System.out.println("No se encontró al vendedor 11.");
            return;
        }

        // Calcular el total de ventas en septiembre de 2024
        long totalVentas = 0; // Usamos long para evitar desbordamiento
        for (int i = 0; i < 50; i++) {
            Venta venta = vendedor11.getVenta(i);
            if (venta != null) { // Verificar si la venta existe
                // Filtrar ventas de septiembre de 2024
                if (venta.getFechaVenta().getMonth() == Month.SEPTEMBER &&
                    venta.getFechaVenta().getYear() == 2024) {
                    totalVentas += venta.getValorVenta();
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El valor total de ventas del vendedor 11 en septiembre de 2024 es: " + totalVentas);
    }
}