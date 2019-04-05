package launcher.vutien.trung.dadjokes.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import launcher.vutien.trung.dadjokes.application.DadJokeApp
import launcher.vutien.trung.dadjokes.injection.modules.AppModule
import launcher.vutien.trung.dadjokes.injection.modules.NetworkModule
import launcher.vutien.trung.dadjokes.ui.employee.EmployeeActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class)
])
interface AppComponents{
        @Component.Builder
        interface Builder{
            @BindsInstance
            fun application(application: Application) : Builder

            fun build() : AppComponents
        }

    fun inject(application : DadJokeApp)

    fun inject(application: EmployeeActivity)

    fun context(): Context
}