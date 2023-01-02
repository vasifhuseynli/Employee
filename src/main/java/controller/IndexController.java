package controller;


import model.EmployeeModel;
import persistence.service.IService;
import persistence.service.ServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/index")
public class IndexController {

    private IService IService = new ServiceImpl();

    @Path("/get")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public List<EmployeeModel> getAllEmployee() {
        return IService.getAllEmployee();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void add(EmployeeModel employeeModel) {
        IService.add(employeeModel);
    }

    @Path("/update")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void update(EmployeeModel employeeModel) {
        IService.update(employeeModel);
    }

    @Path("/delete/{id}")
    @DELETE
    public void delete(@PathParam("id") Integer id) {
        IService.delete(id);
    }
}
