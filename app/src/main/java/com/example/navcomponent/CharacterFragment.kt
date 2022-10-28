package com.example.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.navcomponent.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    lateinit var adapter: CharacterAdapter
    lateinit var list: ArrayList<Character>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        adapter = CharacterAdapter(list, this::onClick)
        binding.recyclerView.adapter = adapter

    }

    fun onClick(pos: Int) {
        val bundle = Bundle()
        bundle.putSerializable("character", list[pos])
        findNavController().navigate(R.id.profileFragment,bundle)
    }

    private fun loadData() {
        list = ArrayList()
        list.add(Character(R.drawable._image1, "Rick Sanchez"))
        list.add(Character(R.drawable._image_2, "Morty Smith"))
        list.add(Character(R.drawable._image_3, "Albert Einstein"))
        list.add(Character(R.drawable._image_4, "Jerry Smith"))
    }
}