package ma.enset.demo.repository;

import ma.enset.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByNameContains(String mc);

    List<Patient> findByScoreGreaterThan(int score);


    @Query("Select p from Patient p where p.name Like :x")
    List<Patient> search(@Param("x") String mc);

    @Query("Select p from Patient p where p.score>:x")
    List<Patient> searchByScore(@Param("x") int s);
}
