package com.ps.repository;

import com.ps.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AddressRepository extends JpaRepository<AddressEntity,AddressEntity> {
    @Query("from com.ps.entities.AddressEntity a where a.person_id=?1")
    public AddressEntity getAddressByPersonId(int personId);
}
