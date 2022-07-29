package com.beok.paparazzi

import android.widget.LinearLayout
import app.cash.paparazzi.DeviceConfig.Companion.NEXUS_5
import app.cash.paparazzi.DeviceConfig.Companion.NEXUS_5_LAND
import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class PaparazziComposeTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5
    )

    @Test
    fun pixel5() {
        paparazzi.snapshot {
            Greeting(name = "Compose")
        }
    }

    @Test
    fun pixel5_differentThemes() {
        paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light")
        paparazzi.snapshot(name = "light") {
            Greeting(name = "Compose")
        }

        paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light.NoActionBar")
        paparazzi.snapshot(name = "light no_action_bar") {
            Greeting(name = "Compose")
        }
    }

    @Test
    fun nexus5_differentOrientations() {
        paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5)
        paparazzi.snapshot(name = "portrait") {
            Greeting(name = "Compose")
        }

        paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5_LAND)
        paparazzi.snapshot(name = "landscape") {
            Greeting(name = "Compose")
        }
    }
}
