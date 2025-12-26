package com.example.spring_dec2025.service;

import com.example.spring_dec2025.model.Patient;
import com.example.spring_dec2025.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public String addPatient(Patient patient){
        patientRepository.save(patient);
        return "Patient saved successfully..!!";
    }

    public Patient findPatientById(int id){
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if(patientOptional.isPresent()){
            return patientOptional.get();
        }
        else{
            return null;
        }
    }

    public List<Patient> findAll(){
        List<Patient> list = patientRepository.findAll();
        return list;
    }

    public String deleteById(int id){
        patientRepository.deleteById(id);
        return "Patient with id : "+id+" deleted successfully!";
    }

    public String countAll(){
        long count = patientRepository.count();
        return "Total number of patients are : "+count;
    }

    public String updateUsingPut(int id, Patient newPatientRequest){
        Patient existingPatient = findPatientById(id);
        if(existingPatient != null){
            patientRepository.save(newPatientRequest);
            return "patient with id : "+id+" updated successfully!";
        }
        else{
            return "patient with id : "+id+" is not found.";
        }
    }

    public String updateUsingPatch(int id, String newName){
        Patient existingPatient = findPatientById(id);
        if(existingPatient != null){
            existingPatient.setName(newName);
            patientRepository.save(existingPatient);
            return "patient with id : "+id+" updated successfully!";
        }
        else{
            return "patient with id : "+id+" is not found.";
        }
    }
}
