package com.hong.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List: MutableList<ListViewModel>) : BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(p: Int) : Any {
        return List[p]
    }

    override fun getItemId(p: Int): Long {
        return p.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView = p1

        if (convertView == null) {
            convertView = LayoutInflater.from(p2?.context).inflate(R.layout.listview_item, p2, false)
        }

        val title =  convertView!!.findViewById<TextView>(R.id.listViewItem1)
        val content =  convertView!!.findViewById<TextView>(R.id.listViewItem2)
        title.text = List[p0].title
        content.text = List[p0].content


        return convertView!!
    }

}