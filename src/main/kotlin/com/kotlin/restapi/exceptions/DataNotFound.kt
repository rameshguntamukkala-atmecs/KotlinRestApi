package com.kotlin.restapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Data not found")
class DataNotFound(message: String) : Exception(message) {

}
