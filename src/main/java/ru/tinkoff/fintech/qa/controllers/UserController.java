package ru.tinkoff.fintech.qa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.fintech.qa.controllers.models.DefaultResponse;
import ru.tinkoff.fintech.qa.controllers.models.UserEntity;
import ru.tinkoff.fintech.qa.repository.service.UsersDBService;

@RestController
public class UserController {
    @Autowired
    UsersDBService usersDBService;

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DefaultResponse> add(@RequestBody UserEntity user) {
        usersDBService.add(user);
        return ResponseEntity.ok().body(new DefaultResponse("Done"));
    }

    @PostMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DefaultResponse> update(@RequestBody UserEntity user) {
        usersDBService.update(user);
        return ResponseEntity.ok().body(new DefaultResponse("Done"));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable Integer id) {
        usersDBService.delete(id);
        return ResponseEntity.ok().body(new DefaultResponse("Done"));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<UserEntity> get(@PathVariable Integer id) {
        UserEntity user = usersDBService.get(id);
        return ResponseEntity.ok().body(user);
    }

}
