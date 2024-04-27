package com.skola.rest.controller.entity;

import com.skola.rest.Database;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skola.rest.dto.Userdto;

import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping(value ="/user")
public class UserController {

    private ArrayList<UUID> userUUIDs = new ArrayList<>();


    @PostMapping("/create")
            ResponseEntity<String> createUser(@RequestBody Userdto user) {


            UUID uuid = UUID.randomUUID();
            userUUIDs.add(uuid);
            Database.userHashMap.put(uuid, user);



        return new ResponseEntity<>("User Created", HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteUser() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateUser() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listUser() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    }
