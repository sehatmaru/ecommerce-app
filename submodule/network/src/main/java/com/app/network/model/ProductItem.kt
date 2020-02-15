package com.app.network.model

class ProductItem {
    var image: Int
    var brand: String = ""
    var name: String = ""
    var price: Int

    constructor(image: Int, brand: String, name: String, price: Int){
        this.image = image
        this.brand = brand
        this.name = name
        this.price = price
    }
}