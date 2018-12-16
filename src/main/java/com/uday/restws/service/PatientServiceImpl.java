package com.uday.restws.service;

import com.uday.restws.exception.NoPatientException;
import com.uday.restws.model.Patient;
import org.springframework.stereotype.Service;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

    private long counter=256;
    private Map<Long, Patient> patientMap;

    public PatientServiceImpl() {

        patientMap=new HashMap<>();
        Patient patient=new Patient();
        patient.setId(counter++);
        patient.setName("JOHN");
        patientMap.put(patient.getId(), patient);
    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patientList=new ArrayList<>();
        for(Patient patient: patientMap.values())
            patientList.add(patient);

        return patientList;
    }

    @Override
    public Patient getPatient(Long id) {

        Patient currentPatient=patientMap.get(id);
        if(currentPatient==null){
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).build());
        }
        return patientMap.get(id);
    }

    @Override
    public Patient createPatient(Patient patient) {
        patient.setId(counter++);
        patientMap.put(counter,patient);
        //return Response.ok().build();
        return patientMap.get(counter);
    }

    @Override
    public Response updatePatient(Patient patient) {
        Patient currentPatient=patientMap.get(patient.getId());
        if(currentPatient==null){
            patientMap.remove(patient.getId());
            patientMap.put(patient.getId(),patient);
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

    @Override
    public Response deletePatient(Long id) {
        if(patientMap.get(id)!=null){
            patientMap.remove(id);
            return Response.ok().build();
        }
        throw new NoPatientException();
    }
}
