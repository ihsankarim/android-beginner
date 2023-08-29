package com.example.mypopulartours

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypopulartours.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var rvTour: RecyclerView
    private val list = ArrayList<Tour>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list.addAll(getListTour())
        showRecyclerList()
    }


    private fun getListTour(): ArrayList<Tour> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listTour = ArrayList<Tour>()
        for (i in dataName.indices) {
            val tour = Tour(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listTour.add(tour)
        }
        return listTour
    }

    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvTour.layoutManager = layoutManager
        val listTourAdapter = ListTourAdapter(list) { tour ->
            val moveIntentDetail = Intent(this, DetailToursActivity:: class.java)
            moveIntentDetail.putExtra(DetailToursActivity.EXTRA_TOUR, tour)
            startActivity(moveIntentDetail)
        }
        binding.rvTour.adapter = listTourAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}