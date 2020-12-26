package com.example.sportzinfo.database

import android.content.Context
import androidx.room.Room


class DatabaseClient private constructor(mCtx: Context) {
    private val mCtx: Context
    //our app database object
    val appDatabase: AppDatabase

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(mCtx: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(mCtx)
            }
            return mInstance
        }
    }

    init {
        this.mCtx = mCtx
        //creating the app database with Room database builder
        //MyToDos is the name of the database
        appDatabase = Room.databaseBuilder(mCtx, AppDatabase::class.java, "SportzInfo1")
            .fallbackToDestructiveMigration()
            .build()
    }
}
