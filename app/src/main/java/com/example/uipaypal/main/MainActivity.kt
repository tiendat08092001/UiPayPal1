package com.example.uipaypal.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.adapter.UserAdapter
import com.example.uipaypal.data.user.User
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uipaypal.adapter.HistoryTradeAdapter
import com.example.uipaypal.data.history_trade.HistoryTrade
import com.example.uipaypal.review_and_submit.ReviewAndSubmitActivity

class MainActivity : AppCompatActivity() {
    private val userListViewModel by viewModels<UserListViewModel> {
        UserListViewModelFactory(this)
    }

    private val historyTradeViewModel by viewModels<TradeViewModel> {
        TradeViewModelFactory(this)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //recycle view user
        val linearLayoutManager =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val userAdapter = UserAdapter { user -> userAdapterOnClick(user) }
        val userRecyclerView: RecyclerView = findViewById(R.id.recycle_view_user)
        userRecyclerView.adapter = userAdapter
        userRecyclerView.layoutManager = linearLayoutManager
        userListViewModel.userLivedata.observe(this) {
            it?.let {
                userAdapter.submitList(it as MutableList<User>)
            }
        }

        //recycle view history trade
        val linearLayoutManager1 =
            LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        val historyTradeAdapter =
            HistoryTradeAdapter { historyTrade -> historyTradeAdapterOnClick(historyTrade) }
        val historyTradeRecyclerView: RecyclerView = findViewById(R.id.recycle_view_trade)
        historyTradeRecyclerView.adapter = historyTradeAdapter
        historyTradeRecyclerView.layoutManager = linearLayoutManager1
        historyTradeViewModel.historyTradeLiveData.observe(this) {
            it?.let {
                historyTradeAdapter.submitList(it as MutableList<HistoryTrade>)
            }
        }

    }

    private fun historyTradeAdapterOnClick(historyTrade: HistoryTrade) {

    }


    private fun userAdapterOnClick(user: User) {
        val intent = Intent(this@MainActivity, ReviewAndSubmitActivity::class.java)
        startActivity(intent)
    }
}