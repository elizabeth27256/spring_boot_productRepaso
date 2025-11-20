package com.pucetec.invoices.repositories

import com.pucetec.invoices.models.entities.Invoice
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceRepository: JpaRepository<Invoice, Long>