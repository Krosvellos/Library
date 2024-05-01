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

        for (Map.Entry<UUID, Userdto> entry : Database.userHashMap.entrySet()) {
            Userdto userValue = entry.getValue();
            if (userValue != null && userValue.getEmail().equals(user.getEmail())) {
                return new ResponseEntity<>("This user already exists!", HttpStatus.NOT_FOUND);
            }
        }

            userUUIDs.add(uuid);
            userHashMap.put(uuid, user);
            System.out.println(userHashMap);
            System.out.println("User Email: " +user.getEmail());


        return new ResponseEntity<>("User Created: " + user.getName(), HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteUser(@RequestBody Map<String, String> requestBody) {
        String id = requestBody.get("id");
        UUID userId = UUID.fromString(id);
        for(Map.Entry<UUID, Userdto> entry: userHashMap.entrySet()) {
            Userdto user = entry.getValue();
            if (user != null && user.getId().equals(userId)){
                userHashMap.remove(user.getId());
                System.out.println(userHashMap);
                return new ResponseEntity<>("User has been deleted!",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("There is no such user.", HttpStatus.NOT_FOUND);

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

    @GetMapping("listone")
    ResponseEntity<String> getUser(@RequestBody Map<String, String> requestBody) {

        String email = requestBody.get("email");

        for(Map.Entry<UUID, Userdto> entry: userHashMap.entrySet()) {
            Userdto user = entry.getValue();
            if (user != null && user.getEmail().equals(email)){
                return new ResponseEntity<>("User email: "+ user.getEmail() + ", UserUUID: "+ user.getId(),HttpStatus.OK);

            }
        }

        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);

    }

    }
