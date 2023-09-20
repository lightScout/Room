package com.lightscout.room

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.lightscout.room.model.cache.AppDatabase
import com.lightscout.room.model.entity.Entity
import com.lightscout.room.ui.theme.RoomTheme
import com.lightscout.room.viewmodel.LaunchViewModel
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var db: AppDatabase
    private lateinit var viewMode: LaunchViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = AppDatabase.getInstance(this)
        viewMode = LaunchViewModel(db)
        viewMode.getAllLaunch()

        lifecycleScope.launch {
            viewMode.dataFlow.collect {
                setContent {
                    RoomTheme {
                        // A surface container using the 'background' color from the theme
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            LaunchList(it)
                        }
                    }
                }
            }
        }


    }
}

@Composable
fun LaunchList(list: List<Entity>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(content = {
            items(list.size) { index ->
                Card(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = list[index].missionName,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }

            }
        })
    }
}
