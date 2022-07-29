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
class PaparazziTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = PIXEL_5
    )

    @Test
    fun pixel5() {
        val launch = paparazzi.inflate<LinearLayout>(R.layout.activity_paparazzi)
        paparazzi.snapshot(launch)
    }

    @Test
    fun pixel5_differentThemes() {
        paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light")
        var launch = paparazzi.inflate<LinearLayout>(R.layout.activity_paparazzi)
        paparazzi.snapshot(view = launch, name = "light")

        paparazzi.unsafeUpdateConfig(theme = "android:Theme.Material.Light.NoActionBar")
        launch = paparazzi.inflate(R.layout.activity_paparazzi)
        paparazzi.snapshot(view = launch, name = "light no_action_bar")
    }

    @Test
    fun nexus5_differentOrientations() {
        paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5)
        var launch = paparazzi.inflate<LinearLayout>(R.layout.activity_paparazzi)
        paparazzi.snapshot(view = launch, name = "portrait")

        paparazzi.unsafeUpdateConfig(deviceConfig = NEXUS_5_LAND)
        launch = paparazzi.inflate(R.layout.activity_paparazzi)
        paparazzi.snapshot(view = launch, name = "landscape")
    }
}
