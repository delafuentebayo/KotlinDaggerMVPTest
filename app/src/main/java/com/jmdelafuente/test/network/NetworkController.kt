package com.jmdelafuente.test.network

import com.google.gson.Gson
import com.jmdelafuente.test.exceptions.NetworkException
import com.jmdelafuente.test.interfaces.INetwork
import com.jmdelafuente.test.models.AccountsResponse

class NetworkController: INetwork {
    @Throws(NetworkException::class)
    override fun getAllAccounts(): ArrayList<AccountsResponse.Account> {
        val dummyTest = "{\n" +
                "   \"accounts\":[\n" +
                "      {\n" +
                "         \"accountBalanceInCents\":985000,\n" +
                "         \"accountCurrency\":\"EUR\",\n" +
                "         \"accountId\":748757694,\n" +
                "         \"accountName\":\"Hr P L G N StellingTD\",\n" +
                "         \"accountNumber\":748757694,\n" +
                "         \"accountType\":\"PAYMENT\",\n" +
                "         \"alias\":\"\",\n" +
                "         \"isVisible\":true,\n" +
                "         \"iban\":\"NL23INGB0748757694\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"accountBalanceInCents\":1000000,\n" +
                "         \"accountCurrency\":\"EUR\",\n" +
                "         \"accountId\":700000027559,\n" +
                "         \"accountName\":\",\",\n" +
                "         \"accountNumber\":748757732,\n" +
                "         \"accountType\":\"PAYMENT\",\n" +
                "         \"alias\":\"\",\n" +
                "         \"isVisible\":false,\n" +
                "         \"iban\":\"NL88INGB0748757732\"\n" +
                "      },\n" +
                "      {\n" +
                "         \"accountBalanceInCents\":15000,\n" +
                "         \"accountCurrency\":\"EUR\",\n" +
                "         \"accountId\":700000027559,\n" +
                "         \"accountName\":\"\",\n" +
                "         \"accountNumber\":\"H 177-27066\",\n" +
                "         \"accountType\":\"SAVING\",\n" +
                "         \"alias\":\"G\\\\UfffdLSAVINGSdiacrits\",\n" +
                "         \"iban\":\"\",\n" +
                "         \"isVisible\":true,\n" +
                "         \"linkedAccountId\":748757694,\n" +
                "         \"productName\":\"Oranje Spaarrekening\",\n" +
                "         \"productType\":1000,\n" +
                "         \"savingsTargetReached\":1,\n" +
                "         \"targetAmountInCents\":2000\n" +
                "      }\n" +
                "   ],\n" +
                "   \"failedAccountTypes\":\"CREDITCARDS\",\n" +
                "   \"returnCode\":\"OK\"\n" +
                "}"
        val gson = Gson()
        var accountResponse: AccountsResponse.AccountResponse? =
            gson.fromJson(dummyTest, AccountsResponse.AccountResponse::class.java) ?: throw NetworkException(400, "NOT FOUND")

        if (accountResponse?.returnCode != "OK") {
            throw NetworkException(500, "SERVER ERROR")
        }
        return accountResponse.accounts
    }
}