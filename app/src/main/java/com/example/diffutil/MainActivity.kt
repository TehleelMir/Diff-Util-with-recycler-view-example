package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutil.databinding.ActivityMainBinding

/*
    Diff util is a Utility class that can calculate the difference between two lists
    and output a list of update operations that converts the first list into the second one.

    Whats wrong with the traditional notifyDataSetChanged()?
    Its fine, but when we call this method it updates the whole list even if only 1 item in the list
    was changed. And diff utils use some algorithm (Eugene W. Myers's difference algorithm) to
    calculate the minimum number of updates to convert one list into another. In simple words
    diff util will take the old list and the new list then it will compare both the lists to each other
    to find the item which have been updated and then it will update only those updated items in the list view.
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        val adapter = MyAdapter()
        val dummyDataList = listOf<DataModel>(
            DataModel(1, "jack", 24),
            DataModel(2, "jolly", 32),
            DataModel(3, "jackson", 322)
        )
        adapter.setData(dummyDataList)

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = adapter
        }

        binding.button.setOnClickListener {
            val dummyDataList2 = listOf<DataModel>(
                DataModel(3, "jackson", 322),
                DataModel(4, "jon", 322222222)
            )
            adapter.setData(dummyDataList2)
        }
    }
}