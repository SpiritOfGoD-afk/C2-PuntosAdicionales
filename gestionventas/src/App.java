import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Variable para almacenar el total de ventas en 2024 (usamos long para evitar desbordamiento)
        long totalVentas2024 = 0;

        // Recorrer todos los vendedores
        for (Vendedor vendedor : vendedores) {
            // Recorrer las ventas del vendedor (hasta 50 ventas)
            for (int i = 0; i < 50; i++) {
                Venta venta = vendedor.getVenta(i);
                if (venta != null) { // Verificar si la venta existe
                    // Filtrar ventas del año 2024
                    if (venta.getFechaVenta().getYear() == 2024) {
                        totalVentas2024 += venta.getValorVenta();
                    }
                }
            }
        }

        // Mostrar el resultado
        System.out.println("El total de ventas de todos los vendedores en 2024 es: " + totalVentas2024);
    }
}