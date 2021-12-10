package com.kotlin.restapi.repositories

import com.kotlin.restapi.entities.UserDetails
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserDetails,Int> {
    @Query (value = "SELECT * FROM TB_USER_DETAILS AND USER_NAME= :username", nativeQuery = true)
    fun findByName(@Param("username") name: String): UserDetails
}