package com.example.myapplication

class doctor {
    var ssn=0
    var name=""
    var clinic=""
    var mobno=""
    var exp=0
    var spec=""
    var uid=""
    constructor(uid:String,ssn:Int,name:String,clinic:String,mobno:String,exp:Int,spec:String){
        this.ssn=ssn
        this.uid=uid
        this.name=name
        this.clinic=clinic
        this.mobno= mobno
        this.exp=exp
        this.spec=spec
    }
}