package com.example.uipaypal.main

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.uipaypal.data.user.UserDataSource

class UserListViewModel(val userDataSource: UserDataSource) : ViewModel() {
    val userLivedata = userDataSource.getUserList()

}

class UserListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserListViewModel(
                userDataSource = UserDataSource.getUserDataSource()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}