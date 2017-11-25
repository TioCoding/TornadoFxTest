package com.example.demo.app

import com.example.demo.view.MainView
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import tornadofx.*
import kotlin.reflect.KClass

@SpringBootApplication
class MyApp: App(MainView::class){

    init {
        val applicationContext = SpringApplication.run(MainView::class.java)
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = applicationContext.getBean(type.java)
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = applicationContext.getBean(type.java, name)
        }
    }

    @Bean
    fun testBean() : String = "Esto es un test" // Inject in presenter

}