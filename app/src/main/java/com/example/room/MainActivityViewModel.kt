package com.example.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.room.RoomDatabase.User
import com.example.room.RoomDatabase.UserDatabase

class MainActivityViewModel(app: Application) : AndroidViewModel(app) {


    private var allUser: MutableLiveData<List<User>> = MutableLiveData()

    private fun getAllUsers() {
        val userDatabase = UserDatabase.getInstance(getApplication()).UserDao()
        val list = userDatabase.getAllUser()
        allUser.postValue(list)
    }

    fun getAllUsersService(): MutableLiveData<List<User>> {
        return allUser
    }

    fun insertUser(entity: User) {
        val userDatabase = UserDatabase.getInstance(getApplication()).UserDao()
        userDatabase.insert(entity)
        getAllUsers()
    }

    fun deleteUser(entity: User) {
        val userDatabase = UserDatabase.getInstance(getApplication()).UserDao()
        userDatabase.deleteAllUser(entity)
        getAllUsers()
    }

    fun updateUser(entity: User) {
        val userDatabase = UserDatabase.getInstance(getApplication()).UserDao()
        userDatabase.update(entity)
        getAllUsers()

    }


}