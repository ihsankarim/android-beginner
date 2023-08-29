@file:Suppress("DEPRECATION")

package com.example.mypopulartours

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.mypopulartours.databinding.ActivityDetailToursBinding
import android.widget.*

class DetailToursActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_TOUR = "extra_tour"
    }

    private lateinit var binding: ActivityDetailToursBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailToursBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Detail Popular Tour"

        val tour = intent.getParcelableExtra<Tour>(EXTRA_TOUR)
        if (tour != null){
            binding.imgDetailPhoto.setImageResource(tour.photo)
            binding.tvDetailName.text = tour.name
            binding.tvDetailDescription.text = tour.description
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            R.id.action_share -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Bagikan Rekomendasi Wisata ini kepada teman anda")
                startActivity(Intent.createChooser(intent, "Bagikan melalui"))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}