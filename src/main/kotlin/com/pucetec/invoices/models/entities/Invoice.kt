package com.pucetec.invoices.models.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.Table


@Entity
@Table (name = "invoices")
data class Invoice(

    @Column(name= "client_id")
    val clientId: String = "",
    @Column(name= "client_name")
    val clientName: String = "",
    @Column(name= "total_before_taxes")
    val totalBeforeTaxes: Double = 0.0,
    val taxes: Double = 0.0,
    @Column(name= "total_after_taxes")
    val totalAfterTaxes: Double = 0.0,

    //1 Invoice puede tener muchos invoice details - en este apartado se coloca
    //La relacion de la tabla de uno a muchos

    @OneToMany(mappedBy = "invoice")
    val invoiceDetail: List<InvoiceDetail> = listOf()

): BaseEntity()
