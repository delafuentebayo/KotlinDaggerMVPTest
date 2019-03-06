package com.jmdelafuente.test.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jmdelafuente.test.R
import com.jmdelafuente.test.extensions.fromCentsToCurrency
import com.jmdelafuente.test.models.AccountsResponse
import kotlinx.android.synthetic.main.item_main_adapter.view.*


class MainAccountsAdapter(val items : ArrayList<AccountsResponse.Account>, val context: Context) :
        RecyclerView.Adapter<MainAccountsAdapter.MainAccountsViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MainAccountsViewHolder {
        return MainAccountsViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main_adapter, p0, false))
    }

    override fun onBindViewHolder(holder: MainAccountsViewHolder, position: Int) {

        holder.nameTv?.text = context.getString(R.string.account_name, items[position].accountName)
        holder.numberTv?.text = context.getString(R.string.account_number, items[position].accountNumber)
        holder.idTv?.text =context.getString(R.string.account_id, items[position].accountId.toString())
        holder.ibanTv?.text = context.getString(R.string.account_iban, items[position].iban)
        holder.typeTv?.text = context.getString(R.string.account_type, items[position].accountType)
        holder.aliasTv?.text = context.getString(R.string.account_alias, items[position].alias)
        holder.balanceTv?.text = context.getString(R.string.account_balance,
            items[position].accountBalanceInCents.fromCentsToCurrency(), items[position].accountCurrency)
        if (items[position].linkedAccountId != null) {
            holder.linkedAccountTv.visibility = View.VISIBLE
            holder.linkedAccountTv.text = context.getString(R.string.linked_account, items[position].linkedAccountId.toString())
        }
        if (items[position].productName != null) {
            holder.productNameTv.visibility = View.VISIBLE
            holder.productNameTv.text = context.getString(R.string.product_name, items[position].productName)
        }
        if (items[position].productType != null) {
            holder.productTypeTv.visibility = View.VISIBLE
            holder.productTypeTv.text = context.getString(R.string.product_type, items[position].productType.toString())
        }
        if (items[position].savingsTargetReached != null) {
            holder.savingTargetTv.visibility = View.VISIBLE
            holder.savingTargetTv.text = context.getString(R.string.saving_target, items[position].savingsTargetReached.toString())
        }
        if (items[position].targetAmountInCents != null) {
            holder.targetTv.visibility = View.VISIBLE
            holder.targetTv.text =context.getString(R.string.target_amount, items[position].targetAmountInCents!!.fromCentsToCurrency(),
                items[position].accountCurrency)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MainAccountsViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        val nameTv = view.item_main_account_name
        val numberTv = view.item_main_account_number
        val idTv = view.item_main_account_id
        val ibanTv = view.item_main_account_iban
        val typeTv = view.item_main_account_type
        val aliasTv = view.item_main_account_alias
        val balanceTv = view.item_main_account_balance
        val linkedAccountTv = view.item_main_account_linkedaccount
        val productNameTv = view.item_main_account_productname
        val productTypeTv = view.item_main_account_producttype
        val savingTargetTv = view.item_main_account_savingtarget
        val targetTv = view.item_main_account_targetamount

    }

}

