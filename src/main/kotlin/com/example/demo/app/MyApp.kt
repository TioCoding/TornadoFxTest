package com.example.demo.app

import com.example.demo.view.MainTestView
import javafx.stage.Stage
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import tornadofx.*
import kotlin.reflect.KClass

@SpringBootApplication
@ComponentScan("com.example.demo")
class MyApp: App(MainTestView::class){

    override fun start(stage: Stage) {
        val applicationContext = SpringApplication.run(MyApp::class.java, *parameters.raw.toTypedArray())
        FX.dicontainer = object : DIContainer {
            override fun <T : Any> getInstance(type: KClass<T>): T = applicationContext.getBean(type.java)
            override fun <T : Any> getInstance(type: KClass<T>, name: String): T = applicationContext.getBean(type.java, name)
        }
        super.start(stage)
    }

    @Bean
    fun testBean() : String = "Esto es un test" // Inject in presenter

}