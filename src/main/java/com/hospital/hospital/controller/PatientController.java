package com.hospital.hospital.controller;


import com.hospital.hospital.exception.ResourceNotFoundException;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/ead/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping
    public List<Patient> getAllPatients(){return patientRepository.findAll();}

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient){return patientRepository.save(patient);}

    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        return ResponseEntity.ok(patient);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable long id){

        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        patientRepository.delete(patient);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("{id}")
    public ResponseEntity<Patient> updateDoctor(@PathVariable long id, @RequestBody Patient patientDetails){
        Patient updatePatient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Employee not exist with id: " + id));

        updatePatient.setName(patientDetails.getName());
        updatePatient.setAge(patientDetails.getAge());
        updatePatient.setAddress(patientDetails.getAddress());

        patientRepository.save(updatePatient);

        return ResponseEntity.ok(updatePatient);

    }




}
