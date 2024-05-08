package operaciones;

import java.util.Date;

public class Reserva {

    private int ID;
    private Date fechaInicio;
    private Date fechaFin;
    private int habitacionID;
    private int extrasID;
    private int regimenID;

    public Reserva(int ID, Date fechaInicio, Date fechaFin, int habitacionID, int extrasID, int regimenID) {
        this.ID = ID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacionID = habitacionID;
        this.extrasID = extrasID;
        this.regimenID = regimenID;
    }

    public Reserva() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    @Override
    public String toString() {
        return "Reserva{" +
                "ID=" + ID +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", habitacionID=" + habitacionID +
                ", extrasID=" + extrasID +
                ", regimenID=" + regimenID +
                '}';
    }
}
