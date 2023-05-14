package com.example.seguimiento14cab;

public class Gestion {

    private double monto;
    private String descripcion;
    private String fecha;
    private String tipo;

    public Gestion(double monto, String descripcion, String fecha, String tipo) {
        this.monto = monto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
