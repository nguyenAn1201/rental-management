package com.example.rentalmanagement.service;

import com.example.rentalmanagement.model.Owner;

public interface OwnerService {
    Owner getOwnerById(Long id);
    Owner createOwner(Owner owner);
    Owner updateOwner(Owner owner);
    void deleteOwner(Long id);
}
