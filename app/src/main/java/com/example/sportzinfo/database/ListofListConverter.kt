package com.example.sportzinfo.database

import androidx.room.TypeConverter
import com.example.sportzinfo.model.Batting
import com.example.sportzinfo.model.InningsName
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class ListofListConverter {
    /*@TypeConverter
    fun toBattingValue(value: String?): List<List<Batting?>>? {
        if(value == null){
            return null
        }
        val gson = Gson()
        val listType: Type = object : TypeToken<List<List<Batting>?>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun toBattingJson(torrent: List<List<Batting>>?): String? {
        if(torrent == null){
            return null
        }
        val type = object: TypeToken<List<List<Batting>>>() {}.type
        return Gson().toJson(torrent, type)
    }*/
    @TypeConverter
    fun fromBattingValue(value: String?): List<Batting>? {
        if(value == null){
            return null
        }
        val gson = Gson()
        val listType: Type = object : TypeToken<List<Batting>?>() {}.type
        return gson.fromJson(value,listType)
    }

    @TypeConverter
    fun toBattingJson(torrent: List<Batting>?): String? {
        if(torrent == null){
            return null
        }
        val type = object: TypeToken<List<Batting>>() {}.type
        return Gson().toJson(torrent, type)
    }
}