package com.jmdelafuente.test.models

class AccountsResponse {
    data class AccountResponse(
        val accounts: ArrayList<Account>,
        val failedAccountTypes: String,
        val returnCode: String
    )
    data class Account(
        val accountBalanceInCents: Long,
        val accountCurrency: String,
        val accountId: Long,
        val accountName: String,
        val accountNumber: String,
        val accountType: String,
        val alias: String,
        val isVisible: Boolean,
        val iban: String,
        val linkedAccountId: Long?,
        val productName: String?,
        val productType: Int?,
        val savingsTargetReached: Int?,
        val targetAmountInCents: Long?
    )

}