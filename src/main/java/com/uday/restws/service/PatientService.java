package com.uday.restws.service;

import com.uday.restws.model.Patient;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/patientservice")
public interface PatientService {

    @GET
    @Path("/patients")
    List<Patient> getPatients();

    @GET
    @Path("/patients/{id}")
    Patient getPatient(@PathParam("id") Long id);

    @POST
    @Path("/patients")
    Response createPatient();

    @PUT
    @Path("/patients")
    Response updatePatient();

    @DELETE
    @Path("/patients")
    Response deletePatient();
}
