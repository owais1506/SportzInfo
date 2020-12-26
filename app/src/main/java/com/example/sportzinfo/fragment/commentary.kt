package com.example.sportzinfo.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.sportzinfo.R
import com.example.sportzinfo.adapter.TeamADataAdapter
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.model.MatchResult

class commentary : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_commentary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GetMatchSyncData(view.context,view).execute()


    }

    companion object {
        private lateinit var matchResult : MatchResult


        @JvmStatic
        fun newInstance() = commentary()

        class GetMatchSyncData(context: Context,viewFrag: View) : AsyncTask<Void, Void, MatchResult?>()
        {
            val ctx : Context = context
            val view = viewFrag
            override fun doInBackground(vararg params: Void?): MatchResult? {
                matchResult = DatabaseClient.getInstance(ctx)?.appDatabase?.taskDao()?.getAll()!!
                //Log.e("History",DatabaseClient.getInstance(ctx)?.appDatabase?.taskDao()?.getPlayerScore("1").toString()!!)
                return matchResult
            }

            override fun onPostExecute(result: MatchResult?)
            {
                super.onPostExecute(result)
                val matchInfo = view.findViewById<TextView>(R.id.matchInfo);
                val matchStatus = view.findViewById<TextView>(R.id.match_status);
                val matchVenue = view.findViewById<TextView>(R.id.match_venue);
                val matchWin = view.findViewById<TextView>(R.id.match_win);
                val matchPlayer = view.findViewById<TextView>(R.id.match_player);
                val matchUmpire = view.findViewById<TextView>(R.id.match_umpire);
                val matchRefree = view.findViewById<TextView>(R.id.match_refree);

                matchInfo.text = matchResult.matchDetails?.series?.series_name//response.body()?.matchDetails?.series?.name
                matchStatus.text = matchResult.matchDetails?.match_status//response.body()?.matchDetails?.status
                matchVenue.text = matchResult.matchDetails?.venue?.venue_name
                matchWin.text = matchResult.matchDetails?.result
                matchPlayer.text = matchResult.matchDetails?.player_match
                matchUmpire.text = matchResult.matchDetails?.officials?.umpire
                matchRefree.text = matchResult.matchDetails?.officials?.refree
            }
        }
    }
}