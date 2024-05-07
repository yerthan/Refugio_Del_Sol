package operaciones;

import java.util.Date;

public class Reserva {

        Date fechaInicio;
        Date fechaFin;
        int habitacionId;
        int extrasId;
        int regimenId;
        int ID;

    public Reserva() {

    }

    public Reserva(Date fechaInicio, Date fechaFin, int habitacionId, int extrasId, int regimenId, int ID) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacionId = habitacionId;
        this.extrasId = extrasId;
        this.regimenId = regimenId;
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

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getExtrasId() {
        return extrasId;
    }

    public void setExtrasId(int extrasId) {
        this.extrasId = extrasId;
    }

    public int getRegimenId() {
        return regimenId;
    }

    public void setRegimenId(int regimenId) {
        this.regimenId = regimenId;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", habitacionId=" + habitacionId +
                ", extrasId=" + extrasId +
                ", regimenId=" + regimenId +
                ", ID=" + ID +
                '}';
    }




}
