package com.jmdelafuente.test.ui

import com.jmdelafuente.test.models.AccountsResponse

class MainContract {
    interface View  {
        fun paintAccounts(accountList: ArrayList<AccountsResponse.Account>)
        fun showNetworkError()
        fun showServerError()
    }

    interface Presenter {
        fun attach(view: View)
        fun getAccounts(isVisible: Boolean)

    }
}