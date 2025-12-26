package com.example.spring_dec2025.service;

import com.example.spring_dec2025.model.Doctor;
import com.example.spring_dec2025.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public String addDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return "Doctor is saved successfully!";
    }

    public Doctor findById(int id){
        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(optionalDoctor.isPresent()){
            return optionalDoctor.get();
        }
        else{
            return null;
        }
    }

    public List<Doctor> findAll(){
        List<Doctor> list = doctorRepository.findAll();
        return list;
    }

    public String countAll(){
        long count = doctorRepository.count();
        return "Total number of doctors available are : " + count;
    }

    public String deleteDoctorById(int id){
        doctorRepository.deleteById(id);
        return "Doctor with id : "+id+" got deleted successfully!";
    }

    public String updateUsingPut(int id, Doctor newDoctorRequest){

        Doctor existingDoctor = findById(id);
        if(existingDoctor != null){
            doctorRepository.save(newDoctorRequest);
            return "Doctor with id : " +id+" is updated successfully!";
        }
        else{
            return "Doctor with id : "+ id+" is not found!";
        }
    }

    public String updateUsingPatch(int id, String newName, String newEmail){

        Doctor existingDoctor = findById(id);
        if(existingDoctor != null){
            existingDoctor.setName(newName);
            existingDoctor.setEmail(newEmail);
            doctorRepository.save(existingDoctor);
            return "Doctor with id : " +id+" is updated successfully!";
        }
        else{
            return "Doctor with id : "+ id+" is not found!";
        }
    }
}
