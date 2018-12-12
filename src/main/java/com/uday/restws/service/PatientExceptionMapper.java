package com.uday.restws.service;

import com.uday.restws.exception.NoPatientException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientExceptionMapper implements ExceptionMapper<NoPatientException> {
    @Override
    public Response toResponse(NoPatientException e) {
        return Response.status(404).build();
    }
}
