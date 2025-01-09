package com.example.cardinfo.ui.cardHistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cardinfo.R

class CardHistoryFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card_history, container, false)
    }

    companion object {
        fun newInstance() = CardHistoryFragment()
    }
}
