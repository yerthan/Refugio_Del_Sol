package operaciones;

public interface I_RegimenDAO {

    public String create (Regimen regimen);
    public Regimen read (int id);
    public void update (Regimen regimen);
    public void delete (int id);
}
