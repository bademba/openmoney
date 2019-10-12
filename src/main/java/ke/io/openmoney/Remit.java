/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney;

import com.brian.db.DBConnector;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import ke.io.openmoney.agency.AgencyDAO;
import ke.io.openmoney.agency.AgencyImpl;
import ke.io.openmoney.agency.AgencyUtils;
import ke.io.openmoney.agency.AgentDAO;
//import ke.io.openmoney.agency.GetAllAgency;

/**
 *
 * @author BADEMBA
 */
@WebService
@Path("/remit")
public class Remit {

    //localhost:7140/openmoney/v1/remit/test
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/test")
    @WebMethod
    public String test() {
        LocalDate myObj = LocalDate.now();
        String resp = "{\"date\":\"" + myObj + "\"}";
        System.out.println(myObj.toString());
        return resp;
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//     
//    @Path("/agency/create")
//    @WebMethod
//    public Response createAgency(AgencyUtils agencyUtils) {
//        AgencyDAO agencyDao = new AgencyDAO();
//        agencyDao.createAgency(agencyUtils);
//        String ok="{\"responseId\":\""+agencyUtils.getUuid()+"\",\"responseMessage\":\"success\"}";
//        System.out.println("Response:"+ok);
//        return Response.status(201).entity(ok).build();
//    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    @Path("/agency/create")
    @WebMethod
    public Response createAgency(AgencyUtils agencyUtils) {
        AgentDAO  agentDAO =  new AgencyImpl();
        return agentDAO.createAgency(agencyUtils);
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/agency/getall")
    public List<AgencyUtils> getAllAgency() {
        AgentDAO agentDAO = new AgencyImpl();
        List<AgencyUtils> list = agentDAO.getAllAgency();
        return list;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/agency/getone/{id}")
    public AgencyUtils getOne(@PathParam("id") String id) {
        AgentDAO agentDAO = new AgencyImpl();
        return agentDAO.getOneAgency(id);
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/agency/update/{agencyCode}")
    public AgencyUtils getOne(@PathParam("agencyCode") int agencyCode) {
        AgentDAO agentDAO = new AgencyImpl();
        return agentDAO.updateAgency(agencyCode);
    }

}
