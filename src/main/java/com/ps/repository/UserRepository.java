package com.ps.repository;

import com.ps.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    @Query("from com.ps.entities.UserEntity u where u.username=?1")
    List<UserEntity> findByUsername(String username);
}
