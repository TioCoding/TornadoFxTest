package com.example.demo.view

import com.example.demo.bean.HelloBean
import com.example.demo.presenter.MainViewPresenter
import tornadofx.*

class MainView : View("Hello TornadoFX") {

    val mainViewPresenter: MainViewPresenter by inject()
    val helloBean: HelloBean by di()

    override val root = hbox {
        label(title)
        helloBean.printTestHello() // First test
        mainViewPresenter.printBeanSpring() // Second test
    }

}