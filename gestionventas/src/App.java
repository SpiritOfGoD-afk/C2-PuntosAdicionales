import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;
import java.time.Month;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Buscar al vendedor 26
        Vendedor vendedor26 = null;
        for (Vendedor v : vendedores) {
            if (v.getNumeroVendedor() == 26) {
                vendedor26 = v;
                break;
            }
        }

        // Verificar si se encontró al vendedor 26
        if (vendedor26 == null) {
            System.out.println("No se encontró al vendedor 26.");
            return;
        }

        // Calcular el total de ventas en noviembre de 2024
        int totalVentas = 0;
        for (int i = 0; i < 50; i++) {
            Venta venta = vendedor26.getVenta(i);
            if (venta != null) { // Verificar si la venta existe
                if (venta.getFechaVenta().getMonth() == Month.NOVEMBER && 
                    venta.getFechaVenta().getYear() == 2024) {
                    totalVentas += venta.getValorVenta();
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El valor total de ventas del vendedor 26 en noviembre de 2024 es: " + totalVentas);
    }
}