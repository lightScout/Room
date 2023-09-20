package com.lightscout.room.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lightscout.room.model.cache.AppDatabase
import com.lightscout.room.model.entity.Entity
import com.lightscout.room.model.network.API
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class LaunchViewModel(val database: AppDatabase) : ViewModel() {
    private val api = API()

    private val flow = MutableSharedFlow<List<Entity>>()
    val dataFlow: SharedFlow<List<Entity>> = flow
    fun getAllLaunch(forceReload: Boolean = false) {
        viewModelScope.launch(Dispatchers.IO) {
            val cachedLaunches = database.rocketLaunchDao().getAllLaunch()
            if (cachedLaunches.isNotEmpty() && !forceReload)
                flow.emit(cachedLaunches)
            else {
                database.rocketLaunchDao().deleteLaunch()
                api.getAllLaunch().let {
                    it.forEachIndexed { index, rocketLaunch ->
                        database.rocketLaunchDao().insertLaunch(
                            Entity(
                                index,
                                rocketLaunch.missionName,
                                rocketLaunch.launchDateUTC,
                                rocketLaunch.details,
                                rocketLaunch.launchSuccess,
                                rocketLaunch.links.toString()
                            )
                        )
                    }
                }
                flow.emit(database.rocketLaunchDao().getAllLaunch())
            }
        }
    }
}