package com.ebookfrenzy.roomdemo
//importing to become entity and then using tags
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//variables and getter/setters
@Entity(tableName = "products")
class Product {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "productId")
    var id: Int = 0
    @ColumnInfo(name = "productName")
    var productName: String? = null
    var quantity:Int = 0

    constructor(){}

   /* constructor(id:Int,productname:String, quantity: Int){
        this.productName = productName
        this.quantity = quantity
    }*/
    constructor(productname: String,quantity: Int){
        this.productName = productname
        this.quantity = quantity
    }
}