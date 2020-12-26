package com.example.sportzinfo.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sportzinfo.R
import androidx.appcompat.widget.AppCompatSpinner
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinfo.adapter.CustomeSpinnerAdapter
import com.example.sportzinfo.adapter.PlayersScoreAdapter
import com.example.sportzinfo.adapter.TeamADataAdapter
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.model.Batting
import com.example.sportzinfo.model.MatchResult
//import com.example.sportzinfo.model.PlayerHistory


class MatchInfo : Fragment()
{
    var countryNames = arrayOf("India", "China", "Australia", "Portugle", "America", "New Zealand")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*val spinner = view.findViewById<AppCompatSpinner>(R.id.spinner)
        val spinnerAdapter:CustomeSpinnerAdapter = CustomeSpinnerAdapter(view.context,countryNames)

        spinner.adapter = spinnerAdapter*/

        players_runs  = view.findViewById(R.id.rv_players_runs);
        GetPlayersRun(view.context).execute()


    }

    companion object {

        lateinit var adapter : PlayersScoreAdapter
        private var  players_runs : RecyclerView ?= null

        @JvmStatic
        fun newInstance() = MatchInfo()

        class GetPlayersRun(context: Context) : AsyncTask<Void, Void, List<Batting>?>()
        {
            val ctx : Context = context
            override fun doInBackground(vararg params: Void?): List<Batting>? {
                /*val playersRun : List<Batting> = DatabaseClient.getInstance(ctx)?.appDatabase?.taskDao()?.getPlayersBattingRuns()!!
                Log.e("Players size",playersRun.size.toString())
                Log.e("Players run",playersRun[0].runs)
                return playersRun*/
                return null
            }

            override fun onPostExecute(result: List<Batting>?)
            {
                super.onPostExecute(result)
                adapter = PlayersScoreAdapter(result!!)
                players_runs?.adapter = adapter
            }
        }
    }
}