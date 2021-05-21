package com.example.myapplication

class user {
    var ssn=0
    var name=""
    var addr=""
    var mobno=""
    var age=0
    var gender=""
    var uid=""
    constructor(uid:String,ssn:Int,name:String,addr:String,mobno:String,age:Int,gender:String){
        this.ssn=ssn
        this.uid=uid
        this.name=name
        this.addr=addr
        this.mobno= mobno
        this.age=age
        this.gender=gender
    }
}