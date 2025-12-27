package com.example.spring_dec2025.controller;

import com.example.spring_dec2025.model.Ward;
import com.example.spring_dec2025.service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ward/apis")
public class WardController {

    @Autowired
    WardService wardService;

    @PostMapping("/save")
    public String addWard(@RequestBody Ward ward){
       String response = wardService.saveWard(ward);
       return response;
    }

    @GetMapping("/findById/{id}")
    public Ward findWardById(@PathVariable int id){
        Ward ward = wardService.findWardById(id);
        return ward;
    }

    @GetMapping("/findAll")
    public List<Ward> findAllWards(){
        List<Ward> wards = wardService.findAllWards();
        return wards;
    }

    @GetMapping("/count")
    public String countAll(){
        String response = wardService.countAll();
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteWardById(@PathVariable int id){
        String response = wardService.deleteWardById(id);
        return response;
    }

    @PutMapping("/putUpdate/{id}")
    public String putUpdate(@PathVariable int id, @RequestBody Ward ward){
        String response = wardService.putUpdate(id, ward);
        return response;
    }

    @PatchMapping("/patchUpdate/{id}")
    public String patchUpdate(@PathVariable int id,@RequestParam String name){
        String response = wardService.patchUpdate(id, name);
        return response;
    }
}
