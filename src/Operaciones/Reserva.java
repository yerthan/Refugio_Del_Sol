package Operaciones;

import java.util.Date;

public class Reserva {

    private int ID;
    private int habitacionID;
    private int extrasID;
    private int regimenID;
    private double precioTotal;

    public Reserva(int ID, int habitacionID, int extrasID, int regimenID, double precioTotal) {
        this.ID = ID;
        this.habitacionID = habitacionID;
        this.extrasID = extrasID;
        this.regimenID = regimenID;
        this.precioTotal = precioTotal;
    }

    public Reserva() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public int getHabitacionID() {
        return habitacionID;
    }

    public void setHabitacionID(int habitacionID) {
        this.habitacionID = habitacionID;
    }

    public int getExtrasID() {
        return extrasID;
    }

    public void setExtrasID(int extrasID) {
        this.extrasID = extrasID;
    }

    public int getRegimenID() {
        return regimenID;
    }

    public void setRegimenID(int regimenID) {
        this.regimenID = regimenID;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "ID=" + ID +
                ", habitacionID=" + habitacionID +
                ", extrasID=" + extrasID +
                ", regimenID=" + regimenID +
                ", precioTotal=" + precioTotal +
                '}';
    }
}
