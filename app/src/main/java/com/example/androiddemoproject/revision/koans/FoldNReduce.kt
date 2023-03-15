package com.example.androiddemoproject.revision.koans

// Return the set of products that were ordered by all customers

fun Shop.getProductsOrderedByAll(): Set<Product> {
    return customers
        .map { it.getOrderedProducts() }
        .reduce { allProducts, currentProduct ->
            allProducts intersect currentProduct
        }
}

private fun Customer.getOrderedProducts(): Set<Product> =
    orders.flatMap { it.products }.toSet()
