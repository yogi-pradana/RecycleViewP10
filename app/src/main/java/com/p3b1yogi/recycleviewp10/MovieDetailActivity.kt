package com.p3b1yogi.recycleviewp10

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.p3b1yogi.recycleviewp10.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari Intent
        val gambar = intent.getIntExtra("movie_gambar",1)
        val title = intent.getStringExtra("movie_title")
        val genre = intent.getStringExtra("movie_genre")
        val duration = intent.getStringExtra("movie_duration")
        val rating = intent.getStringExtra("movie_rating")
        val synopsis = intent.getStringExtra("movie_synopsis")

        // Set data ke tampilan
        binding.imageMovieDetail.setImageResource(gambar)
        binding.textTitleDetail.text = title
        binding.textGenreDetail.text = genre // Tambahkan genre
        binding.textDurationDetail.text = duration // Tambahkan durasi
        binding.textRatingDetail.text = rating // Tambahkan rating
        binding.textSynopsisDetail.text = synopsis

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Movie Detail"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()  // Close the activity when back button is pressed
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}