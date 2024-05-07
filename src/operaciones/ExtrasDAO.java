package operaciones;

import java.sql.*;

public class ExtrasDAO {

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/refugio_del_sol";
        try {
            con = DriverManager.getConnection(url, "root", "administrador");
        } catch (SQLException ex) {
            System.out.println("Error al conectar a la BBDD.");
        }

        return con;
    }

    public String create(Extras e) {
        String resultado = "";
        Connection con = conectar();
        //nombre, precio, ID
        String sql = "INSERT INTO Extras VALUES (?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, e.getID());
            sentencia.setString(2, e.getNombre());
            sentencia.setDouble(3, e.getPrecio());
        } catch (SQLException ex){
            ex.getErrorCode();
            return "error";

        } finally {
            try {
                con.close();
            } catch (SQLException error) {
                error.printStackTrace();
                return "error";
            }
        }


        return "Creacion de los extras ha sido correcta";
    }



    public Extras read(int id) {
        return null;
    }


    public void update(Extras extra) {

    }


    public void delete(int id) {

    }
}
