package com.p3b1yogi.recycleviewp10

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.p3b1yogi.recycleviewp10.databinding.ItemMovieBinding

class MovieAdapter (
    private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.imageMovie.setImageResource(movie.imageResId)
        holder.binding.textTitle.text = movie.title
        holder.binding.textDuration.text = "${movie.duration} • ${movie.rating}"


        holder.binding.root.setOnClickListener {
            val intent = Intent(context, MovieDetailActivity::class.java).apply {
                putExtra("movie_title", movie.title)
                putExtra("movie_genre", movie.genre)
                putExtra("movie_duration", movie.duration)
                putExtra("movie_rating", movie.rating)
                putExtra("movie_synopsis", movie.synopsis)
            }
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = movies.size
}