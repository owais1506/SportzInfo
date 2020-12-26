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
import android.widget.Toast
import com.example.sportzinfo.R
import com.example.sportzinfo.database.DatabaseClient
import com.example.sportzinfo.interfaces.MatchResponse
import com.example.sportzinfo.model.MatchResult
import com.example.sportzinfo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Response
import java.lang.ref.WeakReference
import javax.security.auth.callback.Callback

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

private  var matchResult : MatchResult? = null

class fragment_summary : Fragment() {

    public lateinit var retrofitInstance : RetrofitInstance
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retrofitInstance = RetrofitInstance().getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewRoot: View = inflater.inflate(R.layout.fragment_summary, container, false)

        return viewRoot
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val matchInfo = view.findViewById<TextView>(R.id.matchInfo);
        val matchStatus = view.findViewById<TextView>(R.id.match_status);
        val matchVenue = view.findViewById<TextView>(R.id.match_venue);
        val matchWin = view.findViewById<TextView>(R.id.match_win);
        val matchPlayer = view.findViewById<TextView>(R.id.match_player);

        val matchResponse : MatchResponse = retrofitInstance.getClient()?.create(MatchResponse::class.java)!!

        /*if(!retrofitInstance.inNetwork()) {
            Toast.makeText(view.context,"Please check your internet connection...",Toast.LENGTH_LONG).show()
            return
        }*/

        val matchData: Call<MatchResult> = matchResponse.getMatchData()
        matchData.enqueue(object : retrofit2.Callback<MatchResult> {
            override fun onFailure(call: Call<MatchResult>, t: Throwable) {
                Log.e("Response Failure","Api fails")
                Toast.makeText(view.context,"Response Fails",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MatchResult>, response: Response<MatchResult>) {
                if(response.isSuccessful)
                {
                    matchResult = response.body()
                    matchInfo.text = matchResult?.matchDetails?.series?.series_name//response.body()?.matchDetails?.series?.name
                    matchStatus.text = matchResult?.matchDetails?.match_status//response.body()?.matchDetails?.status
                    matchVenue.text = matchResult?.matchDetails?.venue?.venue_name
                    matchWin.text = matchResult?.matchDetails?.result
                    matchPlayer.text = matchResult?.matchDetails?.player_match
                    MyAsyncTask(view.context).execute()
                }
                else{
                    Toast.makeText(view.context,"Something went wrong...",Toast.LENGTH_LONG).show()
                }
                //Log.e("Response Success","Api success")

            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance() =
            fragment_summary()


        class MyAsyncTask internal constructor(context: Context) : AsyncTask<Int, String, String?>() {

            val ctx : Context = context
            override fun onPreExecute() {

            }

            override fun doInBackground(vararg params: Int?): String? {
                DatabaseClient.getInstance(ctx)?.appDatabase?.taskDao()?.insert(matchResult!!)
                return null
            }

            override fun onPostExecute(result: String?) {


            }

        }
    }
}



