import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;
import java.time.Month;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Variables para almacenar el mayor total de ventas en diciembre
        long mayorTotalVentasDiciembre = 0;

        // Recorrer todos los vendedores
        for (Vendedor vendedor : vendedores) {
            long totalVentasDiciembre = 0;

            // Recorrer las ventas del vendedor (hasta 50 ventas)
            for (int i = 0; i < 50; i++) {
                Venta venta = vendedor.getVenta(i);
                if (venta != null) { // Verificar si la venta existe
                    // Filtrar ventas de diciembre de cualquier año
                    if (venta.getFechaVenta().getMonth() == Month.DECEMBER) {
                        totalVentasDiciembre += venta.getValorVenta();
                    }
                }
            }

            // Verificar si este vendedor tiene el mayor total de ventas en diciembre
            if (totalVentasDiciembre > mayorTotalVentasDiciembre) {
                mayorTotalVentasDiciembre = totalVentasDiciembre;
            }
        }

        // Mostrar el resultado
        System.out.println("El vendedor con el mayor total de ventas en diciembre vendió un total de: " + mayorTotalVentasDiciembre);
    }
}