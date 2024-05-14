package com.example.evento.models

class User {

    val name: String = ""
    var email: String = ""
    var pass: String = ""
    var userid:String = ""
    var confirmpass:String = ""


    constructor(email: Any, pass: String, userid: String, confirmpass: String){
        this.email = email.toString()
        this.pass = pass.toString()
        this.userid = userid
        this.confirmpass = confirmpass
    }
    constructor()


}
