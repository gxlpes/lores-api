package com.api.lores.specialty;

import com.api.lores.specialty.SpecialtyModel;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/specialties")
public class SpecialtyController {

    final SpecialtyService specialtyService;

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @PostMapping
    public ResponseEntity<Object> saveSpecialty(@RequestBody SpecialtyModel specialtyRequest) {
        var specialtyModel = new SpecialtyModel();
        BeanUtils.copyProperties(specialtyRequest, specialtyModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(specialtyService.save(specialtyModel));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSingleSpecialty(@PathVariable(value = "id") UUID id) {
        Optional<SpecialtyModel> specialtyModelOptional = specialtyService.findById(id);
        if (specialtyModelOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Specialty not found.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(specialtyModelOptional.get());
        }
    }

    @GetMapping
    public ResponseEntity<List<SpecialtyModel>> getAllSpecialties() {
        return ResponseEntity.status(HttpStatus.OK).body(specialtyService.findAll());
    }
}
