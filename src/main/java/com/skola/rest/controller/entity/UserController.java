package com.skola.rest.controller.entity;

import com.skola.rest.Database;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.skola.rest.dto.Userdto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.skola.rest.Database.userHashMap;

@RestController
@RequestMapping(value ="/user")
public class UserController {

    private ArrayList<UUID> userUUIDs = new ArrayList<>();


    @PostMapping("/create")
            ResponseEntity<String> createUser(@RequestBody Userdto user) {


            UUID uuid = UUID.randomUUID();
            userUUIDs.add(uuid);
            userHashMap.put(uuid, user);



        return new ResponseEntity<>("User Created: " + user.getName(), HttpStatus.OK);

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

        List<Userdto> userValues = new ArrayList<Userdto>(userHashMap.values());
        StringBuilder responseBuilder = new StringBuilder("Users: ");

        for(Userdto value : userValues) {
            responseBuilder.append(value.toString()).append("\n");

        }

        return new ResponseEntity<>(responseBuilder.toString(), HttpStatus.OK);

    }

    }
