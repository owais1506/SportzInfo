package com.example.sportzinfo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.BaseExpandableListAdapter
import androidx.appcompat.widget.AppCompatTextView
import com.example.sportzinfo.R

class CustomeSpinnerAdapter(val ctx: Context,val str:Array<String>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View? = convertView

        view = LayoutInflater.from(ctx).inflate(R.layout.item_layout,parent,false)
        val textView:AppCompatTextView=view?.findViewById(R.id.username)!!
        textView.text = str[position]

        return view

    }

    override fun getItem(position: Int): Any {
        return str[position]
    }

    override fun getItemId(position: Int): Long {
    return 0
    }

    override fun getCount(): Int {
        return str.size
    }


}