package com.example.evento.models

class Upload {
    var name:String=""
    var location:String=""
    var description:String=""
    var price:String=""
    var imageUrl:String=""
    var id:String=""

    constructor(name:String,location: String,description: String,price:String,imageUrl:String,id:String){

        this.name=name
        this.location=location
        this.description=description
        this.price=price
        this.imageUrl=imageUrl
        this.id=id

    }
    constructor()
}