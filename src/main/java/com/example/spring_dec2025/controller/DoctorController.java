package com.example.spring_dec2025.controller;

import com.example.spring_dec2025.model.Doctor;
import com.example.spring_dec2025.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor){
        String response = doctorService.addDoctor(doctor);
        return response;
    }

    @GetMapping("/findById/{id}")
    public Doctor findDoctorById(@PathVariable int id){
        Doctor doctor = doctorService.findById(id);
        return doctor;
    }

    @GetMapping("/findAll")
    public List<Doctor> findAllDoctors(){
        List<Doctor> list = doctorService.findAll();
        return list;
    }

    @GetMapping("/count")
    public String countAllDoctors(){
        String response = doctorService.countAll();
        return response;
    }

    @DeleteMapping("/deleteDoctorById/{id}")
    public String deleteDoctorById(@PathVariable int id){
        String response = doctorService.deleteDoctorById(id);
        return response;
    }

    @PutMapping("/putUpdate/{id}")
    public String updateDoctorUsingPut(@PathVariable int id,@RequestBody Doctor doctor){
        String response = doctorService.updateUsingPut(id, doctor);
        return response;
    }

    @PatchMapping("/patchUpdate/{id}")
    public String updateDoctorUsingPut(@PathVariable int id,@RequestParam String newName,@RequestParam String newEmail){
        String response = doctorService.updateUsingPatch(id, newName, newEmail);
        return response;
    }
}
