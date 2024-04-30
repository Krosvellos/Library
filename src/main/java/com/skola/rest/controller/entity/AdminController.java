package com.skola.rest.controller.entity;

import com.skola.rest.Database;
import com.skola.rest.dto.Admindto;
import com.skola.rest.dto.Userdto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.skola.rest.Database.adminHashMap;
import static com.skola.rest.Database.userHashMap;

@RestController
@RequestMapping(value ="/admin")
public class AdminController {

    private ArrayList<UUID> adminUUIDs = new ArrayList<>();

    @PostMapping("/create")
    ResponseEntity<String> createAdmin(@RequestBody Admindto admin) {

        UUID uuid = UUID.randomUUID();

        for (Map.Entry<UUID, Admindto> entry : Database.adminHashMap.entrySet()) {
            Admindto adminValue = entry.getValue();
            if (adminValue != null && adminValue.getEmail().equals(admin.getEmail())) {
                return new ResponseEntity<>("This admin already exists!", HttpStatus.NOT_FOUND);
            }
        }

        adminUUIDs.add(uuid);
        adminHashMap.put(uuid, admin);



        return new ResponseEntity<>("Admin created: "+ admin.getId(), HttpStatus.OK);

    }

    @PutMapping("/update")
    ResponseEntity<String> updateAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

    @GetMapping("/list")
    ResponseEntity<String> listAdmin() {

        List<Admindto> adminValues = new ArrayList<Admindto>(adminHashMap.values());
        StringBuilder responseBuilder = new StringBuilder("Admins: ");

        for(Admindto value : adminValues) {
            responseBuilder.append(value.toString()).append("\n");

        }

        return new ResponseEntity<>(responseBuilder.toString(), HttpStatus.OK);

    }

    @DeleteMapping("/delete")
    ResponseEntity<String> deleteAdmin() {


        return new ResponseEntity<>("Hello world", HttpStatus.OK);

    }

}
