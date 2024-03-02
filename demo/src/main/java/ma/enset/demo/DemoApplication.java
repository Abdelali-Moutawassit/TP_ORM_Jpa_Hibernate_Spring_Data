package ma.enset.demo;

import ma.enset.demo.entities.Patient;
import ma.enset.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
    private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		patientRepository.save(new Patient(null ,"Hassan Essali",new Date(95, 0, 20),true,30));
		patientRepository.save(new Patient(null ,"Adil Nami",new Date(96, 2, 24),true,90));
		patientRepository.save(new Patient(null ,"Saad Layoubi",new Date(93, 5, 11),false,100));
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(patient -> {
			System.out.println(patient.toString());
		});
		Patient patient = patientRepository.findById(Long.valueOf(1)).get();
		System.out.println("************************");
		System.out.println(patient.getId());
		System.out.println(patient.getName());
		System.out.println(patient.getDateNaissance());
		System.out.println(patient.isMalade());
		System.out.println(patient.getScore());
		System.out.println("************************");
	}
}
