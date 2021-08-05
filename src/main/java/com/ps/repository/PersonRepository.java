package com.ps.repository;

import com.ps.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,PersonEntity> {
    @Query("from com.ps.entities.PersonEntity p where p.person_ssn=?1")
    PersonEntity getPersonBySSN(String personSSN);
}
