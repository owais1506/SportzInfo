package com.example.sportzinfo.model


import androidx.room.*
import com.example.sportzinfo.database.InningConverter
import com.example.sportzinfo.database.ListofListConverter
import com.google.gson.annotations.SerializedName
import kotlin.text.MatchResult


@Entity

class MatchResult(){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    var _id:Int = 0

    @Embedded
    @SerializedName("Matchdetail")
    var matchDetails:MatchDetail ?=null


    @SerializedName("Innings")
    @Embedded(prefix = "this_innings_")

     var inningValue:List<InningsName>? = arrayListOf()
        get() = field
        set(value) {field=value}

    @Embedded
    @SerializedName("Teams")
    var teams: Teams?=null
}

//@Entity
data class MatchDetail(
/*    @PrimaryKey(autoGenerate = true)
    val match_id:Int,*/

    @Embedded
    @SerializedName("Series")
    val series: Series,
    @Embedded
    @SerializedName("Venue")
    val venue: Venue,
    @Embedded
    @SerializedName("Officials")
    val officials: Officials,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Status")
    val match_status: String,
    @SerializedName("Player_Match")
    val player_match: String
    )

//@Entity


class InningsName() {
    @PrimaryKey(autoGenerate = true)
    var innings_id: Int =0

    @SerializedName("Number")
    var number: String?=null

    @SerializedName("Battingteam")
    var battingteam: String ?= null

    @SerializedName("Total")
    var total: String ?= null

    @SerializedName("Wickets")
    var wickets: String ?=null

    @SerializedName("Overs")
    var overs: String ?=null

    @SerializedName("Runrate")
    var runrate: String ?=null

    @SerializedName("Legbyes")
    var legbyes: String ?=null

    @SerializedName("Wides")
    var wides: String ?=null

    @SerializedName("Noballs")
    var noballs: String ?=null

    //@TypeConverters(ListofListConverter::class)
    @SerializedName("Batsmen")
    @Embedded(prefix = "this_batsmen_")
    @Relation(
            parentColumn = "inningValue",
            entityColumn = "batting_id"
    )
    var batsmen: List<Batting>? = arrayListOf()
    get() = field
    set(value) {field=value}

    @SerializedName("AllottedOvers")
    var allottedovers: String ?=null

}
//@Entity
data class Batting(
    @PrimaryKey(autoGenerate = true)
    var batting_id: Int  =0,

    @SerializedName("Batsman")
    var batsman: String? = "",

    @SerializedName("Runs")
    var runs: String ?="",

    @SerializedName("Balls")
    var balls: String ? ="",

    @SerializedName("Fours")
    var four: String ? ="",

    @SerializedName("Sixes")
    var six: String ? ="",

    @SerializedName("Strikerate")
    var strike_rate: String?="",

    @SerializedName("Howout")
    var how_out: String?=""
)

//@Entity
data class Series(
/*    @PrimaryKey(autoGenerate = true)
    val series_id:Int,*/
    @SerializedName("Name")
    val series_name: String,
    @SerializedName("Status")
    val series_status: String
)
//@Entity
data class Venue(
    /*@PrimaryKey(autoGenerate = true)
    val venue_id:Int,*/
    @SerializedName("Name")
    val venue_name: String
)
//@Entity
data class Officials(
    /*@PrimaryKey(autoGenerate = true)
    val official_id:Int,*/
    @SerializedName("Umpires")
    val umpire: String,
    @SerializedName("Referee")
    val refree: String
)
//@Entity
data class Teams(
        /*@PrimaryKey(autoGenerate = true)
        val teams_id:Int,*/
        @Embedded
        @SerializedName("6")
        val teamA: InfoTeamA,
        @Embedded
        @SerializedName("7")
        val teamB: InfoTeamB
)
//@Entity
data class InfoTeamA(
        /*@PrimaryKey(autoGenerate = true)
        val teamA_id:Int,*/
        @Embedded
        @SerializedName("Players")
        val player: PlayersA
)
//@Entity
data class InfoTeamB(
 /*       @PrimaryKey(autoGenerate = true)
        val teamB_id:Int,*/
    @Embedded
    @SerializedName("Players")
    val player: PlayersB
)
//@Entity
data class PlayersA(
 /*       @PrimaryKey(autoGenerate = true)
        val playerA_id:Int,*/
        @Embedded(prefix = "ta_pa1_")
        @SerializedName("63084")
        val ta_p1: History,
        @Embedded(prefix = "ta_pa2_")
        @SerializedName("57492")
        val ta_p2: History,
        @Embedded(prefix = "ta_pa3_")
        @SerializedName("59429")
        val ta_p3: History,
        @Embedded(prefix = "ta_pa4_")
        @SerializedName("3472")
        val ta_p4: History,
        @Embedded(prefix = "ta_pa5_")
        @SerializedName("2734")
        val ta_p5: History,
        @Embedded(prefix = "ta_pa6_")
        @SerializedName("4038")
        val ta_p6: History,
        @Embedded(prefix = "ta_pa7_")
        @SerializedName("65739")
        val ta_p7: History,
        @Embedded(prefix = "ta_pa8_")
        @SerializedName("64073")
        val ta_p8: History,
        @Embedded(prefix = "ta_pa9_")
        @SerializedName("64321")
        val ta_p9: History,
        @Embedded(prefix = "ta_pa10_")
        @SerializedName("64306")
        val ta_p10: History,
        @Embedded(prefix = "ta_pa11_")
        @SerializedName("66833")
        val ta_p11: History
)
//@Entity
data class PlayersB(
 /*       @PrimaryKey(autoGenerate = true)
        val playerB_id:Int,*/
        @Embedded(prefix = "tb_pa1_")
        @SerializedName("3667")
        val tb_p1: History,
        @Embedded(prefix = "tb_pa2_")
        @SerializedName("4356")
        val tb_p2: History,
        @Embedded(prefix = "tb_pa3_")
        @SerializedName("12518")
        val tb_p3: History,
        @Embedded(prefix = "tb_pa4_")
        @SerializedName("28891")
        val tb_p4: History,
        @Embedded(prefix = "tb_pa5_")
        @SerializedName("5313")
        val tb_p5: History,
        @Embedded(prefix = "tb_pa6_")
        @SerializedName("59736")
        val tb_p6: History,
        @Embedded(prefix = "tb_pa7_")
        @SerializedName("64221")
        val tb_p7: History,
        @Embedded(prefix = "tb_pa8_")
        @SerializedName("63611")
        val tb_p8: History,
        @Embedded(prefix = "tb_pa9_")
        @SerializedName("24669")
        val tb_p9: History,
        @Embedded(prefix = "tb_pa10_")
        @SerializedName("48191")
        val tb_p10: History,
        @Embedded(prefix = "tb_pa11_")
        @SerializedName("57458")
        val tb_p11: History
)

//@Entity
data class History(
        @PrimaryKey
        val id:Int,
        @SerializedName("Position")
        val position: String,
        @SerializedName("Name_Full")
        val full_name: String,
        @SerializedName("Iscaptain")
        val is_captain: Boolean,
        @SerializedName("Iskeeper")
        val is_keeper: Boolean
)
