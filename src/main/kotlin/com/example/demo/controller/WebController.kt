package com.example.demo.controller

import com.example.demo.config.ActiveConfig

import com.example.demo.repo.CustomerRepository
import org.json.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var repository: CustomerRepository
    var rec = ActiveConfig().message


    @RequestMapping("/save")
    fun save(): String {
        repository.save(rec)


        return "Done"
    }

    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("/findbyid/{id}")
    fun findById(@PathVariable id: Long)
            = repository.findByIdOrNull(id)

    @RequestMapping("findbylastname/{lastName}")
    fun findByLastName(@PathVariable lastName: String)
            = repository.findByLastName(lastName)

}
