package com.pucetec.invoices.repositories

import com.pucetec.invoices.models.entities.InvoiceDetail
import org.springframework.data.jpa.repository.JpaRepository

interface InvoiceDetailRepository: JpaRepository<InvoiceDetail, Long>