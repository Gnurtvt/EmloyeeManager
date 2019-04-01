package launcher.vutien.trung.dadjokes.api

import io.reactivex.Observable
import launcher.vutien.trung.dadjokes.entity.Employee
import retrofit2.http.GET

interface ClientApi {

    @GET("users")
    fun getEmployees() : Observable<List<Employee>>

}