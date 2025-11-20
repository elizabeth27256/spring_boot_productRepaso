package com.pucetec.invoices.services

import com.pucetec.invoices.models.entities.Invoice
import com.pucetec.invoices.models.entities.Product
import com.pucetec.invoices.repositories.InvoiceRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class InvoiceService (
    private val invoiceRepository: InvoiceRepository,
){
    fun findAll(): List<Invoice>{
        return invoiceRepository.findAll()
    }

    fun findById(id: Long): Invoice?{
        return invoiceRepository.findByIdOrNull(id)
    }
    fun save(product: Invoice): Invoice{
        return invoiceRepository.save(product)
    }
}