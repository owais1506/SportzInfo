package com.example.sportzinfo.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.sportzinfo.R
import com.example.sportzinfo.adapter.TabAdapter
import com.google.android.material.tabs.TabLayout


class fragment_scorecard : Fragment() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        val view : View = inflater.inflate(R.layout.fragment_scorecard, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewpager1)

        val adapter = TabAdapter(this.childFragmentManager)
        adapter.addFragment(TeamA(),"Team A")
        adapter.addFragment(TeamB(),"Team B")
        viewPager?.adapter = adapter
        tabLayout?.setupWithViewPager(viewPager)
        viewPager?.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout?.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager?.currentItem = tab?.position!!
            }

        })

        //tabLayout?.tabGravity = TabLayout.GRAVITY_FILL
        //tabLayout?.setTabTextColors(Color.WHITE,Color.BLUE)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            fragment_scorecard()


    }
}