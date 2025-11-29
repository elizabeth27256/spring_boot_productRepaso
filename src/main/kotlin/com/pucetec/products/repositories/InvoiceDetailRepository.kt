package com.pucetec.products.repositories

import com.pucetec.products.models.entities.InvoiceDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceDetailRepository: JpaRepository<InvoiceDetail, Long>