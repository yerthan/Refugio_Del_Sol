package operaciones;

import java.sql.*;

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
        return null;
    }

    @Override
    public void update(Regimen regimen) {

    }

    @Override
    public void delete(int id) {

    }
}
