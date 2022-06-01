package com.example.diffutil

import androidx.recyclerview.widget.DiffUtil

class MyDiffUtil(
    private val oldList: List<DataModel>,
    private val newList: List<DataModel>
): DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].areSame(newList[newItemPosition])
    }
}