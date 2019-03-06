package com.jmdelafuente.test.interfaces

import com.jmdelafuente.test.models.AccountsResponse

interface INetwork {
    fun getAllAccounts(): ArrayList<AccountsResponse.Account>
}