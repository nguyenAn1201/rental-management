package com.example.rentalmanagement.service;

import com.example.rentalmanagement.model.Owner;
import com.example.rentalmanagement.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OwnerServiceImpl implements OwnerService{
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    @Transactional
    public Owner getOwnerById(Long id) {
        return ownerRepository.findOwnerById(id);
    }

    @Override
    @Transactional
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public Owner updateOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    @Transactional
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

}
