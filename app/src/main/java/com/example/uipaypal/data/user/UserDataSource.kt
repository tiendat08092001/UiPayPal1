package com.example.uipaypal.data.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class UserDataSource {
    private val initialUserList = userList()
    private val userLiveData = MutableLiveData(initialUserList)

    fun getUserList(): LiveData<List<User>> {
        return userLiveData
    }

    companion object {
        private var INSTANCE: UserDataSource? = null

        fun getUserDataSource(): UserDataSource {
            return synchronized(UserDataSource::class) {
                val newInstance = INSTANCE ?: UserDataSource()
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}