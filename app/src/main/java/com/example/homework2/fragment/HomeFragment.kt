package com.example.homework2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.homework2.R
import com.example.homework2.adapter.SoccerAdapter
import com.example.homework2.data.model.Soccer
import com.example.homework2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!
    private val soccerAdapter = SoccerAdapter()
    private val safeList = mutableListOf<Soccer>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillSoccerList()
        initialize()
        goToItem()
    }

    private fun fillSoccerList() {
        safeList.apply {
            add(Soccer(R.drawable.ic_launcher_background, "Реал мадрид"))
            add(Soccer(R.drawable.ic_launcher_background, "Барселона"))
        }
    }

    private fun initialize() {
        binding.recyclerViewHome.adapter = soccerAdapter
        soccerAdapter.setSoccerList(safeList)
    }

    private fun goToItem() {
        binding.buttonHome.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addItemFragment2)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}