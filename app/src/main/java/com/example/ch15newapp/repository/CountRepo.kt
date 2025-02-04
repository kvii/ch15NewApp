package com.example.ch15newapp.repository

import android.content.ContentValues
import com.example.ch15newapp.database.AppDB

class CountRepo(private val db: AppDB) {
    fun saveCount(count: Int) {
        db.writableDatabase.update(
            "table1",
            ContentValues().apply { put("value", count) },
            "id = ?",
            arrayOf("1")
        )
    }

    fun getCount(): Int = db.readableDatabase.query(
        "table1",
        arrayOf("value"),
        "id = ?",
        arrayOf("1"),
        null,
        null,
        null
    ).use {
        if (it.moveToFirst()) {
            val idx = it.getColumnIndex("value")
            it.getInt(idx)
        } else {
            0 // 数据不可能不存在
        }
    }
}