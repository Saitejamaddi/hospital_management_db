package com.example.spring_dec2025.controller;

import com.example.spring_dec2025.model.Patient;
import com.example.spring_dec2025.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient/apis")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient){
        String response = patientService.addPatient(patient);
        return response;
    }

    @GetMapping("/findAll")
    public List<Patient> findAllPatients(){
        List<Patient> list =  patientService.findAll();
        return list;
    }

    @GetMapping("/findById/{id}")
    public Patient findById(@PathVariable int id){
        Patient patient = patientService.findPatientById(id);
        return patient;
    }

    @GetMapping("/countAll")
    public String countAllPatients(){
        String response = patientService.countAll();
        return response;
    }

    @DeleteMapping("/deleteById/{id}")
    public String deleteDoctorById(@PathVariable int id){
       String response = patientService.deleteById(id);
       return response;
    }

    @PutMapping("/putUpdate/{id}")
    public String updateUsingPut(@PathVariable int id,@RequestBody Patient patient){
        String response = patientService.updateUsingPut(id, patient);
        return response;
    }

    @PatchMapping("/patchUpdate/{id}")
    public String updateUsingPatch(@PathVariable int id, @RequestParam String name){
        String response = patientService.updateUsingPatch(id, name);
        return response;
    }
}
