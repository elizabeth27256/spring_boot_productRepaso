package com.pucetec.invoices.repositories

import com.pucetec.invoices.models.entities.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long>