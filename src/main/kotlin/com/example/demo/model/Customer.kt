package com.example.demo.model


import javax.persistence.*

@Entity

class Customer(
    val firstName: String,
    val lastName: String,
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = -1) {

   private constructor() : this("", "")
}

