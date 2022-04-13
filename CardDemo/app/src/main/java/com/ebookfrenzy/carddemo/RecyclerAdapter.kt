package com.ebookfrenzy.carddemo

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup

import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter() : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    private lateinit var binding: MainActivity2
    private val data = Data()
    private val arr = MainViewModel.arr



    override fun onCreateViewHolder(viewGroup: ViewGroup, i:Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        viewHolder.itemTitle.text=data.titles[arr[i][0]]
        viewHolder.itemDetail.text=data.details[arr[i][1]]
        viewHolder.itemImage.setImageResource(data.images[arr[i][2]])

    }
    override fun getItemCount(): Int {
        return data.titles.size
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        //var itemImage: ImageView
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init {
            itemImage=itemView.findViewById(R.id.a_itemImage)


            itemTitle=itemView.findViewById(R.id.a_itemTitle)
            itemDetail=itemView.findViewById(R.id.a_itemDetail)

            itemView.setOnClickListener{v:View ->
           val i = Intent(v.getContext(),MainActivity2::class.java)
                i.putExtra("qString",itemTitle.text)
                i.putExtra("qString1",itemDetail.text)
               // i.putExtra("qString2",R.drawable.android_image_1)
               // var num = data.images[arr[adapterPosition][2]]
                i.putExtra("qString2", data.images[arr[adapterPosition][2]])
                //i.putExtra("qString2",R.id.a_itemImage.toString())

                //  i.putExtra("qString3",itemImage )
                startActivity(v.context,i,null)

                /*var position:Int = adapterPosition //<--- getAdapterPosition()
                Snackbar.make(v,"Click detected on item $position",
                Snackbar.LENGTH_LONG).setAction("Action", null).show()*/
            }
        }
    }



}