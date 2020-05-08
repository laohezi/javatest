package sample

import java.text.SimpleDateFormat
import java.util.*

fun  log(msg:Any){

    println("${Thread.currentThread().name}--${SimpleDateFormat("HH:mm:ss.SSS").format(Date())} --${msg}")

}