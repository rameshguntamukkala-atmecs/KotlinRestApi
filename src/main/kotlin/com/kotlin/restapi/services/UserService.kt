package com.kotlin.restapi.services

import com.kotlin.restapi.entities.UserDetails
import com.kotlin.restapi.exceptions.DataNotFound
import com.kotlin.restapi.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp
import java.util.*

@Service
class UserService {
    @Autowired
    lateinit var repository: UserRepository

    @Transactional
    public fun saveUser(userDetails: UserDetails):UserDetails {
        userDetails.createdDateTime = Timestamp(System.currentTimeMillis())
        userDetails.modifiedDateTime = Timestamp(System.currentTimeMillis())
        return repository.save(userDetails)
    }

    public fun getUserById(userId: Int): UserDetails {
        var userDetails: Optional<UserDetails> = repository.findById(userId)

        if(userDetails.isEmpty) {
            throw DataNotFound("No User is found with id: $userId")
        }
        return userDetails.get()
    }

    fun getAllUsers(): List<UserDetails>? {
        return repository.findAll()
    }

    fun updateUserDetails(userDetails: UserDetails): UserDetails? {
        var userDetailsDB: Optional<UserDetails> = userDetails.userId?.let { repository.findById(it) } as Optional<UserDetails>

        if (userDetailsDB.isPresent) {
            var updatedUser: UserDetails = userDetailsDB.get()
            updatedUser.userName = userDetails.userName
            updatedUser.userDob = userDetails.userDob
            updatedUser.userPhoneNumber = userDetails.userPhoneNumber
            updatedUser.userEmailId = userDetails.userEmailId
            updatedUser.userPanNumber = userDetails.userPanNumber
            updatedUser.userAadhaarNumber = userDetails.userAadhaarNumber
            updatedUser.modifiedDateTime = Timestamp(System.currentTimeMillis())
            repository.save(updatedUser)
            return updatedUser
        } else {
            throw DataNotFound("User not found")
        }

    }

    fun deleteUserDetails(userId: Int) {
        var userDetails: Optional<UserDetails> =  repository.findById(userId)

        if(userDetails.isPresent) {
            repository.delete(userDetails.get())
        } else {
            throw DataNotFound("No User is found with id: $userId")
        }
    }
}