
package mg.org.ATENEA.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import mg.org.ATENEA.conexion.ConexionMysql;
import mg.org.ATENEA.controller.C_Vehiculo;
import mg.org.ATENEA.model.M_GetAllVehiculo;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


@Path("vehiculo")

public class Rest_Vehiculo {
    
    @Path("insert")
    @POST
    @Produces(MediaType.APPLICATION_JSON)

    public Response insert(
    @FormParam("numeroSerie") @DefaultValue("") String NumeroSerie,        
    @FormParam("modelo") @DefaultValue("") String Modelo,
    @FormParam("color") @DefaultValue("") String Color,
    @FormParam("tapiceria") @DefaultValue("") String Tapiceria,
    @FormParam("anio") @DefaultValue("0") Integer Anio,
    @FormParam("IDV") @DefaultValue("") String IDV,
    @FormParam("fraCompra") @DefaultValue("") String FraCompra,
    @FormParam("diasStock") @DefaultValue("0") Integer DiasStock,
    @FormParam("ubicacion") @DefaultValue("0") Integer Ubicacion,
    @FormParam("categoria") @DefaultValue("0") Integer Categoria,
    @FormParam("estatus") @DefaultValue("0") Integer Estatus
    ){
        C_Vehiculo cp = new C_Vehiculo();
        
        System.out.println("Numero de serie: " + NumeroSerie + " Modelo: "+ Modelo+" Color: " +Color+ " Tapiceria: "+Tapiceria+ " Anio: "+Anio+ " IDV: "+IDV+ " FraCompra: "+FraCompra+ " DiasStock: "+DiasStock+ " Ubicacion: "+Ubicacion+ " Categoria: "+Categoria+ " Estatus: "+Estatus);
    cp.agregarVehiculo(NumeroSerie, Modelo, Color, Tapiceria, Anio, IDV, FraCompra, DiasStock, Ubicacion, Categoria, Estatus);
    String out = """
    {"Numero de serie":"%s"}
    """;
    out = String.format(out,NumeroSerie);
    return Response.status(Response.Status.CREATED).entity(out).build();
    }
    
    @Path("update")
    @POST
    @Produces(MediaType.APPLICATION_JSON)

    public Response update(
    @FormParam("numeroSerie") @DefaultValue("") String NumeroSerie,        
    @FormParam("modelo") @DefaultValue("") String Modelo,
    @FormParam("color") @DefaultValue("") String Color,
    @FormParam("tapiceria") @DefaultValue("") String Tapiceria,
    @FormParam("anio") @DefaultValue("0") Integer Anio,
    @FormParam("IDV") @DefaultValue("") String IDV,
    @FormParam("fraCompra") @DefaultValue("") String FraCompra,
    @FormParam("diasStock") @DefaultValue("0") Integer DiasStock,
    @FormParam("ubicacion") @DefaultValue("0") Integer Ubicacion,
    @FormParam("categoria") @DefaultValue("0") Integer Categoria,
    @FormParam("estatus") @DefaultValue("0") Integer Estatus
    ){
        C_Vehiculo cp = new C_Vehiculo();
        
    System.out.println("Numero de serie: " + NumeroSerie + " Modelo: "+ Modelo+" Color: " +Color+ " Tapiceria: "+Tapiceria+ " Anio: "+Anio+ " IDV: "+IDV+ " FraCompra: "+FraCompra+ " DiasStock: "+DiasStock+ " Ubicacion: "+Ubicacion+ " Categoria: "+Categoria+ " Estatus: "+Estatus);
    cp.actualizarVehiculo(NumeroSerie, Modelo, Color, Tapiceria, Anio, IDV, FraCompra, DiasStock, Ubicacion, Categoria, Estatus);
    String out = """
    {"Numero de serie":"%s"}
    """;
    out = String.format(out,NumeroSerie);
    return Response.status(Response.Status.CREATED).entity(out).build();
    }
    
    
    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";
 
        try {
            C_Vehiculo cp = new C_Vehiculo();
            List<M_GetAllVehiculo> vehiculos = cp.GetAllVehiculos();
            Gson gs = new Gson();
            out = gs.toJson(vehiculos);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
 
        return Response.status(Response.Status.OK).entity(out).build();
    }


    
}
