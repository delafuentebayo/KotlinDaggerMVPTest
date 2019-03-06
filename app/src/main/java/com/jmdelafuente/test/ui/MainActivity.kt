package com.jmdelafuente.test.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jmdelafuente.test.R
import com.jmdelafuente.test.models.AccountsResponse
import javax.inject.Inject
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.beclocked.paco.di.module.ActivityModule
import com.jmdelafuente.test.TestApp
import com.jmdelafuente.test.adapters.MainAccountsAdapter
import com.jmdelafuente.test.injection.components.DaggerActivityComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerActivityComponent.builder().appComponent((application as TestApp).component()).activityModule(ActivityModule(this)).build().inject(this)
        presenter.attach(this)
        val llm = LinearLayoutManager(this)
        main_rv.layoutManager = llm
        main_sw.setOnCheckedChangeListener { _, isChecked ->
            presenter.getAccounts(isChecked)
        }
        presenter.getAccounts(false)
    }

    override fun paintAccounts(accountList: ArrayList<AccountsResponse.Account>) {
        main_rv.adapter = MainAccountsAdapter(accountList, this)
    }

    override fun showNetworkError() {
        Toast.makeText(this, getString(R.string.network_error), Toast.LENGTH_LONG).show()
    }

    override fun showServerError() {
        Toast.makeText(this, getString(R.string.server_error), Toast.LENGTH_LONG).show()
    }
}
