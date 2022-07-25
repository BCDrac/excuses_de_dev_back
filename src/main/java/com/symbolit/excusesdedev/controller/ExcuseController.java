package com.symbolit.excusesdedev.controller;

import com.symbolit.excusesdedev.service.implement.ExcuseService;
import com.symbolit.excusesdedev.entity.DTO.ExcuseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Rest controller for managing the Excuse entity
 *
 * @author Cecile
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/excuse")
public class ExcuseController {

    @Autowired
    private ExcuseService excuseService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ExcuseDTO>> getExcuse(@PathVariable Long id) {
        Optional<ExcuseDTO> excuseDTO = this.excuseService.findOne(id);
        return ResponseEntity.ok().body(excuseDTO);
    }

    /**
     * Get a random Excuse object from database
     *
     * @return a ResponseEntity with a random ExcuseDTO object in body
     *
     * @author Cecile
     */
    @GetMapping("/getRandomExcuse")
    public ResponseEntity<Optional<ExcuseDTO>> getRandomExcuse() {
        Optional<ExcuseDTO> excuseDTO = this.excuseService.findOneRandom();
        return ResponseEntity.ok().body(excuseDTO);
    }


    /**
     * Get all Excuse objects from database
     *
     * @return a ResponseEntity with all ExcuseDTO objects in body
     *
     * @author Cecile
     */
    @GetMapping("/getAllExcuses")
    public ResponseEntity<List<ExcuseDTO>> getAllExcuses() {
        List<ExcuseDTO> listExcuseDTO = this.excuseService.findAll();
        return ResponseEntity.ok().body(listExcuseDTO);
    }


    /**
     * Get all Excuse objects from database in pages
     *
     * @param pageable the pagination information
     * @return a ResponseEntity with ExcuseDTO objects in body in pageable form
     *
     * @author Cecile
     */
    @GetMapping("/getAllExcusesPageable")
    public ResponseEntity<List<ExcuseDTO>> getAllExcusesPageable(Pageable pageable) {
        Page<ExcuseDTO> page = this.excuseService.findAll(pageable);
        return ResponseEntity.ok().body(page.getContent());
    }


    /**
     * Register a new Excuse in the database
     *
     * @param newExcuseDTO the new Excuse to be registered in the form of DTO
     * @return the newly created ExcuseDTO
     *
     * @author Cecile
     */
    @PostMapping("/createExcuse")
    public ResponseEntity<ExcuseDTO> createExcuse(@RequestBody ExcuseDTO newExcuseDTO) {
        ExcuseDTO createdExcuseDTO = this.excuseService.save(newExcuseDTO);
        return ResponseEntity.created(URI.create("/" + createdExcuseDTO.getId())).body(createdExcuseDTO);
    }


}
