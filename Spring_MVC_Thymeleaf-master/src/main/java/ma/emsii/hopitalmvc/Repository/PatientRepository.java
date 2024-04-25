package ma.emsii.hopitalmvc.Repository;

import ma.emsii.hopitalmvc.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    //First method search and  pageable for the pagination  gitet for the trie Sort
    Page<Patient> findByNomContains(String keyword, Pageable pageable);// pagination

    // Second Method of search
    @Query("select p from Patient p where p.nom like :x")
    Page<Patient> chercher(@Param("x") String keyword, Pageable pageable);
}
