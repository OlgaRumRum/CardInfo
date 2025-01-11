package com.example.binapp.ui.history

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cardinfo.databinding.RvCardItemBinding
import com.example.cardinfo.domain.model.CardInfo

class CardHistoryViewHolder(
    private val binding: RvCardItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(
        cardInfo: CardInfo,
        onLongClickListener: OnLongClickListener?,
    ) {
        binding.root.setOnLongClickListener {
            onLongClickListener?.onLongClick(cardInfo)
            true
        }

        binding.apply {
            lengthLL.isVisible = cardInfo.length != null
            luhnLL.isVisible = cardInfo.luhn != null
            schemeLL.isVisible = cardInfo.scheme != null
            typeLL.isVisible = cardInfo.type != null
            brandLL.isVisible = cardInfo.brand != null
            prepaidLL.isVisible = cardInfo.prepaid != null
            countryNameLL.isVisible = cardInfo.countryName != null
            countryNumericLL.isVisible = cardInfo.numeric != null
            countryAlpha2LL.isVisible = cardInfo.alpha2 != null
            countryEmojiLL.isVisible = cardInfo.emoji != null
            countryCurrencyLL.isVisible = cardInfo.currency != null
            countryLatitudeLL.isVisible = cardInfo.latitude != null
            countrylongitudeLL.isVisible = cardInfo.longitude != null
            bankNameLL.isVisible = cardInfo.bankName != null
            bankUrlLL.isVisible = cardInfo.url != null
            bankPhoneLL.isVisible = cardInfo.phone != null
            bankCityLL.isVisible = cardInfo.city != null
        }
        setData(cardInfo)

    }

    fun setData(data: CardInfo) {
        binding.apply {
            cardNumberTv.text = data.number
            lengthTv.text = data.length.toString()
            luhnTv.text = data.luhn.toString()
            schemeTv.text = data.scheme
            typeTv.text = data.type
            brandTv.text = data.brand
            prepaidTv.text = data.prepaid.toString()
            countryNameTv.text = data.countryName
            countryNumericTv.text = data.numeric
            countryAlpha2Tv.text = data.alpha2
            countryEmojiTv.text = data.emoji
            countryCurrencyTv.text = data.currency
            countryLatitudeTv.text = data.latitude.toString()
            countryLongitudeTv.text = data.longitude.toString()
            bankNameTv.text = data.bankName
            bankUrlTv.text = data.url
            bankPhoneTv.text = data.phone
            bankCityTv.text = data.city
        }
    }


    fun interface OnLongClickListener {
        fun onLongClick(cardInfo: CardInfo)
    }
}