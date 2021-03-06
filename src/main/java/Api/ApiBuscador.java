package Api;

import Indexer.LectorArchivos;
import Menu.Buscador;
import Persistencia.VocabularioEnMemoria;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;

@Path("/")
public class ApiBuscador {

    @Inject
    VocabularioEnMemoria vocabularioEnMemoria;

    @GET
    @Path("/buscar")
    public Response busqueda(@QueryParam("busqueda") String busqueda, @QueryParam("r") Integer r) throws JSONException {
        Buscador buscador = new Buscador(vocabularioEnMemoria.getVocFinal());
        return Response.ok(buscador.buscador(busqueda, r)).build();
    }

    @GET
    @Path("/mostrar")
    public Response mostrarDocumento(@QueryParam("nombreDocumento") String nombreDocumento) throws FileNotFoundException {
        return Response.ok(LectorArchivos.LeerArchivo("C:\\Users\\Juanpa\\Desktop\\DLC-MotorDeBusqueda\\DocumentosTP1\\" + nombreDocumento + ".txt")).build();
   }

   @POST
   @Consumes({MediaType.APPLICATION_JSON})
   @Path("/agregar")
    public Response cargarDocumento(@QueryParam("ruta") String ruta) throws IOException{
        File file = new File(ruta);
        LectorArchivos.cargarArchivo(file, vocabularioEnMemoria.getVocFinal());
        return Response.ok("ok").build();
   }

}
