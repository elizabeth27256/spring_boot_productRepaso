package com.pucetec.invoices.services

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import com.pucetec.invoices.models.entities.Invoice
import com.pucetec.invoices.repositories.InvoiceRepository
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class InvoiceService(
    private val invoiceRepository: InvoiceRepository,
) {

    private val logger = LoggerFactory.getLogger(InvoiceService::class.java)

    fun findAll(): List<Invoice> {
        return invoiceRepository.findAll()
    }

    fun findById(id: Long): Invoice {

        logger.info("Searching Invoice with ID $id")

        return invoiceRepository.findById(id).orElseThrow {
            logger.warn("Invoice with ID $id not found")
            EntityNotFound("Invoice with ID $id not found")
        }
    }

    fun save(invoice: Invoice): Invoice {
        logger.info("Saving invoice for client ${invoice.clientName}")
        return invoiceRepository.save(invoice)
    }
}
