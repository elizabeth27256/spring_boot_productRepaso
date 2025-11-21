package com.pucetec.invoices.exceptions

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import jakarta.persistence.EntityNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    data class ErrorResponse(val status: Int, val message: String)

    // manejo de 404
    @ExceptionHandler(EntityNotFoundException::class, EntityNotFound::class)
    fun handleNotFound(ex: Exception): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.message ?: "Recurso no encontrado")
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error)
    }

    // manejo de 400
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(ex: IllegalArgumentException): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.message ?: "Solicitud inválida")
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error)
    }

    // manejo 500 errores inesperados
    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception): ResponseEntity<ErrorResponse> {
        val error = ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.message ?: "Error interno")
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error)
    }
}
