package com.example.diffutil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.ItemRecyclerViewBinding

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var list = emptyList<DataModel>()

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemRecyclerViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view, parent, false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            id.text     = list[position].id.toString()
            age.text    = list[position].age.toString()
            name.text   = list[position].name
        }
    }

    override fun getItemCount() = list.size

    fun setData(newList: List<DataModel>) {
        val diffUtil = MyDiffUtil(list, newList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        list = newList
        diffResult.dispatchUpdatesTo(this)
    }
}