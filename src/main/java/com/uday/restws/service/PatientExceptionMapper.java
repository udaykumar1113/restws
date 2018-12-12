package com.uday.restws.service;

import com.uday.restws.exception.NoPatientException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class PatientExceptionMapper implements ExceptionMapper<NoPatientException> {
    @Override
    public Response toResponse(NoPatientException e) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("\"status\":\"error\"");
        stringBuilder.append(",");
        stringBuilder.append("\"message\":\"Record not found\"");
        stringBuilder.append("}");
        return Response.serverError().entity(stringBuilder.toString())
                .type(MediaType.APPLICATION_JSON_TYPE).build();
    }
}
