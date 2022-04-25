package com.ebookfrenzy.contactdemo
import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts:LiveData<List<Contact>>?


    init{
        val db:ContactRoomDatabase?= ContactRoomDatabase.getDatabase(application)
        contactDao=db?.ContactDao()
        allContacts = contactDao?.getAllContacts()

    }


    fun insertContact(newcontact:Contact) {
        coroutineScope.launch(Dispatchers.IO){
            asyncInsert(newcontact)
        }
    }
    private suspend fun asyncInsert(contact: Contact){
        contactDao?.insertContact(contact)
    }


    fun deleteContact(id: Int){
        coroutineScope.launch(Dispatchers.IO){
            asyncDelete(id)
        }
    }
    private suspend fun asyncDelete(id:Int){
        contactDao?.deleteContact(id )
    }


    fun findContact(name:String){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value=asyncFind(name).await()

        }
    }
    private suspend fun asyncFind(name:String):
            Deferred<List<Contact>?> =
                coroutineScope.async(Dispatchers.IO){
                    return@async contactDao?.findContact(name)
                }





    fun getAllASC(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value =ascSort().await()
        }
    }

    private suspend fun ascSort(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getAllASC()
        }


    fun getAllDESC(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value=descSort().await()
        }
    }
    private suspend fun descSort(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getAllDESC()
        }

}
