package com.example.myapplication.Kotlin

fun main() {

    val testAccess: TestAccess = TestAccess("테스트")
    println(testAccess)

    val reward: Reward = Reward()
    reward.rewardAmount = 2000
    println(reward.rewardAmount)
}

class Reward() {
    var rewardAmount: Int = 1000
}

class TestAccess {
    private var name = "홍길동"

    constructor(name: String) {
        this.name = name
    }


}