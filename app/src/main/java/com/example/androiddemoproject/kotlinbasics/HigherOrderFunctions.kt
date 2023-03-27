package com.example.androiddemoproject.kotlinbasics

data class Shop(val name: String, val customers: List<Customer>)

data class Customer(val name: String, val city: City, val orders: List<Order>) {
    override fun toString() = "$name from ${city.name}"
}

data class Order(val products: List<Product>, val isDelivered: Boolean)

data class Product(val name: String, val price: Double) {
    override fun toString() = "'$name' for $price"
}

data class City(val name: String) {
    override fun toString() = name
}

fun Shop.getOrderedProducts(): Set<Product> {
    val orders = customers.flatMap { it.orders }
    val products = orders.flatMap { it.products }
    return products.toSet()
}

// Return a customer who has placed the maximum amount of orders
fun Shop.getCustomerWithMaxOrders(): Customer? =
    customers.maxBy { it.orders.size }

// Return the most expensive product that has been ordered by the given customer
fun getMostExpensiveProductBy(customer: Customer): Product? =
    customer.orders.flatMap { it.products }.maxByOrNull { it.price }

fun main() {
    class SomeClass {
        var counter = 0 // the initializer assigns the backing field directly
            set(value) {
                if (value >= 0)
                    field = value
                // counter = value // ERROR StackOverflow: Using actual name 'counter' would make setter recursive
            }
    }

    val sc = SomeClass()
    sc.counter = 10
}