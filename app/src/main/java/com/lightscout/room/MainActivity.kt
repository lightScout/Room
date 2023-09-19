package com.lightscout.room

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.lightscout.room.model.cache.AppDatabase
import com.lightscout.room.model.entity.Driver
import com.lightscout.room.model.entity.Drivers
import com.lightscout.room.model.entity.Route

import com.lightscout.room.ui.theme.RoomTheme

class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "app_database"
        ).allowMainThreadQueries().build()

        val dao = db.rootDao()
        dao.insertAllDrivers(
            Drivers(
                1, "John"
            )
        )
        dao.getAllDrivers().forEach {
            Log.d("TAG_JJ", "onCreate: $it ")
        }

        setContent {
            RoomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RoomTheme {
        Greeting("Android")
    }
}