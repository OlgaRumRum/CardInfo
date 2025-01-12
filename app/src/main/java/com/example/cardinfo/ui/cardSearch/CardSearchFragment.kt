package com.example.cardinfo.ui.cardSearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.cardinfo.databinding.FragmentCardSearchBinding
import com.example.cardinfo.domain.model.CardInfo
import org.koin.androidx.viewmodel.ext.android.viewModel


class CardSearchFragment : Fragment() {

    private var _binding: FragmentCardSearchBinding? = null
    private val binding get() = requireNotNull(_binding) { "Binding is null" }

    private val viewModel by viewModel<CardSearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenState.observe(viewLifecycleOwner) { state ->
            renderState(state)
        }

        binding.searchButton.setOnClickListener {
            val query = binding.SearchEt.text.toString()
            viewModel.getCardInfo(query)
        }

        binding.SearchEt.doOnTextChanged { text, _, _, _ ->
            binding.searchButton.isEnabled = text.toString().length > 5
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderState(state: CardSearchState) {

        binding.progressBar.isVisible = state is CardSearchState.Loading
        binding.lengthLL.isVisible = state is CardSearchState.Content && state.data?.length != null
        binding.luhnLL.isVisible = state is CardSearchState.Content && state.data?.luhn != null
        binding.schemeLL.isVisible = state is CardSearchState.Content && state.data?.scheme != null
        binding.typeLL.isVisible = state is CardSearchState.Content && state.data?.type != null
        binding.brandLL.isVisible = state is CardSearchState.Content && state.data?.brand != null
        binding.prepaidLL.isVisible =
            state is CardSearchState.Content && state.data?.prepaid != null
        binding.countryTitleTv.isVisible = state is CardSearchState.Content
        binding.countryNameLL.isVisible =
            state is CardSearchState.Content && state.data?.countryName != null
        binding.countryNumericLL.isVisible =
            state is CardSearchState.Content && state.data?.numeric != null
        binding.countryAlpha2LL.isVisible =
            state is CardSearchState.Content && state.data?.alpha2 != null
        binding.countryEmojiLL.isVisible =
            state is CardSearchState.Content && state.data?.emoji != null
        binding.countryCurrencyLL.isVisible =
            state is CardSearchState.Content && state.data?.currency != null
        binding.countryLatitudeLL.isVisible =
            state is CardSearchState.Content && state.data?.latitude != null
        binding.countrylongitudeLL.isVisible =
            state is CardSearchState.Content && state.data?.longitude != null
        binding.bankTitleTv.isVisible = state is CardSearchState.Content
        binding.bankNameLL.isVisible =
            state is CardSearchState.Content && state.data?.bankName != null
        binding.bankUrlLL.isVisible = state is CardSearchState.Content && state.data?.url != null
        binding.bankPhoneLL.isVisible =
            state is CardSearchState.Content && state.data?.phone != null
        binding.bankCityLL.isVisible = state is CardSearchState.Content && state.data?.city != null
        binding.progressBar.isVisible = state is CardSearchState.Loading
        binding.errorTv.isVisible = state is CardSearchState.Error
        if (state is CardSearchState.Error) {
            binding.errorTv.text = state.message
        }
        if (state is CardSearchState.Content && state.data != null) {
            setData(state.data)
        }
    }

    fun setData(data: CardInfo) {
        binding.lengthTv.text = data.length.toString()
        binding.luhnTv.text = data.luhn.toString()
        binding.schemeTv.text = data.scheme
        binding.typeTv.text = data.type
        binding.brandTv.text = data.brand
        binding.prepaidTv.text = data.prepaid.toString()
        binding.countryNameTv.text = data.countryName
        binding.countryNumericTv.text = data.numeric
        binding.countryAlpha2Tv.text = data.alpha2
        binding.countryEmojiTv.text = data.emoji
        binding.countryCurrencyTv.text = data.currency
        binding.countryLatitudeTv.text = data.latitude.toString()
        binding.countryLongitudeTv.text = data.longitude.toString()
        binding.bankNameTv.text = data.bankName
        binding.bankUrlTv.text = data.url
        binding.bankPhoneTv.text = data.phone
        binding.bankCityTv.text = data.city
    }
}