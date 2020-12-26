package com.example.sportzinfo.fragment

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sportzinfo.R
import com.example.sportzinfo.adapter.TeamADataAdapter
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.model.MatchResult
import com.example.sportzinfo.network.RetrofitInstance


class TeamB : Fragment() {

    lateinit var retrofitInstance : RetrofitInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rv_teamB)
        GetMatchSyncData(view.context).execute()
    }

    companion object {
        private lateinit var teamADataAdapter : TeamADataAdapter
        private var recyclerView: RecyclerView? = null

        @JvmStatic
        fun newInstance() = TeamB()

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
                teamADataAdapter = TeamADataAdapter(result!!,2)
                recyclerView?.adapter = teamADataAdapter
            }
        }

    }
}