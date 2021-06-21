package com.example.movies2021.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies2021.R
import com.example.movies2021.data.models.Result
import kotlinx.android.synthetic.main.recyclerlistitem.view.*

class HomeRecyclerAdapter(
    private val movieList: List<Result>
) :
    RecyclerView.Adapter<HomeRecyclerAdapter.MovieViewHolder>() {

    private var itemCallback: ((Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerlistitem, parent, false)
        return MovieViewHolder(itemView, itemCallback)
    }


    fun setItemCallBack(itemCallback: (Result?) -> Unit) {
        this.itemCallback = itemCallback
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.bind(currentItem)

    }

    override fun getItemCount(): Int = movieList.size


    class MovieViewHolder(itemView: View, private val itemCallback: ((Result) -> Unit)?) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.titleTV
        var rating: TextView = itemView.ratingTV
        var image: ImageView = itemView.imageView
        var runTime: TextView = itemView.runTimeTextView

        fun bind(result: Result) {
            itemView.setOnClickListener { itemCallback?.invoke(result) }
            title.text = result.title
            rating.text = result.vote_average.toString()
            result.poster_path.let { image.load(it) }
            runTime.text = result.vote_count.toString()

        }

        fun ImageView.load(url: String) {
            Glide.with(context)
                .load(url)
                .into(this)
        }

    }

}


