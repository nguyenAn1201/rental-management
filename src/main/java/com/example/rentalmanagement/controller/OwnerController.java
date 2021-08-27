package com.example.rentalmanagement.controller;

import com.example.rentalmanagement.model.Owner;
import com.example.rentalmanagement.service.OwnerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class OwnerController {
    @Autowired
    OwnerServiceImpl ownerService;

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
        return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
    }

    @PostMapping("/owner")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        return new ResponseEntity<>(ownerService.createOwner(owner), HttpStatus.CREATED);
    }

    @PutMapping("/owner")
    public ResponseEntity<Owner> updateOwner(Owner owner) {
        return new ResponseEntity<>(ownerService.updateOwner(owner), HttpStatus.OK);
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<Long> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
