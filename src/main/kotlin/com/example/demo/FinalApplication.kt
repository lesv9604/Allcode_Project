package com.example.demo

import com.example.demo.config.ActiveConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FinalApplication

fun main(args: Array<String>) {

	val rec = ActiveConfig()
	rec.sendAndReceiver()
	println(rec.message)
	runApplication<FinalApplication>(*args)


}
