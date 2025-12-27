package com.example.spring_dec2025.service;

import com.example.spring_dec2025.model.Ward;
import com.example.spring_dec2025.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class WardService {

    @Autowired
    WardRepository wardRepository;

    public String saveWard(@RequestBody Ward ward){
        wardRepository.save(ward);
        return "ward save successfully!";
    }

    public Ward findWardById(int id){
        Optional<Ward> optionalWard = wardRepository.findById(id);
        if(optionalWard.isPresent()){
            return optionalWard.get();
        }
        else{
            return null;
        }
    }

    public List<Ward> findAllWards(){
        List<Ward> list = wardRepository.findAll();
        return list;
    }

    public String countAll(){
        long count = wardRepository.count();
        return "total available wards are : "+count;
    }

    public String deleteWardById(int id){
        wardRepository.deleteById(id);
        return "ward with id : "+id+" is deleted.";
    }

    public String putUpdate(int id, Ward newWard){
        Ward existingWard = findWardById(id);
        if(existingWard != null){
            wardRepository.save(newWard);
            return "ward with id : "+id+" is updated.";
        }
        else{
            return "no ward is found with id : "+id;
        }
    }

    public String patchUpdate(int id, String newName){
        Ward existingWard = findWardById(id);
        if(existingWard != null){
            existingWard.setName(newName);
            wardRepository.save(existingWard);
            return "ward with id : "+id+" is updated.";
        }
        else{
            return "no ward is found with id : "+id;
        }
    }
}
