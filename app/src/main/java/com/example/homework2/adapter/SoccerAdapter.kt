package com.example.homework2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework2.data.model.Soccer
import com.example.homework2.databinding.ItemBinding


class SoccerAdapter : RecyclerView.Adapter<SoccerAdapter.SoccerViewHolder>() {
    private var soccerList = mutableListOf<Soccer>()

    fun setSoccerList(soccerList: MutableList<Soccer>) {
        this.soccerList.clear()
        this.soccerList.addAll(soccerList)
        notifyDataSetChanged()
    }

    inner class SoccerViewHolder(private val binding :ItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
        fun onBind(soccer: Soccer) {
            binding.ivSoccer.setImageResource(soccer.image)
            binding.tvName.text = soccer.text
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SoccerAdapter.SoccerViewHolder {
        return SoccerViewHolder(
            ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return soccerList.size
    }

    override fun onBindViewHolder(holder: SoccerAdapter.SoccerViewHolder, position: Int) {
        holder.onBind(soccerList[position])
    }
}