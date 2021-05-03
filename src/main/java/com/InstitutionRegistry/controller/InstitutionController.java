package com.InstitutionRegistry.controller;

import com.InstitutionRegistry.error.ResourceNotFoundException;
import com.InstitutionRegistry.model.Institution;
import com.InstitutionRegistry.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("institution")
public class InstitutionController {

    private final InstitutionRepository institutionDAO;
    @Autowired
    public InstitutionController(InstitutionRepository institutionDAO) {
        this.institutionDAO = institutionDAO;
    }

    @GetMapping
    public String home(){
        return "home";
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(institutionDAO.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody Institution institution){
        return new ResponseEntity<>(institutionDAO.save(institution), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfStudentExists(id);
        institutionDAO.deleteById(id);
        return new ResponseEntity<>("Deletado", HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> update(@RequestBody Institution institution){
        verifyIfStudentExists(institution.getId());
        institutionDAO.save(institution);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists (Long id){
        if(!institutionDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("Student Not Found");
        }
    }
}
