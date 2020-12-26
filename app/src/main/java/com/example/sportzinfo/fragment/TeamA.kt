package com.example.sportzinfo.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.sportzinfo.R
import com.example.sportzinfo.adapter.TeamADataAdapter
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.interfaces.MatchResponse
import com.example.sportzinfo.model.*
import com.example.sportzinfo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response


class TeamA : Fragment() {
    lateinit var retrofitInstance : RetrofitInstance



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //swipeRefreshLayout = view.findViewById(R.id.refresh_team_one)
        recyclerView = view.findViewById(R.id.rv_teamA)
        GetMatchSyncData(view.context).execute()
    }

    companion object {
        private lateinit var teamADataAdapter : TeamADataAdapter
        private var recyclerView: RecyclerView? = null

        @JvmStatic
        fun newInstance() = TeamA()

        class GetMatchSyncData(context: Context) : AsyncTask<Void, Void, MatchResult?>()
        {
            val ctx : Context = context
            override fun doInBackground(vararg params: Void?): MatchResult? {
                val matchResult : MatchResult = DatabaseClient.getInstance(ctx)?.appDatabase?.taskDao()?.getAll()!!
                return matchResult
            }

            override fun onPostExecute(result: MatchResult?)
            {
                super.onPostExecute(result)
                teamADataAdapter = TeamADataAdapter(result!!,1)
                recyclerView?.adapter = teamADataAdapter
            }
        }
    }
}