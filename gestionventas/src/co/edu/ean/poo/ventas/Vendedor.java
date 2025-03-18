package co.edu.ean.poo.ventas;

import java.time.LocalDate;

import co.edu.ean.poo.comisiones.CalculadoraComisiones;

public class Vendedor {
    private int numeroVendedor;
    private String nombre;
    private String apellido;
    private LocalDate fechaIngreso;
    private ListaVentas ventas = new ListaVentas(10);

    public Vendedor(int nv, String nm, String ap, LocalDate f ) {
        numeroVendedor = nv;
        nombre = nm;
        apellido = ap;
        fechaIngreso = f;
    }

    public int getNumeroVendedor() {
        return numeroVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public boolean registrarVenta(Venta venta) {
        if ( ! venta.getFecha().isBefore(fechaIngreso)) {
            ventas.agregarVenta(venta);
            return true;
        }
        return false;
    }

    public void registrarVenta(LocalDate fechaVenta, int valor) {
        registrarVenta( new Venta(fechaVenta, valor) );
    }

    public ListaVentas getVentas() {
        return ventas;
    }

    public int totalVentas( LocalDate fechaInicio, LocalDate fechaFin ) {
        int totalVentas = 0;
        for (int i = 0; i < ventas.cantidadVentas(); i++) {
            Venta venta = ventas.getVenta(i);
            if (venta.getFecha().compareTo(fechaInicio) >= 0 && venta.getFecha().compareTo(fechaFin) <= 0) 
                totalVentas += venta.getValor();
        }
        return totalVentas;
    }

    public int calcularComision( LocalDate fechaInicio, LocalDate fechaFin ) {
        float comision = 0;
        for (int i = 0; i < ventas.cantidadVentas(); i++) {
            Venta venta = ventas.getVenta(i);
            if (venta.getFecha().isBefore(fechaInicio) || venta.getFecha().isAfter(fechaFin) ) continue;    
            comision += CalculadoraComisiones.calcularComision(fechaIngreso, venta.getFecha(), venta.getValor() ).comision();
        }
        return Math.round(comision);
    }

    @Override
    public String toString() {
        return String.format("Vendedor[%02d:%s %s:%s]", numeroVendedor, nombre, apellido, fechaIngreso);
    }
}
