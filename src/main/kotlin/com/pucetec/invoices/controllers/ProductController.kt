package com.pucetec.invoices.controllers

import com.pucetec.invoices.exceptions.exceptions.EntityNotFound
import com.pucetec.invoices.models.entities.Product
import com.pucetec.invoices.services.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("invoices/product")
class ProductController(
    private val productService: ProductService,
) {

    @GetMapping
    fun findAll(): List<Product> {
        return productService.findAll()
    }

    @GetMapping("/find")
    fun findById(@RequestParam id: Long): Product {

        if (id <= 0) {
            throw IllegalArgumentException("El ID debe ser un número positivo.")
        }

        return productService.findById(id)
            ?: throw EntityNotFound("Producto con ID $id no encontrado.")
    }

    @PostMapping
    fun save(@RequestBody product: Product): Product {

        if (product.name.isNullOrBlank()) {
            throw IllegalArgumentException("El nombre del producto es obligatorio.")
        }

        if (product.price < 0) {
            throw IllegalArgumentException("El precio no puede ser negativo.")
        }

        return productService.save(product)
    }
}
