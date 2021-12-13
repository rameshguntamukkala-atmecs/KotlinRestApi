package com.kotlin.restapi.services

import com.kotlin.restapi.entities.UserDetails
import com.kotlin.restapi.repositories.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.springframework.data.jpa.repository.JpaRepository
import java.sql.Date

@RunWith(MockitoJUnitRunner::class)
internal class UserServiceTest {

    @Mock
    var userRepository: UserRepository

    @InjectMocks
    private lateinit var userService: UserService



    private fun mockUserDetails (): UserDetails {
        val dob = Date(System.currentTimeMillis())
        return UserDetails(1,
            "Ramesh",
            dob,
            88988989,
            "ramesh@gmail.com",
            "AASF123ASD",
            123456789012345,
            null,
            null)
    }

    private fun<T> anyObject() :T {
        return any<T>()
    }

    @Test
    fun test_saveUser_postiveCase () {

        var mockUserDetails = mockUserDetails();
        `when`(userRepository.save(anyObject<UserDetails>())).thenReturn(mockUserDetails);
        var actualUserDetails = userService.saveUser(mockUserDetails);
        assertEquals(mockUserDetails.userId, actualUserDetails.userId);

    }
    
}