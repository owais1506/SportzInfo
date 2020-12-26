package com.example.sportzinfo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinfo.R
import com.example.sportzinfo.model.Batting

class PlayersScoreAdapter (val players:List<Batting>):RecyclerView.Adapter<PlayersScoreAdapter.DataViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder (
        LayoutInflater.from(parent.context).inflate(
                R.layout.item_players_score, parent,
                false
        )
    )

    override fun getItemCount(): Int {
        return players.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
       holder.bind(players[position],position)
    }

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val sr_no = itemView.findViewById<AppCompatTextView>(R.id.player_no)
        val pname = itemView.findViewById<AppCompatTextView>(R.id.player_name)
        val pfour = itemView.findViewById<AppCompatTextView>(R.id.player_four)
        val prun = itemView.findViewById<AppCompatTextView>(R.id.player_run)
        val psix = itemView.findViewById<AppCompatTextView>(R.id.player_six)
        val pavg = itemView.findViewById<AppCompatTextView>(R.id.player_strike_rate)
        val out = itemView.findViewById<AppCompatTextView>(R.id.player_how_out)

        fun bind(playerRun : Batting,position: Int){
            sr_no.text = position.toString()
            pname.text = playerRun.batsman
            prun.text = playerRun.runs
            pfour.text = playerRun.four
            psix.text = playerRun.six
            pavg.text = playerRun.strike_rate
            out.text = playerRun.how_out
        }
    }
}