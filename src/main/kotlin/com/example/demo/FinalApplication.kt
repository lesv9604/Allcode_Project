package com.example.demo


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import com.google.gson.Gson
import com.example.demo.assets.*
import com.example.demo.model.Inventory
import java.io.IOException
import java.nio.channels.FileChannel.open
import java.nio.channels.Selector.open

@SpringBootApplication
class FinalApplication

fun main(args: Array<String>) {

	//Valores declarados de un usuario para hacerlo un Json
	/*val user = User()
	user.name ="User_1"
	user.identity=1
	user.status=false*/

	val gson = Gson()
	val json = loadData("User.json")
	val user =gson.fromJson(json, Inventory::javaClass)
	/*//de Un Json se saca el String
	val json:String = gson.toJson(user)*/

	/*val json:String = "{\"name\": \"usuario_1\",\"identity\":1,\"status\":true}"
	//Transformar Json a objetos
	val user :User = gson.fromJson(json, User::class.java)
	println("resultado: "+ user)*/

	fun loadData(infile:String):String{
		var tContents = ""
		try{
			val stream = com.example.demo.assets.open(infile)

			val size = stream.avaible()
			val buffer =ByteArray(size)
			stream.read(buffer)
			stream.close()
			tContents = String(buffer)
		}catch (e:IOException){
			//handle exceptionhere
		}
		return tContents
	}



	/*val rec = ActiveConfig()
	rec.sendAndReceiver()
	println(rec.message)
	println()*/
	runApplication<FinalApplication>(*args)


}
