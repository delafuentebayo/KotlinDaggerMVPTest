package com.jmdelafuente.test.ui

import com.jmdelafuente.test.exceptions.NetworkException
import com.jmdelafuente.test.interfaces.INetwork
import javax.inject.Inject

class MainPresenter
@Inject constructor (var networkController: INetwork): MainContract.Presenter
 {
    private lateinit var view: MainContract.View

    override fun attach(view: MainContract.View) {
        this.view = view
    }

    override fun getAccounts(isVisible: Boolean) {
        try {
            if (isVisible){
                view.paintAccounts(ArrayList(networkController.getAllAccounts().filter { it.isVisible }))

            } else {
                view.paintAccounts(ArrayList(networkController.getAllAccounts()))

            }
        } catch (ex: NetworkException) {
            when (ex.code) {
                400-> view.showNetworkError()
                500-> view.showServerError()
            }
        }

    }

}