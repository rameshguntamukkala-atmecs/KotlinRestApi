package com.kotlin.restapi.entities

import java.sql.Date
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table (name = "TB_USER_DETAILS")
public data class UserDetails(
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    var userId: Int?,
    @Column (name = "USER_NAME")
    var userName: String?,
    @Column (name = "USER_DOB")
    var userDob: Date?,
    @Column (name = "USER_PHONE_NUMBER")
    var userPhoneNumber: Long?,
    @Column (name = "USER_EMAIL_ID")
    var userEmailId: String?,
    @Column (name = "USER_PAN_NUMBER")
    var userPanNumber: String?,
    @Column (name = "USER_AADHAAR_NUMBER")
    var userAadhaarNumber: Long?,
    @Column (name = "CREATED_DATETIME")
    var createdDateTime: Timestamp?,
    @Column (name = "MODIFIED_DATETIME")
    var modifiedDateTime: Timestamp?
) {
}