package ma.emsi.patientmvc.repositories;

import ma.emsi.patientmvc.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//interface basée sur spring data
// LONG for type d ID
public interface PatientRepository extends JpaRepository<Patient,Long> {

    Page<Patient> findByNameContains(String kw,Pageable pageable);
}
