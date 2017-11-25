package com.example.demo.presenter

import tornadofx.*

class MainViewPresenter : Controller(){

    val testBean: String by di("testBean")

    fun printBeanSpring(){
        log.info(testBean.length.toString())
    }

}
