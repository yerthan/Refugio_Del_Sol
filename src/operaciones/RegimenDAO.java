package operaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegimenDAO  implements I_RegimenDAO{

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/refugio_del_sol";
        try {
            con = DriverManager.getConnection(url, "root", "root");
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BBDD.");
        }

        return con;
    }

    @Override
    public String create(Regimen regimen) {
        String resultado = "";
        Connection con = conectar();
        //id, tipo, descripcion, precio
        String sql = "INSERT INTO Regimen VALUES (?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, regimen.getID());
            sentencia.setString(2, regimen.getTipo());
            sentencia.setString(3, regimen.getDescripcion());
            sentencia.setDouble(4, regimen.getPrecio());

        } catch (SQLException ex){
            ex.getErrorCode();
            return "error";

        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return "error";
            }
        }


        return "Creacion de Regimen correcta";
    }

    @Override
    public Regimen read(int id) {

        String consulta = "SELECT * FROM refugio_del_sol.Regimen";

        return null;
    }

    @Override
    public void update(Regimen regimen) {

    }

    @Override
    public void delete(int id) {

    }


    public List<Regimen> listarRegimen(){
        List<Regimen> regimens = new ArrayList<>();
        String consulta = "SELECT * FROM refugio_del_sol.Regimen";
        Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){

                Regimen regimen = new Regimen();
                regimen.setID(rs.getInt("ID"));
                regimen.setTipo(rs.getString("Tipo"));
                regimen.setDescripcion(rs.getString("Descripcion"));
                regimen.setPrecio(rs.getDouble("Precio"));

                regimens.add(regimen);

            }
            return regimens;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
