
package mg.org.ATENEA.controller;

import mg.org.ATENEA.model.M_GetAllVehiculo;
import mg.org.ATENEA.model.M_Vehiculo;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import mg.org.ATENEA.conexion.ConexionMysql;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C_Vehiculo {
    
  
  public List<M_GetAllVehiculo> GetAllVehiculos() {
        //Se crea una lista llamada personas que almacenará objetos de tipo Persona.
        List<M_GetAllVehiculo> vehiculos = new ArrayList<>(); 
        // Se define una consulta SQL que selecciona todos los registros de la tabla "persona".
        String query = "SELECT * FROM GetAllVehiculo ORDER BY numeroSerie;";
 
        // Se establece una conexión con la base de datos.
        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
 
            // Se recorren los resultados y se crea un objeto Persona para cada registro.
            while (rs.next()) {
                
                String NumeroSerie = rs.getString("numeroSerie");
                String Modelo = rs.getString("modelo");
                String Color = rs.getString("color");
                String Tapiceria = rs.getString("tapiceria");
                int Anio = rs.getInt("anio");
                int IDV = rs.getInt("IDV");
                String FraCompra = rs.getString("fraCompra");
                int DiasStock = rs.getInt("diasStock");
                String Ubicacion = rs.getString("ubicacion");
                String Categoria = rs.getString("categoria");
                String Estatus = rs.getString("estatus");
                
                
                // Cada objeto Persona se agrega a la lista personas.
                M_GetAllVehiculo vehiculo = new M_GetAllVehiculo( NumeroSerie, Modelo, Color, Tapiceria, Anio, IDV, FraCompra, DiasStock, Ubicacion, Categoria, Estatus);
                vehiculos.add(vehiculo);
            }
            // Se cierran los recursos de la base de datos
            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Finalmente, se devuelve la lista personas que contiene todos los registros de la tabla "persona".
        return vehiculos;
    }
  
  public void agregarVehiculo(String NumeroSerie, String Modelo, String Color, String Tapiceria, int Anio, String IDV, String FraCompra, int DiasStock, int Ubicacion, int Categoria, int Estatus){
        
        String query = "CALL InsertarVehiculo(" +'"'+NumeroSerie+'"'+ "," +IDV+ "," +'"'+FraCompra+'"'+ "," +'"'+DiasStock+'"'+ "," +Anio+ "," +'"'+Tapiceria+'"'+ "," +'"'+Color+'"'+ "," +Ubicacion+ "," +'"'+Modelo+'"'+ "," +Categoria+ "," +Estatus+ ")";
        System.out.println(query);
        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

  public void actualizarVehiculo(String NumeroSerie, String Modelo, String Color, String Tapiceria, int Anio, String IDV, String FraCompra, int DiasStock, int Ubicacion, int Categoria, int Estatus){
        
        String query = "CALL ActualizarVehiculo(" +'"'+NumeroSerie+'"'+ "," +IDV+ "," +'"'+FraCompra+'"'+ "," +'"'+DiasStock+'"'+ "," +Anio+ "," +'"'+Tapiceria+'"'+ "," +'"'+Color+'"'+ "," +Ubicacion+ "," +'"'+Modelo+'"'+ "," +Categoria+ "," +Estatus+ ")";
        System.out.println(query);
        try {
            ConexionMysql connMysql = new ConexionMysql();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.execute();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
  
}
