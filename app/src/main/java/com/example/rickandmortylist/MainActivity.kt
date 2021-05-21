package com.example.rickandmortylist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rickandmortylist.adapter.CharacterAdapter
import com.example.rickandmortylist.databinding.ActivityMainBinding
import com.example.rickandmortylist.model.MyCharacter
import com.example.rickandmortylist.services.CharacterService
import com.example.rickandmortylist.services.ServiceBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.recyclerView
         loadCharacters()




    }

    private fun loadCharacters() {
        //initiate the service
        val destinationService  = ServiceBuilder.buildService(CharacterService::class.java)
        val requestCall =destinationService.getCharacterList()
        requestCall.enqueue(object: Callback<MyCharacter>{
            override fun onResponse(call: Call<MyCharacter>, response: Response<MyCharacter>) {
                if(response.isSuccessful){
                    val charactersObject = response.body()!!
                    val charactersList = charactersObject.results
                    Log.d("Response", "characterList size : ${charactersList.size}")
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = CharacterAdapter(charactersList)
                    }


                }
                else{
                   Log.d("MainActivity", "Error message: ${response.errorBody().toString()}")
                }
            }

            override fun onFailure(call: Call<MyCharacter>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Retrieving data from api failed ", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity", "Error message: ${t.message}")
            }
        })
    }
}

private fun <T> Call<T>.enqueue(callback: Callback<List<T>>) {

}
