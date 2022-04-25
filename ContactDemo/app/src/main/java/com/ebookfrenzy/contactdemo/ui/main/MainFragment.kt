package com.ebookfrenzy.contactdemo.ui.main


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer

import com.ebookfrenzy.contactdemo.Contact
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ebookfrenzy.contactdemo.R

import java.util.*
import com.ebookfrenzy.contactdemo.databinding.MainFragmentBinding
import java.lang.Integer.parseInt

class MainFragment : Fragment() {
    private var adapter: ContactListAdapter?= null

    companion object {
        fun newInstance() = MainFragment()
    }


    val viewModel:MainViewModel by viewModels()
    private var _binding:MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = MainFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listenerSetup()
        observerSetup()
        recyclerSetup()
        // TODO: Use the ViewModel
        adapter!!.settingListener(object: ContactListAdapter.onItemClickListener{
            override fun onClick(id: String) {
                var contactId: Int = parseInt(id)
               // Log.i("zzz", "mainfrag " + id)
                viewModel.deleteContact(contactId)
            }
        })
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_card_layout)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }

    private fun observerSetup(){
        viewModel.getAllContacts()?.observe(viewLifecycleOwner,{ contacts ->
            contacts?.let{adapter?.setContactList(it)} })

        viewModel.getSearchResults().observe(viewLifecycleOwner,{contacts -> contacts?.let{
            if(it.isNotEmpty()) {
                adapter?.setContactList(it)
            }
            else{
                Toast.makeText(context,"Name must be in Contacts", Toast.LENGTH_SHORT).show()

            }
        }})


    }
    private fun listenerSetup(){
        binding.addButton.setOnClickListener { val name = binding.contactName.text.toString()
        val phoneNumber = binding.phoneNumber.text.toString()


        if (name !="" && phoneNumber!=""){
            val contact = Contact(name, phoneNumber)
            viewModel.insertContact(contact)
            clearFields()
        }
            else{
                Toast.makeText(context,"You must have a name and Phone Number",Toast.LENGTH_SHORT).show()
        }
       }
        binding.findButton.setOnClickListener { val name = binding.contactName.text.toString()
            if(name !="") {
                viewModel.findContact(binding.contactName.text.toString())

            }

            else {
                Toast.makeText(context,"You must enter a search criteria in the name field",Toast.LENGTH_SHORT).show()
            }

        }
        binding.ascButton.setOnClickListener { viewModel.getAllContactsASC()}

        binding.descButton.setOnClickListener { viewModel.getAllContactsDESC()}



    }
    private fun clearFields(){
        binding.contactName.setText("")
        binding.phoneNumber.setText("")
    }

}