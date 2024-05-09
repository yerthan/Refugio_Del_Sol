package Operaciones;

public class Habitacion {

    private int ID;
    private int numero;
    private String tipo;
    private int capacidad;
    private double precio;

    public Habitacion(int ID, int numero, String tipo, int capacidad, double precio) {
        this.ID = ID;
        this.numero = numero;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public Habitacion() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "ID=" + ID +
                ", numero=" + numero +
                ", tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                ", precio=" + precio +
                '}';
    }
}

