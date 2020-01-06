package apptest.com.testearquiteturacomponentes.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import apptest.com.testearquiteturacomponentes.entity.User
import apptest.com.testearquiteturacomponentes.repository.DAO.UserDao

@Database(entities = [User::class], version = 1)
abstract class DatabaseRoom :RoomDatabase(){

    abstract fun getUserDao(): UserDao

    companion object{

        private var INSTANCE: DatabaseRoom? = null

        fun getInstance(context: Context):DatabaseRoom?{

            if (INSTANCE == null){

                synchronized(DatabaseRoom::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DatabaseRoom::class.java, "bancodados.db")
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}