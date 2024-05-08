package operaciones;

import java.sql.*;

public class HabitacionDAO implements I_HabitacionDAO{

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
    public String create(Habitacion habitacion) {
        String resultado = "";
        Connection con = conectar();
        //ID, numero, tipo, capacidad, precio
        String sql = "INSERT INTO Habitacion VALUES (?, ?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, habitacion.getID());
            sentencia.setInt(2, habitacion.getNumero());
            sentencia.setString(3, habitacion.getTipo());
            sentencia.setInt(4, habitacion.getCapacidad());
            sentencia.setDouble(5, habitacion.getPrecio());



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


        return "Creacion de Habitacion correcta";
    }


    @Override
    public Habitacion read(int id) {
        String consulta = "DELETE FROM Habitacion WHERE Numero = ?";
        conectar();

        return null;


    }

    @Override
    public void update(Habitacion habitacion) {

    }

    @Override
    public void delete(int id) {

    }
}
