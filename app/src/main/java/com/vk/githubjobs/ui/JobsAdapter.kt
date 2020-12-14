package com.vk.githubjobs.ui

import com.vk.githubjobs.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.vk.githubjobs.model.JobPost
import kotlinx.android.synthetic.main.job_post_item.view.*

class JobPostsAdapter(val jobPosts: List<JobPost>): RecyclerView.Adapter<JobPostViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobPostViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.job_post_item, parent, false)
        val viewHolder = JobPostViewHolder(itemView)
        return viewHolder
    }
    override fun onBindViewHolder(holder: JobPostViewHolder, position: Int) {
        //val JobPost = JobPost[position]
        //holder.bind(JobPost)
        holder.bind(jobPosts[position])
    }
    override fun getItemCount(): Int = jobPosts.size
}

class JobPostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bind(jobPost: JobPost) {
        itemView.title_view.setText(jobPost.title)
        itemView.company_view.setText(jobPost.company)
        itemView.location_view.setText(jobPost.location)
        itemView.applyButton.setOnClickListener {
            Toast.makeText(itemView.context, "Application submitted", Toast.LENGTH_LONG).show()
        }

        /*itemView.JobPost_name_textView.text = JobPostData.name
        Picasso.with(itemView.context)
            .load(JobPostData.info.flag)
            .into(itemView.JobPost_flag_imageView)*/
    }

}
