package com.apriquelme.dogs.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.apriquelme.dogs.adapters.ImageRowAdapterList
import com.apriquelme.dogs.databinding.FragmentRaceDetailBinding
import com.apriquelme.dogs.ui.viewmodel.RaceViewModel

class RaceDetailFragment : Fragment() {

    private var race: String = ""

    private var _binding: FragmentRaceDetailBinding? = null
    private val binding get() = _binding!!

    private val adapter: ImageRowAdapterList = ImageRowAdapterList()
    private val raceViewModel: RaceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        race = requireArguments().getString("race", "")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentRaceDetailBinding.inflate(inflater, container, false)
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
        raceViewModel.getImagesByRace(race)
        raceViewModel.raceImageModel.observe(viewLifecycleOwner, Observer { images ->
            adapter.adapterList(
                images,
                context = requireContext(),
            )
            binding.lvData.adapter = adapter
        })
    }
}