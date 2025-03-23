import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Variables para almacenar el vendedor con mayor total de ventas en 2025
        int numeroVendedorConMayorVentas = -1;
        long mayorTotalVentas = 0;

        // Recorrer todos los vendedores
        for (Vendedor vendedor : vendedores) {
            long totalVentas2025 = 0;

            // Recorrer las ventas del vendedor (hasta 50 ventas)
            for (int i = 0; i < 50; i++) {
                Venta venta = vendedor.getVenta(i);
                if (venta != null) { // Verificar si la venta existe
                    // Filtrar ventas del año 2025
                    if (venta.getFechaVenta().getYear() == 2025) {
                        totalVentas2025 += venta.getValorVenta();
                    }
                }
            }

            // Verificar si este vendedor tiene el mayor total de ventas en 2025
            if (totalVentas2025 > mayorTotalVentas) {
                mayorTotalVentas = totalVentas2025;
                numeroVendedorConMayorVentas = vendedor.getNumeroVendedor();
            }
        }

        // Mostrar el resultado
        System.out.println("El vendedor con el mayor total en ventas en 2025 es aquel cuyo número de vendedor es: " + numeroVendedorConMayorVentas);
    }
}