package com.example.uipaypal.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.uipaypal.R
import com.example.uipaypal.adapter.UserAdapter
import com.example.uipaypal.data.user.User
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    private val userListViewModel by viewModels<UserListViewModel> {
        UserListViewModelFactory(this)
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
    }


    private fun userAdapterOnClick(user: User) {

    }
}