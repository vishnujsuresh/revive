package com.example.myapplication

class doctor {
    var dr_ssn=0
    var dr_name=""
    var dr_addr=""
    var dr_mobno=""
    var dr_exp=0
    var dr_spec=""
    var dr_uid=""
    constructor(uid:String,dr_ssn:Int,dr_name:String,dr_addr:String,dr_mobno:String,dr_exp:Int,dr_spec:String){
        this.dr_ssn=dr_ssn
        this.dr_uid=uid
        this.dr_name=dr_name
        this.dr_addr=dr_addr
        this.dr_mobno= dr_mobno
        this.dr_exp=dr_exp
        this.dr_spec=dr_spec
    }
}