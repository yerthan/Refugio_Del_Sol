package Operaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegimenDAO  implements I_RegimenDAO{

    private static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://localhost/refugio_del_sol";
        try {
            ArrayList<String> datos = LecturaOEscrituraFicheros.leerUsuarioContrasena();

            con = DriverManager.getConnection(url, datos.get(0), datos.get(1));
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

        String consulta = "SELECT * FROM refugio_del_sol.Regimen WHERE ID = ?";
        Connection con = conectar();

        try(PreparedStatement ps = con.prepareStatement(consulta)){

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Regimen r = new Regimen();
                r.setID(rs.getInt("ID"));
                r.setTipo(rs.getString("Tipo"));
                r.setDescripcion(rs.getString("Descripcion"));
                r.setPrecio(rs.getDouble("Precio"));

                return r;
            }else{
                System.out.println("No existe el regimen");
                return null;
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("error");
        return null;

    }

    @Override
    public void update(Regimen regimen, double precio) {

        List<Regimen> regimens = listarRegimen();
        Connection con = conectar();

        String consulta = "UPDATE refugio_del_sol.Regimen SET Regimen.Precio";

        if(regimens.contains(regimen)){
            try(PreparedStatement ps = con.prepareStatement(consulta)) {
                ps.setDouble(4, precio);
                int filasActualizadas = ps.executeUpdate();
                System.out.println("Regimen actualizado");
            }catch (Exception e){
                System.out.println(e);
            }
        }else{
            System.out.println("No existe el regimen ");
        }
    }

    @Override
    public void delete(int id) {

        String consulta = "DELETE FROM refugio_del_sol.Regimen WHERE ID = ?";

        Connection con = conectar();

        try (PreparedStatement ps = con.prepareStatement(consulta))  {

            ps.setInt(1, id);

            int filasBorradas = ps.executeUpdate();
            System.out.println("filasBorradas : " + filasBorradas);

        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error al borrar Regimen");
        }


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
