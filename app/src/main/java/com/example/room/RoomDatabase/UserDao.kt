package com.example.room.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

@Insert
fun insert(user:User?)

@Update
fun update(user: User?)

@Delete
fun deleteAllUser(user: User?)


@Query("SELECT * FROM ${DataBase_name.databaseName} order by id desc")
fun getAllUser(): List<User>?

}