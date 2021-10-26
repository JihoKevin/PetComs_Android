package kevin.android.petcoms

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PetComsApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initStetho()

    }

    private fun initStetho() {
        Stetho.initializeWithDefaults(applicationContext)
    }
}