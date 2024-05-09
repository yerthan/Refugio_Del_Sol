package Operaciones;

public class Extras {
    private int ID;
    private String nombre;
    private double precio;

    public Extras(int ID, String nombre, double precio) {
        this.ID = ID;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Extras() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Extras{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
