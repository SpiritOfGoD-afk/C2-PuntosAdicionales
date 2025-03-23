import co.edu.ean.poo.ventas.Vendedor;
import co.edu.ean.poo.ventas.Venta;
import co.edu.ean.poo.ventas.datos.ParseDatos;
import java.time.Month;

public class App {
    public static void main(String[] args) throws Exception {
        // Obtener todos los vendedores
        Vendedor[] vendedores = ParseDatos.parseDatos();

        // Buscar al vendedor número 5
        Vendedor vendedor5 = null;
        for (Vendedor v : vendedores) {
            if (v.getNumeroVendedor() == 5) {
                vendedor5 = v;
                break;
            }
        }

        // Verificar si se encontró al vendedor 5
        if (vendedor5 == null) {
            System.out.println("No se encontró al vendedor 5.");
            return;
        }

        // Calcular el total de ventas en octubre de 2024
        long totalVentasOctubre2024 = 0;
        for (int i = 0; i < 50; i++) {
            Venta venta = vendedor5.getVenta(i);
            if (venta != null) { // Verificar si la venta existe
                // Filtrar ventas de octubre de 2024
                if (venta.getFechaVenta().getMonth() == Month.OCTOBER &&
                    venta.getFechaVenta().getYear() == 2024) {
                    totalVentasOctubre2024 += venta.getValorVenta();
                }
            }
        }

        // Calcular las comisiones (supongamos una comisión del 10%)
        double comision = totalVentasOctubre2024 * 0.10;

        // Redondear el valor de la comisión
        long comisionRedondeada = Math.round(comision);

        // Mostrar el resultado
        System.out.println("El valor de las comisiones recibidas por el vendedor número 5 en octubre de 2024 fue: " + comisionRedondeada);
    }
}