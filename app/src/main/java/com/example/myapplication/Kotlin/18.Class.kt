package com.example.myapplication.Kotlin

fun main() {
    //인스턴스화

    val bigCar: Car = Car("V8 engine", "Big")
    val superCar: SuperCar = SuperCar("Good Engine", "Big", "white")

    var number: Int = 10
    var number1 = 20

    var bigCar2: SuperCar2 = SuperCar2("v8", "Big")
    var bigCar3: SuperCar2 = SuperCar2("v8", "Big","white")

    val runableCar: RunableCar = RunableCar("simple engine","small")
    runableCar.ride()
    runableCar.drive()
    runableCar.navi("서울")

    val runableCar2: RunableCar2 = RunableCar2("Simple Engine", "Small")
    runableCar2.ride()
    runableCar2.drive()
    runableCar2.navi("경기도")


}

class Car(var engine: String, var body: String) {

}

class Car1(engine: String, body: String) {
    var door: String = ""

    constructor(engine: String, body: String, door: String) : this(engine, body) {
        this.door = door
    }

}

class SuperCar {
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class SuperCar2 {
    var engine = ""
    var body = ""
    var door = ""

    //오버로딩
    constructor(engine: String, body: String) {
        this.engine = engine
        this.body = body
    }

    constructor(engine: String, body: String, door: String) {
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String){
    fun ride(){
        println("탑승")
    }
    fun drive(){
        println("주행")
    }
    fun navi(destination:String){
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}

class RunableCar2{
    var engine = ""
    var body = ""

    init {
        //초기화
        println("RunableCar2가 실행됨")
    }

    constructor(engine: String, body: String){
        this.engine = engine
        this.body = body
    }

    fun ride(){
        println("탑승")
    }
    fun drive(){
        println("주행")
    }
    fun navi(destination:String){
        println("$destination 으로 목적지가 설정되었습니다.")
    }
}






