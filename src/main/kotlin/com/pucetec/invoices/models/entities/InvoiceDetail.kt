package com.pucetec.invoices.models.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table


@Entity
@Table (name = "invoice_details")
data class InvoiceDetail (

    @Column(name = "total_price")
    val totalPrice: Double = 0.0,

    // 1 invoice no puede tener muchos productos
    //Relacion de muchos a uno
    //Usamos Join para hacer la union de tablas

    @ManyToOne
    @JoinColumn(name = "product_id")
    val product: Product? = null,

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    val invoice: Invoice? = null,

): BaseEntity()