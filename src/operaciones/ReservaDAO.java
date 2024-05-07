package operaciones;

import java.sql.*;

public class ReservaDAO implements I_ReservaDAO{

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
    public String create(Reserva reserva) {
        String resultado = "";
        Connection con = conectar();
                                                    //fechaInicio, fechaFin, habitacionID, extrasID, regimenID
        String sql = "INSERT INTO Reserva VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement sentencia;

        try{
            sentencia = con.prepareStatement(sql);
            sentencia.setInt(1, reserva.getID());
            sentencia.setDate(2, Date.valueOf(String.valueOf(reserva.getFechaInicio())));
            sentencia.setDate(3, Date.valueOf(String.valueOf(reserva.getFechaFin())));
            sentencia.setInt(4, reserva.getHabitacionId());
            sentencia.setInt(5, reserva.getExtrasId());
            sentencia.setInt(6, reserva.getRegimenId());

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


        return "Creacion de Reserva correcta";
    }

    @Override
    public Reserva read(int id) {
        return null;
    }

    @Override
    public void update(Reserva reserva) {

    }

    @Override
    public void delete(int id) {

    }
}