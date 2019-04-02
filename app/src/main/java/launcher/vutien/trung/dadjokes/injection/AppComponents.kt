package launcher.vutien.trung.dadjokes.injection

import dagger.Component
import launcher.vutien.trung.dadjokes.injection.modules.AppModule
import launcher.vutien.trung.dadjokes.injection.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AppModule::class),
    (NetworkModule::class)
])
interface AppComponents{
    
}