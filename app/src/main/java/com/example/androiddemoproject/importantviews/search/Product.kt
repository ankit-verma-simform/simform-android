package com.example.androiddemoproject.importantviews.search

data class Product(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
)

fun Product.isAMatchOf(query: String): Boolean {
    return this.toString().contains(query, ignoreCase = true)
}

fun getProducts() = listOf(
    Product(
        id = 1,
        title = "iPhone 9",
        description = "An apple mobile which is nothing like apple",
        thumbnail = "https://i.dummyjson.com/data/products/1/thumbnail.jpg"
    ),
    Product(
        id = 2,
        title = "iPhone X",
        description = "SIM-Free, Model A19211 6.5-inch Super Retina HD display with OLED technology A12 Bionic chip",
        thumbnail = "https://i.dummyjson.com/data/products/2/thumbnail.jpg"
    ),
    Product(
        id = 3,
        title = "Samsung Universe 9",
        description = "Samsung's new variant which goes beyond Galaxy to the Universe",
        thumbnail = "https://i.dummyjson.com/data/products/3/thumbnail.jpg"
    ),
    Product(
        id = 4,
        title = "OPPOF19",
        description = "OPPO F19 is officially announced on April 2021",
        thumbnail = "https://i.dummyjson.com/data/products/4/thumbnail.jpg"
    ),
    Product(
        id = 5,
        title = "Huawei P30",
        description = "Huawei’s re-badged P30 Pro New Edition was officially unveiled yesterday in Germany and now the device has made its way to the UK",
        thumbnail = "https://i.dummyjson.com/data/products/5/thumbnail.jpg"
    ),
    Product(
        id = 6,
        title = "MacBook Pro",
        description = "MacBook Pro 2021 with mini-LED display may launch between September, November",
        thumbnail = "https://i.dummyjson.com/data/products/6/thumbnail.png"
    ),
    Product(
        id = 7,
        title = "Samsung Galaxy Book",
        description = "Samsung Galaxy Book S (2020) Laptop With Intel Lakefield Chip, 8GB of RAM Launched",
        thumbnail = "https://i.dummyjson.com/data/products/7/thumbnail.jpg"
    ),
)
