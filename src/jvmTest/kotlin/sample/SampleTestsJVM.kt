package sample

import java.lang.Exception
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertTrue

fun main() {
    val executor = Executors.newSingleThreadExecutor()



    val future = executor.submit {

        for(i in 0 until 5){

            val innerfutre = executor.submit{
                while (Thread.interrupted().not()){
                    Thread.sleep(100)
                    log("我是子任务")
                }
            }
            try {
                innerfutre.get(2000,TimeUnit.MILLISECONDS)

            }catch (e:Exception){
                innerfutre.cancel(true)
            }

            log("我是外部future")

        }
    }

    try {
        future.get(5000,TimeUnit.MILLISECONDS)
    }catch (e:Exception){
        future.cancel(true)
    }

    log("完成了,byebye")





}