package com.example.myapplication666.ui.diary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication666.R
import com.example.myapplication666.database.Model

class DiaryAdapter : RecyclerView.Adapter<DiaryAdapter.NewDiaryVewHolder>() {

    var list = mutableListOf<Model>()
    private lateinit var listener: OnChangeSeekBarListener

    fun attachListener(listener: OnChangeSeekBarListener) {
        this.listener = listener
    }

    inner class NewDiaryVewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.text)
        val seekBar = itemView.findViewById<SeekBar>(R.id.seekBar)
        val counter = itemView.findViewById<TextView>(R.id.counter)
        val day = itemView.findViewById<TextView>(R.id.day)
        fun bind(position: Int) {
            day.text = list[position].day
            textView.text = list[position].text
            seekBar.progress = list[position].characteristic
            seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {

                }

                override fun onStartTrackingTouch(seekBar: SeekBar?) {

                }

                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                    list[position].characteristic = seekBar!!.progress
                    listener.onChanged(list)
                    counter.text = seekBar.progress.toString()
                }

            })
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewDiaryVewHolder {
        val param =
            LayoutInflater.from(parent.context).inflate(R.layout.item_new_diary, parent, false)
        return NewDiaryVewHolder(param)
    }

    override fun onBindViewHolder(holder: NewDiaryVewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(list: MutableList<Model>) {
        this.list = list
        notifyDataSetChanged()
    }

    fun removeByPosition(position: Int) {
        this.list.removeAt(position)
        notifyItemRemoved(position)
    }

}