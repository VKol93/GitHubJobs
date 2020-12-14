/*
package com.example.cars2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class SimpleAdapter<T>(var list: List<T>,
                       val layout: Int,
                       val bind: (view: View, item: T) -> Unit
) : RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder<T>>(){
    var listener: Listener<T>? = null
    var onClickItemCallBack: ((T)->Unit)? = null
    interface Listener<T>{
        fun onClickItemListener(item: T)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder<T> {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(layout, parent, false)
        val holder = SimpleViewHolder<T>(view)
        view.setOnClickListener {
            holder.item?.let {
                listener?.onClickItemListener(it)
                onClickItemCallBack?.invoke(it)
            }
        }
        return holder
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: SimpleViewHolder<T>, position: Int) {
        holder.item = list[position]
        bind(holder.itemView, list[position])
    }

    class SimpleViewHolder<T>(val view: View) : RecyclerView.ViewHolder(view) {
        var item: T? = null
    }
}

fun <T> RecyclerView.setSimpleAdapter(list: List<T>,
                                      layout: Int,
                                      bind: (view: View, item: T) -> Unit
){
    layoutManager = LinearLayoutManager(context)
    adapter = SimpleAdapter(list, layout, bind)
}

fun <T>RecyclerView.refreshList(newList: List<T>){
    val adapter = (adapter as? SimpleAdapter<T>)
    adapter?.apply {
        list = newList
        notifyDataSetChanged()
    }
}

fun <T> RecyclerView.setOnclickItemListener(listener: SimpleAdapter.Listener<T>){
    (adapter as? SimpleAdapter<T>)?.listener = listener
}

fun <T> RecyclerView.setOnClickItemListener(callBack: (T)->Unit){
    (adapter as SimpleAdapter<T>).onClickItemCallBack = callBack
}

class StringAdapter(val list: List<String>) : RecyclerView.Adapter<StringAdapter.TextViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val linearLayout = LinearLayout(parent.context)
        linearLayout.orientation = LinearLayout.VERTICAL
        val layoutParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        linearLayout.layoutParams = layoutParams
        val textViewParams =
            ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val textView = TextView(parent.context)
        textView.layoutParams = textViewParams
        linearLayout.addView(textView)
        return TextViewHolder(linearLayout, textView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.text = list[position]
        holder.textView.text = list[position]
    }

    class TextViewHolder(view: View, val textView: TextView) : RecyclerView.ViewHolder(view) {
        var text: String? = null
    }
}

fun RecyclerView.setStringAdapter(list: List<String>){
    layoutManager = LinearLayoutManager(context)
    adapter = StringAdapter(list)
}
*/
