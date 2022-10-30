package com.hospital.hospital;

import com.hospital.hospital.model.Doctor;
import com.hospital.hospital.model.Patient;
import com.hospital.hospital.repository.DoctorRepository;
import com.hospital.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Autowired
    private DoctorRepository doctorRepository;
	@Autowired
	private PatientRepository patientRepository;

	@Override
	public void run(String... args) throws Exception{

//		Doctor doctor = new Doctor();
//		doctor.setName("R Senanayaka");
//		doctor.setStatus("Eye Specialist");
//		doctor.setFees("Rs 1300");
//		doctorRepository.save(doctor);

//		Patient patient = new Patient();
//		patient.setName("hhhh");
//		patient.setAge("56");
//		patient.setAddress("aaaaa bbbgga");
//		patientRepository.save(patient);



	}

}
