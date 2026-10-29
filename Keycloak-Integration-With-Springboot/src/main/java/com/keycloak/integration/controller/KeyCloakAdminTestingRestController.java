package com.keycloak.integration.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class KeyCloakAdminTestingRestController {

    @GetMapping("/keycloak/test")
    public ResponseEntity<Object> testingUser(){

        try {
            return  new ResponseEntity<>("Admin has been fetch successfully!", HttpStatus.OK) ;
        }
        catch (Exception e){
            return  new ResponseEntity<>(e.getStackTrace(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
    }


}
