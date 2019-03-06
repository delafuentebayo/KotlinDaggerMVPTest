package com.jmdelafuente.test.Logic
import com.jmdelafuente.test.interfaces.INetwork
import com.jmdelafuente.test.models.AccountsResponse
import kotlin.collections.ArrayList

class NetworkMock : INetwork {
    var calledAccounts: ArrayList<AccountsResponse.Account> = ArrayList()

    override fun getAllAccounts(): ArrayList<AccountsResponse.Account> {
        val account1 = AccountsResponse.Account(1234, "EUR", 1, "Account 1",
            "Account Number 1", "Account type 1", "alias 1", false, "iban 1", null, null,
            null, null, null)
        val account2 = AccountsResponse.Account(4321, "EUR", 2, "Account 2",
            "Account Number 2", "Account type 2", "alias 2", true, "iban 2",
            12, "product name",
            2, 3, 40000)
        calledAccounts.add(account1)
        calledAccounts.add(account2)
        return calledAccounts
    }




}