package operaciones;

public interface I_ReservaDAO {
    public String create (Reserva reserva);
    public Reserva read (int id);
    public void update (Reserva reserva);
    public void delete (int id);
}
