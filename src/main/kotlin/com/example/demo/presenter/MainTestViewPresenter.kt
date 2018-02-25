package com.example.demo.presenter

import com.example.demo.view.MainTestView
import org.springframework.stereotype.Component
import tornadofx.*

@Component
class MainTestViewPresenter {

    private val mainTestView = find(MainTestView::class)

    fun textName(): String = "Juan Junior"

    fun callPrint() {
        println("call print My Bean: ${1 + 2}")
        mainTestView.printOtherMessage()
    }

    fun loadData(){
        FX.log.info("Load data ....")
    }

}
