package com.example.sportzinfo.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.sportzinfo.fragment.TeamA
import com.example.sportzinfo.fragment.TeamB
import com.example.sportzinfo.fragment.fragment_scorecard

class TabAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm)    {
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()
    /*Log.e("Inning 1",playerData.inningValue?.get(0).b)
    Log.e("Inning 2",playerData.inningValue?.get(1).toString()!!)
    Log.e("Team 1",playerData.inningValue?.get(0)?.batsmen?.get(0).toString()!!)
    Log.e("Team 2",playerData.inningValue?.get(1)?.batsmen?.get(1).toString()!!)*/

    override fun getItem(position: Int): Fragment {
        return mFragmentList.get(position)
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}