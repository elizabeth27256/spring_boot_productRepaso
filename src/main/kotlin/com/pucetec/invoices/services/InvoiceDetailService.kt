package com.pucetec.invoices.services

import com.pucetec.invoices.models.entities.InvoiceDetail
import com.pucetec.invoices.repositories.InvoiceDetailRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class InvoiceDetailService(
    private val invoiceDetailRepository: InvoiceDetailRepository,
){
    fun findAll(): List<InvoiceDetail>{
        return invoiceDetailRepository.findAll()
    }

    fun findById(id: Long): InvoiceDetail?{
        return invoiceDetailRepository.findByIdOrNull(id)
    }
    fun save(product: InvoiceDetail): InvoiceDetail{
        return invoiceDetailRepository.save(product)
    }
}

