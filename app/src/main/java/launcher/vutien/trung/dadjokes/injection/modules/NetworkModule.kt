package launcher.vutien.trung.dadjokes.injection.modules

import dagger.Module
import dagger.Provides
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule{
    @Provides
    @Singleton
    fun provideOkHttp() : OkHttpClient =
            OkHttpClient().newBuilder().build()

    @Provides
    @Singleton
    fun provideRetrofitClientApi() : ClientApi =
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpClient().newBuilder().build())
                .build().create(ClientApi::class.java)
}