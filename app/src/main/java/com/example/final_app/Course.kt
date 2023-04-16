package com.example.final_app

data class Course(
    val code: String = "",
    val name: String = "",
    val credits: Int = 0,
    val prerequisites: String = "",
    val description: String = "",
    var id: Long = 0
) {
    constructor() : this("", "", 0, "", "", 0)
}
