@file:Suppress("DEPRECATION")

package com.ebookfrenzy.lifecycledemo.ui.main
import androidx.databinding.DataBindingUtil
import com.ebookfrenzy.lifecycledemo.R
import com.ebookfrenzy.lifecycledemo.BR.myViewModel
import com.ebookfrenzy.lifecycledemo.DemoObserver
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ebookfrenzy.lifecycledemo.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.main_fragment,container, false)
        binding.lifecycleOwner = this
       return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.setVariable(myViewModel, viewModel)
        lifecycle.addObserver(DemoObserver())

    }

}