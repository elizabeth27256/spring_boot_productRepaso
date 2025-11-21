package com.pucetec.invoices.controllers

import com.pucetec.invoices.models.entities.InvoiceDetail
import com.pucetec.invoices.services.InvoiceDetailService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("invoices/detail")
class InvoiceDetailController(
    private val invoiceDetailService: InvoiceDetailService
) {

    @GetMapping
    fun findAll(): List<InvoiceDetail> {
        return invoiceDetailService.findAll()
    }

    @GetMapping("/find")
    fun findById(@RequestParam id: Long): InvoiceDetail {

        // 400
        if (id <= 0) {
            throw IllegalArgumentException("El ID debe ser un número positivo.")
        }

        return invoiceDetailService.findById(id)
    }

    @PostMapping
    fun save(@RequestBody invoiceDetail: InvoiceDetail): InvoiceDetail {

        // 400
        if (invoiceDetail.totalPrice < 0) {
            throw IllegalArgumentException("El totalPrice no puede ser negativo.")
        }

        if (invoiceDetail.product == null) {
            throw IllegalArgumentException("El producto es obligatorio.")
        }

        if (invoiceDetail.invoice == null) {
            throw IllegalArgumentException("La factura es obligatoria.")
        }

        return invoiceDetailService.save(invoiceDetail)
    }
}
