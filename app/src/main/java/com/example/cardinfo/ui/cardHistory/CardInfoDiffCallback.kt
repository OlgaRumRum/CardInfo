package com.example.binapp.ui.history

import androidx.recyclerview.widget.DiffUtil
import com.example.cardinfo.domain.model.CardInfo

class CardInfoDiffCallback : DiffUtil.ItemCallback<CardInfo>() {
    override fun areItemsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem.number == newItem.number
    }

    override fun areContentsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem == newItem
    }
}