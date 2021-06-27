package com.example.movies2021.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.movies2021.R
import com.example.movies2021.data.models.Result
import com.example.movies2021.utils.extensions.load
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.homerecyclerlistitem.*

class HomeRecyclerAdapter(
    private val movieList: List<Result>
) :
    RecyclerView.Adapter<HomeRecyclerAdapter.MovieViewHolder>() {

    private var itemCallback: ((Result) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.homerecyclerlistitem, parent, false)
        return MovieViewHolder(itemView, itemCallback)
    }

//    fun setItemCallBack(itemCallback: (Result?) -> Unit) {
//        this.itemCallback = itemCallback
//    }
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = movieList[position]
        holder.bind(currentItem)
        holder.titleTV.text = currentItem.title
        holder.ratingTV.text = currentItem.vote_average.toString()
        holder.originalTitle.text = currentItem.original_title
        currentItem.poster_path.let { holder.imageView.load(it) }
        holder.runTimeTextView.text = currentItem.vote_count.toString()
    }

    override fun getItemCount(): Int = movieList.size

    class MovieViewHolder(
        override val containerView: View,
        private val itemCallback: ((Result) -> Unit)?
    ) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(result: Result) {
            containerView.setOnClickListener { itemCallback?.invoke(result) }
        }
    }
}


