package com.example.demo.controller

import com.example.demo.model.Customer
import com.example.demo.repo.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*

@RestController
class WebController {

    @Autowired
    lateinit var repository: CustomerRepository

    @RequestMapping("/save")
    fun save(): String {
        repository.save(Customer("nombre_1","apellido"))
        repository.save(Customer("nombre_2", "apellido_2"))

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






    /*@GetMapping("Find")
    fun getAllCustomer(): MutableIterable<Customer> {
        return repository.findAll()
    }*/
   /*
    @PostMapping("/save")
    fun save(): String{
        repository.save(Customer("persona_2", "Apellido_2"))

        return "Done"

    }
    @RequestMapping("/findall")
    fun findAll() = repository.findAll()

    @RequestMapping("/findbyId/{id}")
    fun findById(@PathVariable id: Long)
            = repository.findById(id)

    @RequestMapping("findbylastname/{lastname}")
    fun findByLastName(@PathVariable lastName: String)
            =repository.findByLastName(lastName)*/
