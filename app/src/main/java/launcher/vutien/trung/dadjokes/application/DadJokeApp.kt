package launcher.vutien.trung.dadjokes.application

import android.app.Application
import launcher.vutien.trung.dadjokes.injection.AppComponents
import launcher.vutien.trung.dadjokes.injection.DaggerAppComponents

class DadJokeApp : Application() {


    companion object {
        lateinit var appComponent: AppComponents
            private set
    }

    override fun onCreate() {
        super.onCreate()

        println("onCreate Application")

        appComponent = DaggerAppComponents.builder()
            .application(this)
            .build()
        appComponent.inject(this)
    }
}