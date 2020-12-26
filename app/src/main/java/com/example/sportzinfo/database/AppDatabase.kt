package com.example.sportzinfo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sportzinfo.fragment.TeamA
import com.example.sportzinfo.fragment.TeamB
import com.example.sportzinfo.interfaces.TaskDao
import com.example.sportzinfo.model.*

/*,Innings::class,Teams::class,Series::class,Venue::class,Officials::class,Batting::class,InfoTeamA::class,InfoTeamB::class,PlayersA::class,PlayersB::class,History::class*/
@Database(entities =[MatchResult::class], version = 11)
@TypeConverters(InningConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao?
}