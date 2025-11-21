package com.pucetec.invoices.services

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import com.pucetec.invoices.models.entities.Product
import com.pucetec.invoices.repositories.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.slf4j.LoggerFactory

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    private val logger = LoggerFactory.getLogger(ProductService::class.java)

    fun findAll(): List<Product> {
        return productRepository.findAll()
    }

    fun findById(id: Long): Product {
        val product = productRepository.findByIdOrNull(id)

        if (product == null) {
            logger.warn("Product with ID $id not found")
            throw EntityNotFound("Product with ID $id not found")
        }

        logger.info("Product with ID $id found")
        return product
    }

    fun save(product: Product): Product {
        return productRepository.save(product)
    }
}
