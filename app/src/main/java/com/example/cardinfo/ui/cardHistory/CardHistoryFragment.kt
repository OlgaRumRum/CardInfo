package com.example.cardinfo.ui.cardHistory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.example.binapp.ui.history.CardHistoryAdapter
import com.example.binapp.ui.history.CardHistoryState
import com.example.binapp.ui.history.CardHistoryViewHolder
import com.example.cardinfo.R
import com.example.cardinfo.databinding.FragmentCardHistoryBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.koin.androidx.viewmodel.ext.android.viewModel

class CardHistoryFragment : Fragment() {

    private var _binding: FragmentCardHistoryBinding? = null
    private val binding get() = requireNotNull(_binding) { "Binding is null" }

    private val viewModel by viewModel<CardHistoryViewModel>()

    private val historyAdapter = CardHistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCardHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardInfoRv.adapter = historyAdapter

        historyAdapter.onLongClickListener = CardHistoryViewHolder.OnLongClickListener { cardinfo ->
            MaterialAlertDialogBuilder(requireContext())
                .setTitle(requireActivity().getString(R.string.dialog_title))
                .setNegativeButton(
                    requireActivity().getString(R.string.dialog_negative)
                ) { dialog, which ->
                }
                .setPositiveButton(
                    requireActivity().getString(R.string.dialog_positive)
                ) { dialog, which ->
                    viewModel.deleteCardInfo(cardinfo)
                }
                .show()
        }

        viewModel.screenState.observe(viewLifecycleOwner) { state ->
            renderState(state)
        }

        viewModel.data.observe(viewLifecycleOwner) { history ->
            historyAdapter.submitList(history)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun renderState(state: CardHistoryState) {
        binding.cardInfoRv.isVisible = state is CardHistoryState.Content
        binding.emptyTv.isVisible = state is CardHistoryState.Empty
    }
}
