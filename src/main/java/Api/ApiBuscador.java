package Api;

import Indexer.Indice;
import Indexer.LectorArchivos;
import Menu.Buscador;
import Persistencia.VocabularioEnMemoria;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/")
public class ApiBuscador {

    @Inject
    VocabularioEnMemoria vocabularioEnMemoria;

    @GET
    @Path("/test")
    public Response test() {
        return Response.ok("test exitoso UwU").build();
    }

@GET
@Path("/buscar")
    public Response busqueda(@QueryParam("busqueda") String busqueda, @QueryParam("r") Integer r) throws JSONException {
        Buscador buscador = new Buscador(vocabularioEnMemoria.getVocFinal());
        String json = new JSONObject(buscador.buscador(busqueda, r)).toString();
        return Response.ok(json).build();
    }

    @GET
    @Path("/mostrar")
    public Response mostrarDocumento(@QueryParam("nombreDocumento") String nombreDocumento) throws FileNotFoundException {
        return Response.ok(LectorArchivos.LeerArchivo("C:\\Users\\Juanpa\\Desktop\\DLC-MotorDeBusqueda\\DocumentosTP1\\" + nombreDocumento + ".txt")).build();
   }

   @PUT //???????
   @Path("/agregar")
   @Consumes(MediaType.APPLICATION_JSON)
    public Response cargarDocumento(File file) throws IOException{
        LectorArchivos.cargarArchivo(file, vocabularioEnMemoria.getVocFinal());
        return Response.ok("ok").build();
   }

}
