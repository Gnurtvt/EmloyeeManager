package launcher.vutien.trung.dadjokes.application

import android.app.Application
import android.util.Log
import launcher.vutien.trung.dadjokes.injection.AppComponents
import launcher.vutien.trung.dadjokes.injection.DaggerAppComponents

class DadJokeApp : Application() {

    companion object {
        const val TAG : String = "Application"

        lateinit var appComponent: AppComponents
            private set

    }


    override fun onCreate() {
        super.onCreate()

        Log.i(TAG,"onCreate Application")

        appComponent = DaggerAppComponents.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }
}