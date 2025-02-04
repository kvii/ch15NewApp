package com.example.ch15newapp

import android.app.Application
import com.example.ch15newapp.database.AppDB
import com.example.ch15newapp.repository.CountRepo

class App: Application() {
    private val db: AppDB by lazy { AppDB(this) }
    val countRepo by lazy { CountRepo(db) }
}