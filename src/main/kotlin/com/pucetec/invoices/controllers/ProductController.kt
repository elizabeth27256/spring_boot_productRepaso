package com.pucetec.invoices.controllers

import com.pucetec.invoices.models.entities.Product
import com.pucetec.invoices.services.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["invoices/product"])
class ProductController(
    private val productService: ProductService,
){
    @GetMapping
    fun findAll(): List<Product>{
        return productService.findAll()
    }

    @GetMapping
    fun findById(@PathVariable("id") id: Long): Product? {
        return productService.findById(id)
    }
    @PostMapping
    fun save(@RequestBody product: Product): Product{
        return productService.save(product)
    }
}