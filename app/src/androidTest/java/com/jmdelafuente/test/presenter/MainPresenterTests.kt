package com.jmdelafuente.test.presenter

import android.support.test.runner.AndroidJUnit4
import com.jmdelafuente.test.Logic.NetworkMock
import com.jmdelafuente.test.ui.MainPresenter
import com.jmdelafuente.test.views.MainViewMock
import org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainPresenterTests {

    @Test
    fun getAllAccounts() {
        val network = NetworkMock()
        val view = MainViewMock()
        val presenter = MainPresenter(network)
        presenter.attach(view)
        presenter.getAccounts(false)
        assertEquals(network.calledAccounts.size, 2)
        assertEquals(view.calledAccounts.size, 2)
    }

    @Test
    fun getVisibleAccounts() {
        val network = NetworkMock()
        val view = MainViewMock()
        val presenter = MainPresenter(network)
        presenter.attach(view)
        presenter.getAccounts(true)
        assertEquals(network.calledAccounts.size, 2)
        assertEquals(view.calledAccounts.size, 1)
    }

}