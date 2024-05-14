package com.example.evento.models

class Events {

    var name: String = ""
    var location: String = ""
    var description: String = ""
    var price: String = ""
    var id: String = ""


    constructor(name: String, location: String, description: String, price: String, id: String){
        this.name=name
        this.location=location
        this.description=description
        this.price=price
        this.id=id
    }
    constructor()

}