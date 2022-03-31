package com.ebookfrenzy.navigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ebookfrenzy.navigationdemo.R
import com.ebookfrenzy.navigationdemo.databinding.MainFragmentBinding
import androidx.navigation.Navigation
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding:MainFragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.main_fragment, container, false)
        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onDestroyView(){
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.button.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainToSecond,null))
            //Navigation.findNavController(it).navigate(R.id.mainToSecond)
        }
        // TODO: Use the ViewModel
    }

