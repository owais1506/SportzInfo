package com.example.sportzinfo.database

import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import androidx.room.TypeConverter
import com.example.sportzinfo.model.Batting
import com.example.sportzinfo.model.InningsName


class InningConverter {

    @TypeConverter
    fun toInningValue(value: String?): List<InningsName?>? {
        if(value == null){
            return null
        }
        val gson = Gson()
        val listType: Type = object : TypeToken<List<InningsName?>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun toJson(torrent: List<InningsName>?): String? {
        if(torrent == null){
            return null
        }
        val type = object: TypeToken<List<InningsName>>() {}.type
        return Gson().toJson(torrent, type)
    }

}