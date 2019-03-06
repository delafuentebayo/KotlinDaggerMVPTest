package com.jmdelafuente.test.views

import com.jmdelafuente.test.models.AccountsResponse
import com.jmdelafuente.test.ui.MainContract

class MainViewMock: MainContract.View {
    var calledAccounts: ArrayList<AccountsResponse.Account> = ArrayList()
    override fun paintAccounts(accountList: ArrayList<AccountsResponse.Account>) {
        calledAccounts = accountList
    }

    override fun showNetworkError() {
    }

    override fun showServerError() {
    }

}