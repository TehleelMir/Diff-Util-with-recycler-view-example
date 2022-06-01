package com.example.diffutil

data class DataModel(
    val id: Int,
    val name: String,
    val age: Int
) {
    fun areSame(obj2: DataModel): Boolean {
        return (id == obj2.id && name == obj2.name && age == obj2.age)
    }
}