package com.example.youtubeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeapp.databinding.VideoItemBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer

class RecyclerViewAdapter(val videoList: List<Video>,val player: YouTubePlayer):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(val binding: VideoItemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            VideoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val video = videoList[position]

        holder.binding.apply {
            videoButton.text = video.title
            videoButton.setOnClickListener {
                player.loadVideo(video.id,0f)
            }
        }
    }

    override fun getItemCount(): Int {
        return videoList.size
    }
}