package com.kotlin.restapi.controllers

import com.kotlin.restapi.entities.UserDetails
import com.kotlin.restapi.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/user")
class UserController {
    @Autowired
    lateinit var service: UserService

    @PostMapping("/save")
    fun saveUser(@RequestBody userDetails: UserDetails): ResponseEntity<UserDetails> {
        return ResponseEntity.ok(service.saveUser(userDetails))
    }

    @GetMapping("/get/all")
    fun getAllUsers(): ResponseEntity<List<UserDetails>> {
        return ResponseEntity.ok(service.getAllUsers())
    }


    @GetMapping("/get/{userId}")
    fun getUserById(@PathVariable userId:Int): ResponseEntity<UserDetails> {
        return ResponseEntity.ok(service.getUserById(userId))
    }

    @PutMapping("/update/")
    fun updateUserDetails(@RequestBody userDetails: UserDetails): ResponseEntity<UserDetails> {
        return ResponseEntity.ok(service.updateUserDetails(userDetails))
    }

    @DeleteMapping("/delete/{userId}")
    fun deleteUserDetails(@PathVariable userId:Int): ResponseEntity<Unit> {
        return ResponseEntity.ok(service.deleteUserDetails(userId))
    }
}