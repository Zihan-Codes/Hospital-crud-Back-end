package com.hospital.hospital.controller;

import com.hospital.hospital.exception.ResourceNotFoundException;
import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ead/doctors")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public List<Doctor> getAllDoctors(){ return doctorRepository.findAll();}

    //build create doctor REST API
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor){return doctorRepository.save(doctor);}

    //build get doctor by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

                return ResponseEntity.ok(doctor);
    }

    //build update doctor REST API
    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable long id,@RequestBody Doctor doctorDetails){
        Doctor updateDoctor = doctorRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id: " + id));

        updateDoctor.setName(doctorDetails.getName());
        updateDoctor.setStatus(doctorDetails.getStatus());
        updateDoctor.setFees(doctorDetails.getFees());

        doctorRepository.save(updateDoctor);

        return ResponseEntity.ok(updateDoctor);
    }

    //build delete doctor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable long id){

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        doctorRepository.delete(doctor);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
