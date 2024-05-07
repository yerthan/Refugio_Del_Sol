package operaciones;

public class Habitacion {

    int numero;
    tipo tipo;
    int capacidaD;
    int id;

    public Habitacion(int numero, int capacidaD, int id, tipo tipo){
        this.numero = numero;
        this.capacidaD = capacidaD;
        this.id = id;
    }

    public Habitacion() {
    }


    public operaciones.tipo getTipo() {
        return tipo;
    }

    public void setTipo(operaciones.tipo tipo) {
        this.tipo = tipo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidaD() {
        return capacidaD;
    }

    public void setCapacidaD(int capacidaD) {
        this.capacidaD = capacidaD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "numero=" + numero +
                ", capacidaD=" + capacidaD +
                ", id=" + id +
                '}';
    }
}

