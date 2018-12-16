package com.uday.restws.service;

import com.uday.restws.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patientservice")
@Produces("application/xml,application/json")
@Consumes("application/xml,application/json")
public interface PatientService {

    @Path(value="/patients")
    @GET
    List<Patient> getPatients();

    @GET
    @Path("/patients/{id}")
    Patient getPatient(@PathParam("id") Long id);

    @POST
    @Path("/patients")
    Patient createPatient(Patient patient);

    @PUT
    @Path("/patients")
    Response updatePatient(Patient patient);

    @DELETE
    @Path("/patients/{id}")
    Response deletePatient(@PathParam("id") Long id);
}
