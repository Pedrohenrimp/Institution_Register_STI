package com.InstitutionRegistry.controller;

import com.InstitutionRegistry.error.ResourceNotFoundException;
import com.InstitutionRegistry.model.Institution;
import com.InstitutionRegistry.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping("institution")
public class InstitutionController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    private final InstitutionRepository institutionDAO;
    @Autowired
    public InstitutionController(InstitutionRepository institutionDAO) {
        this.institutionDAO = institutionDAO;
    }

    @GetMapping(path = "/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView("register");
        mv.addObject("institution", new Institution());

        return mv;
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(institutionDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping
    public ModelAndView findByName(@RequestParam(name = "string", required = false, defaultValue = "") String string) {
        ModelAndView modelAndView = new ModelAndView("search");
        if(string == null || string.isBlank()) {
            modelAndView.addObject("institutions", institutionDAO.findAll());
        }
        else {
            modelAndView.addObject("institutions", institutionDAO.findByNameLike("%"+string+"%"));
        }
        return modelAndView;
    }

    @PostMapping(path = "/registerInstitution")
    @Transactional
    public String save(@Valid Institution institution) {
        institutionDAO.save(institution);
        return "redirect:register";
    }

    @DeleteMapping(path = "/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfStudentExists(id);
        institutionDAO.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> update(@RequestBody Institution institution){
        verifyIfStudentExists(institution.getId());
        institutionDAO.save(institution);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfStudentExists (Long id){
        if(institutionDAO.findById(id).isEmpty()){
            throw new ResourceNotFoundException("Student Not Found");
        }
    }
}
