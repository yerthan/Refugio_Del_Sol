package operaciones;

public interface I_HabitacionDAO {
    public String create (Habitacion habitacion);
    public Habitacion read (int id);
    public void update (Habitacion habitacion, double precio);
    public void delete (int id);
}
