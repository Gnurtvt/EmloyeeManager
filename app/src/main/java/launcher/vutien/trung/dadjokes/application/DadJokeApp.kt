package launcher.vutien.trung.dadjokes.application

import android.app.Application

class DadJokeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        println("onCreate Application")
    }
}