package com.example.lokal_demo

import android.app.Application
import com.example.lokal_demo.data.Graph

class LokalApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}