package com.apriquelme.dogs.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apriquelme.dogs.adapters.RaceRowAdapterList
import com.apriquelme.dogs.databinding.FragmentRaceListBinding
import com.apriquelme.dogs.ui.viewmodel.RaceViewModel

class RaceListFragment : Fragment() {

    private lateinit var binding: FragmentRaceListBinding
    private val adapter: RaceRowAdapterList = RaceRowAdapterList()
    private val raceViewModel: RaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        raceViewModel.onCreate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentRaceListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpObserver()
    }

    private fun setUpRecyclerView() {
        binding.lvData.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setUpObserver() {
        raceViewModel.raceModel.observe(viewLifecycleOwner, Observer { raceList ->
            adapter.adapterList(
                raceList,
                context = requireContext(),
            )
            binding.lvData.adapter = adapter
        })

        raceViewModel.isLoading.observe(viewLifecycleOwner, Observer {
            binding.loading.isVisible = it
        })
    }

}