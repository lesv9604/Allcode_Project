package com.example.demo.config

import com.example.demo.model.Customer
import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session


class ActiveConfig {
    var usuario = Customer("","")
    val connFactory = ActiveMQConnectionFactory()
    val conn = connFactory.createConnection()!!
    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE)!!
    private val dest = sess.createQueue("Nueva_cola")
    val prod = sess.createProducer(dest)!!
    val cons = sess.createConsumer(dest)!!
    val msg = sess.createTextMessage(usuario.toString())
    fun sendAndReceiver(){
        prod.send(msg)
        conn.start()
        val msgs = cons.receive()
        println(msgs)
        conn.close()
    }
}