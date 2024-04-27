package com.skola.rest.controller.entity;

import com.skola.rest.dto.Admindto;
import com.skola.rest.dto.Userdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/admin")
public class AdminController {

    @PostMapping("/create")
    ResponseEntity<String> createAdmin(@RequestBody Admindto admin) {


        return new ResponseEntity<>("Admin created", HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

}
