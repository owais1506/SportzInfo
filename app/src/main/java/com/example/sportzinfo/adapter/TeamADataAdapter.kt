package com.example.sportzinfo.adapter

import android.content.Context
import android.graphics.Color
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinfo.R
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.fragment.TeamA
import com.example.sportzinfo.model.History
import com.example.sportzinfo.model.MatchDetail
import com.example.sportzinfo.model.MatchResult
import com.example.sportzinfo.model.Teams

class TeamADataAdapter(val teamRecords: MatchResult,val teamNo : Int) : RecyclerView.Adapter<TeamADataAdapter.DataViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder (
            LayoutInflater.from(parent.context).inflate(
                    R.layout.item_layout, parent,
                    false
            )
    )

    override fun getItemCount(): Int {
        return 11
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(teamRecords,teamNo,position)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name = itemView.findViewById<AppCompatTextView>(R.id.username)
        fun bind(playerData : MatchResult,teamNo:Int,position: Int)
        {
            when(teamNo)
            {

                1 -> when (position) {

                    0 ->{
                        checkCondition(playerData.teams?.teamA?.player?.ta_p1!!)

                        Log.e("Inning size []", playerData.inningValue?.size.toString())
                        Log.e("Inning size get", playerData.inningValue?.get(0)?.total!!)
                        Log.e("Inning size []", playerData.inningValue!![0].total!!)

                        Log.e("Batsmen size 1", playerData.inningValue?.get(0)?.batsmen?.size.toString())
                        Log.e("Batsmen size 2", playerData.inningValue?.get(1)?.batsmen?.size.toString())

                    }

                    1 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p2!!)

                    }
                    2 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p3!!)
                        //name.text = playerData.teams.teamA.player.ta_p2.full_name
                    }
                    3 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p4!!)
                        //name.text = playerData.teams.teamA.player.ta_p3.full_name
                    }
                    4 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p5!!)
                        //name.text = playerData.teams.teamA.player.ta_p4.full_name
                    }
                    5 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p6!!)
                        //name.text = playerData.teams.teamA.player.ta_p5.full_name
                    }
                    6 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p7!!)
                        //name.text = playerData.teams.teamA.player.ta_p6.full_name
                        //name.setBackgroundColor(Color.BLUE)
                    }
                    7 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p8!!)
                        //name.text = playerData.teams.teamA.player.ta_p7.full_name
                    }
                    8 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p9!!)
                        //name.text = playerData.teams.teamA.player.ta_p8.full_name
                    }
                    9 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p10!!)
                        //name.text = playerData.teams.teamA.player.ta_p9.full_name
                    }
                    10 -> {
                        checkCondition(playerData.teams?.teamA?.player?.ta_p11!!)
                        //name.text = playerData.teams.teamA.player.ta_p10.full_name
                    }
                    /*11 -> {
                        //checkCondition(playerData.teams.teamA.player.ta_p11)
                        //name.text = playerData.teams.teamA.player.ta_p11.full_name
                    }*/
                }
                2-> when(position){
                    0 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p1!!)

                    }
                    1 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p2!!)
                        //name.text = playerData.teams.teamB.player.tb_p2.full_name
                    }
                    2 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p3!!)
                        //name.text = playerData.teams.teamB.player.tb_p3.full_name
                    }
                    3 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p4!!)
                        //name.text = playerData.teams.teamB.player.tb_p4.full_name
                    }
                    4 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p5!!)
                        //name.text = playerData.teams.teamB.player.tb_p5.full_name
                    }
                    5 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p6!!)
                        //name.text = playerData.teams.teamB.player.tb_p6.full_name

                    }
                    6 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p7!!)
                        //name.text = playerData.teams.teamB.player.tb_p7.full_name
                    }
                    7 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p8!!)
                        //name.text = playerData.teams.teamB.player.tb_p8.full_name
                    }
                    8 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p9!!)
                        //name.text = playerData.teams.teamB.player.tb_p9.full_name
                    }
                    9 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p10!!)
                        //name.text = playerData.teams.teamB.player.tb_p10.full_name
                    }
                    10 -> {
                        checkCondition(playerData.teams?.teamB?.player?.tb_p11!!)
                        //name.text = playerData.teams.teamB.player.tb_p11.full_name
                    }


                }
            }
        }


        fun checkCondition(history: History) : AppCompatTextView {

            if(history.is_captain && history.is_keeper){
                name.text = history.full_name.plus(" c & w")
                name.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            }
            else if(history.is_captain){
                name.text = history.full_name.plus(" c")
                name.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            }
            else if(history.is_keeper){
                name.text = history.full_name.plus(" w ")
                name.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            }
            else{
                name.text = history.full_name
            }
            return name
        }

    }


}