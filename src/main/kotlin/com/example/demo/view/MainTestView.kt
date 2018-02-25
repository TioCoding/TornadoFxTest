package com.example.demo.view

import com.example.demo.presenter.MainTestViewPresenter
import javafx.scene.layout.BorderPane
import tornadofx.*

class MainTestView : View("Hello TornadoFX") {

    private val mainTestViewPresenter: MainTestViewPresenter by di()
    override val root = BorderPane()

    init{
        with(root){
            top {
                label(mainTestViewPresenter.textName()) // This produces the error
            }
            center {
                button("Push") {
                    setOnAction {
                        mainTestViewPresenter.callPrint()
                    }
                }
            }
        }
        mainTestViewPresenter.loadData() // This produces the error
    }

    fun printOtherMessage(){
        log.info("this is other message ...")
    }
}