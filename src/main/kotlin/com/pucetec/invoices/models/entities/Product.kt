package com.pucetec.invoices.models.entities

import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "products")
data class Product (

    //No ponemos el id, ni created at, ni el update at, porque ya se genera

    val name: String = "",
    val price: Double = 0.0,

    // 1 producto tiene muchos invoice Details

    @OneToMany(mappedBy = "product")
    val invoiceDetails: List<InvoiceDetail> = listOf(),

): BaseEntity()
