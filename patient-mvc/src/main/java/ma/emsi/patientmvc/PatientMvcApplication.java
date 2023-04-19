package ma.emsi.patientmvc;

import ma.emsi.patientmvc.entities.Patient;
import ma.emsi.patientmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
//application properties sert  a tester le code en specifiant quelle base de donnée on va utiliser
// where we test our application
@SpringBootApplication
public class PatientMvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatientMvcApplication.class, args);
    }
//creer commandelinerunner pour faire des traitements au demarage et s'executer automatiquement au demarage
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
// on a injecter patrepo et on va ajouter quelque patient
        return args ->{
            // pour ajouter un patient
         patientRepository.save(
                 new Patient(null,"Othmane",new Date(),false,12));
            patientRepository.save(
                    new Patient(null,"aya",new Date(),true,321));
            patientRepository.save(
                    new Patient(null,"nirmine",new Date(),true,65));
            patientRepository.save(
                    new Patient(null,"siham",new Date(),false,32));


                //pour afficher la liste des patients
             patientRepository.findAll().forEach(p->{

                 System.out.println(p.getName());
                     });

        };
    }




}
