package com.pucetec.invoices.services

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import com.pucetec.invoices.models.entities.InvoiceDetail
import com.pucetec.invoices.models.entities.Product
import com.pucetec.invoices.models.entities.Invoice
import com.pucetec.invoices.repositories.InvoiceDetailRepository
import com.pucetec.invoices.repositories.ProductRepository
import com.pucetec.invoices.repositories.InvoiceRepository
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class InvoiceDetailService(
    private val invoiceDetailRepository: InvoiceDetailRepository,
    private val productRepository: ProductRepository,
    private val invoiceRepository: InvoiceRepository
) {

    private val logger = LoggerFactory.getLogger(InvoiceDetailService::class.java)

    fun findAll(): List<InvoiceDetail> {
        return invoiceDetailRepository.findAll()
    }

    fun findById(id: Long): InvoiceDetail {
        logger.info("Searching InvoiceDetail with ID $id")
        return invoiceDetailRepository.findById(id).orElseThrow {
            logger.warn("InvoiceDetail with ID $id not found")
            EntityNotFound("InvoiceDetail with ID $id not found")
        }
    }

    fun save(detail: InvoiceDetail): InvoiceDetail {
        logger.info("Validating InvoiceDetail before saving")

        // validamos que el producto exista
        val product: Product = detail.product?.id?.let {
            productRepository.findById(it).orElseThrow {
                EntityNotFound("Product with ID $it not found")
            }
        } ?: throw IllegalArgumentException("El producto es obligatorio")

        // validamos que la factura exista
        val invoice: Invoice = detail.invoice?.id?.let {
            invoiceRepository.findById(it).orElseThrow {
                EntityNotFound("Invoice with ID $it not found")
            }
        } ?: throw IllegalArgumentException("La factura es obligatoria")

        // guardamos usando las referencias válidas
        val detailToSave = detail.copy(product = product, invoice = invoice)
        logger.info("Saving InvoiceDetail with product ${product.id} and invoice ${invoice.id}")
        return invoiceDetailRepository.save(detailToSave)
    }
}

