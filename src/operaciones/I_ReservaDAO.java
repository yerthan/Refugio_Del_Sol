package operaciones;

public interface I_ReservaDAO {
    public String create (Reserva reserva);
    public Reserva read (int id);
    public void update (Reserva reserva, double precio);
    public void delete (int id);
}
