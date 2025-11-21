package com.pucetec.invoices.controllers

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import com.pucetec.invoices.models.entities.Invoice
import com.pucetec.invoices.services.InvoiceService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("invoices")
class InvoiceController(
    private val invoiceService: InvoiceService
) {

    @GetMapping
    fun findAll(): List<Invoice> {
        return invoiceService.findAll()
    }

    @GetMapping("/find")
    fun findById(@RequestParam id: Long): Invoice {

        // 400
        if (id <= 0) {
            throw IllegalArgumentException("El ID debe ser un número positivo.")
        }

        return invoiceService.findById(id)
    }

    @PostMapping
    fun save(@RequestBody invoice: Invoice): Invoice {

        // 400
        if (invoice.clientName.isBlank()) {
            throw IllegalArgumentException("El nombre del cliente es obligatorio.")
        }

        return invoiceService.save(invoice)
    }
}
