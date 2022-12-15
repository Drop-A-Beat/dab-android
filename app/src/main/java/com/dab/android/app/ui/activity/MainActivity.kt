package com.dab.android.app.ui.activity

import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.dab.android.app.ui.DabApp
import com.dab.android.core.data.util.NetworkMonitor
import com.dab.android.core.designsystem.theme.DabTheme
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
        hideSystemUI()
    }

    @Suppress("DEPRECATION")
    private fun hideSystemUI() {
        WindowCompat.setDecorFitsSystemWindows(window, false)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        } else {
            window.insetsController?.apply {
                systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        }
    }
}