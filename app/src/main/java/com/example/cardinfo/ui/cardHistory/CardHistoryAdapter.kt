package com.example.binapp.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cardinfo.databinding.RvCardItemBinding
import com.example.cardinfo.domain.model.CardInfo

class CardHistoryAdapter : ListAdapter<CardInfo, CardHistoryViewHolder>(CardInfoDiffCallback()) {

    var onLongClickListener: CardHistoryViewHolder.OnLongClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHistoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvCardItemBinding.inflate(layoutInflater, parent, false)
        return CardHistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardHistoryViewHolder, position: Int) {
        val cardInfo = getItem(position)
        holder.bind(cardInfo, onLongClickListener)
    }
}