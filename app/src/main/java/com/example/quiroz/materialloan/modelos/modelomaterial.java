package com.example.quiroz.materialloan.modelos;

public class modelomaterial {

    private String clave_prestamo;
    private String fecha;
    private String nombre_sol;
    private String area_sol;
    private String descripcion;
    private String recibido;
    private String entregado;

    public modelomaterial(String clave_prestamo, String fecha, String nombre_sol, String area_sol, String descripcion, String recibido, String entregado) {
        this.clave_prestamo = clave_prestamo;
        this.fecha = fecha;
        this.nombre_sol = nombre_sol;
        this.area_sol = area_sol;
        this.descripcion = descripcion;
        this.recibido = recibido;
        this.entregado = entregado;
    }

    public String getClave_prestamo() {
        return clave_prestamo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getNombre_sol() {
        return nombre_sol;
    }

    public String getArea_sol() {
        return area_sol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getRecibido() {
        return recibido;
    }

    public String getEntregado() {
        return entregado;
    }
}
