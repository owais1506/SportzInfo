package com.example.sportzinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.sportzinfo.fragment.commentary
import com.example.sportzinfo.fragment.fragment_scorecard
import com.example.sportzinfo.fragment.fragment_summary
import com.example.sportzinfo.fragment.MatchInfo
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: ActionBar
    val SummaryFragment = fragment_summary
    val ScorecardFragment = fragment_scorecard
    val CommentaryFragment = commentary
    val MatchInfo = com.example.sportzinfo.fragment.MatchInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setCurrentFragment(SummaryFragment.newInstance())
        //toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.navigation_summary -> setCurrentFragment(SummaryFragment.newInstance())
                R.id.navigation_scorecard ->  setCurrentFragment(ScorecardFragment.newInstance())
                R.id.navigation_commentary -> setCurrentFragment(CommentaryFragment.newInstance())
                R.id.navigation_match_info -> setCurrentFragment(MatchInfo.newInstance())
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container,fragment)
            addToBackStack(null)
            commit()
        }
}