package com.ebookfrenzy.contactdemo.ui.main

import android.os.Build.VERSION_CODES.O
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ebookfrenzy.contactdemo.Contact
import com.ebookfrenzy.contactdemo.R


class ContactListAdapter(private val contactItemLayout: Int): RecyclerView.Adapter<ContactListAdapter.ViewHolder>() {
    private var contactList: List<Contact>? = null

    var listener: onItemClickListener? = null

  interface onItemClickListener {
      fun onClick(str: String)
  }


    fun settingListener(listener: onItemClickListener?) {
        this.listener = listener
    }


    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {



        val name = holder.name
        val phone = holder.phone
        var trashCan = holder.trashCan
        val contactId = holder.id

        contactList.let { name.text=it!![listPosition].contactName
            phone.text=it!![listPosition].phoneNumber
            contactId.text= it!![listPosition].id.toString()


        }
        trashCan.setOnClickListener(View.OnClickListener {
            var id = contactId.text.toString()
            listener?.onClick(id)
            Log.i("zzz","contactListAdapter " + id)
            Log.i("zzz", contactId.text.toString())

        })


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

    }




}