package Operaciones;

public class Regimen {
    private int ID;
    private String tipo;
    private String descripcion;
    private double precio;

    public Regimen(int ID, String tipo, String descripcion, double precio) {
        this.ID = ID;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Regimen() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
