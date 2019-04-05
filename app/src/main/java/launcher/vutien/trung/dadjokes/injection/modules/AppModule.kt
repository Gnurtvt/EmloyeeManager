package launcher.vutien.trung.dadjokes.injection.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.manager.DefaultEmployeeManager
import launcher.vutien.trung.dadjokes.manager.EmployeeManager
import launcher.vutien.trung.dadjokes.repository.AppDatabase
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl
import javax.inject.Singleton

@Module
class AppModule{

    @Provides
    fun provideContext(application: Application) : Context = application.applicationContext

    @Provides
    @Singleton
    fun provideAppDatabase(context : Context) : AppDatabase =
            AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideEmployeeRepository(appDatabase: AppDatabase) : EmployeeRepositoryImpl =
            EmployeeRepositoryImpl(appDatabase)

}