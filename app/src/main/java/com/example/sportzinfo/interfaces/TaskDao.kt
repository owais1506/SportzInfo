package com.example.sportzinfo.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sportzinfo.model.*

@Dao
interface TaskDao{
    @Query("SELECT * FROM MatchResult")
    fun getAll(): MatchResult

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(task: MatchResult)

    /*
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertName(task: History)

    @Query("SELECT * FROM History")
    fun getName():History

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertPlayersBattingRuns(task : List<Batting>)*/

    /*@Query("SELECT * FROM Batting")
    fun getPlayersBattingRuns():List<Batting>*/

    /*@Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertTeamInnings(task : List<Innings>)*/
}