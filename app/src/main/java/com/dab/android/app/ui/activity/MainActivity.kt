package com.dab.android.app.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import com.dab.android.app.ui.DabApp
import com.dab.android.core.data.util.NetworkMonitor
import com.dab.android.core.designsystem.theme.DabTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val splashScreen = installSplashScreen()
        setContent {
//            val systemUiController = rememberSystemUiController()
//            DisposableEffect(systemUiController) {
//                systemUiController.systemBarsDarkContentEnabled = true
//                onDispose {}
//            }

            DabTheme {
                DabApp(networkMonitor)
            }
        }
    }
}