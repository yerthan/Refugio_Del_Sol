package operaciones;

public class Habitacion {

    int numero;
    String tipo;
    int capacidaD;
    int id;

    public Habitacion(int numero, int capacidaD, int id, String tipo){
        this.numero = numero;
        this.capacidaD = capacidaD;
        this.id = id;
    }

    public Habitacion() {
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

