package com.example.rentalmanagement.repository;

import com.example.rentalmanagement.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findOwnerById(Long id);

}
