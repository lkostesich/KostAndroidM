package com.ebookfrenzy.contactdemo.ui.main

import android.os.Build.VERSION_CODES.O
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ebookfrenzy.contactdemo.Contact
import com.ebookfrenzy.contactdemo.R


class ContactListAdapter(private val contactItemLayout: Int): RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        val phone = holder.phone
        val id = holder.id
        var trashCan = holder.trashCan
        contactList.let { name.text=it!![listPosition].contactName
            phone.text=it!![listPosition].phoneNumber
            id.text= it!![listPosition].id.toString()


        }
        trashCan.setOnClickListener {
           // id1 = id.text.toString()
            Log.i("zzz",id.text.toString())

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder{val view = LayoutInflater.from(parent.context).inflate(contactItemLayout,parent,false)
    return ViewHolder(view)
    }
    fun setContactList(contacts:List<Contact>){
        contactList = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (contactList==null) O else contactList!!.size
    }

    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){

        var name: TextView=itemView.findViewById(R.id.card_Name)
        var phone: TextView=itemView.findViewById(R.id.card_Phone)
        var id: TextView=itemView.findViewById(R.id.card_ID)
        var trashCan: ImageView=itemView.findViewById(R.id.image_delete)
        /*init{
            itemView.setOnClickListener { v:View ->
                Log.i("zzz", "clicked")
            }
        }*/
    }


}