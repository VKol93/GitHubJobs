package com.vk.githubjobs

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.vk.githubjobs.dataSource.RemoteDataSource
import com.vk.githubjobs.ui.JobPostsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.job_post_item.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val job1 = sharedPref.getString("description", null)
        val jobLocation1 = sharedPref.getString("location", null)

        descriptionEditText.setText(job1)
        locationEditText.setText(jobLocation1)

        searchButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val location = locationEditText.text.toString()
            lifecycleScope.launch {
                val jobPosts = RemoteDataSource.retrofitService.getJobPosts(description, location)
                Log.d("myLog", jobPosts.toString())
                val jobsAdapter = JobPostsAdapter(jobPosts)
                recyclerViewJobs.adapter = jobsAdapter
            }

            val editor = sharedPref.edit()

            val savePref = checkbox.isChecked
            if (savePref)
                editor.apply {
                    putString("description", description)
                    putString("location", location)
                    apply()
                }


        }

        //recyclerViewJobs.layoutManager = LinearLayoutManager(this)


    }
}

