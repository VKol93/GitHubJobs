package com.vk.githubjobs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.vk.githubjobs.dataSource.RemoteDataSource
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchButton.setOnClickListener {
            val description = descriptionEditText.text.toString()
            val location = locationEditText.text.toString()
            lifecycleScope.launch {
                val jobPosts = RemoteDataSource.retrofitService.getJobPosts(description, location)
                Log.d("myLog", jobPosts.toString())
            }
        }

    }

}