package launcher.vutien.trung.dadjokes.manager

import io.reactivex.Observable
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl

class DefaultEmployeeManager(private val repository : EmployeeRepositoryImpl,
                            private val api : ClientApi) : EmployeeManager{

    private val shouldUpdate : Boolean
        get() {
            return false
        }

    override fun getEmployee(): Observable<List<Employee>> =
        when{
            shouldUpdate -> getFromApi()
            else -> {
                Observable.concat(
                        getFromApi(),
                        getFromDb()
                )
            }
        }


    private fun getFromApi() : Observable<List<Employee>> =
            api.getEmployees()

    private fun getFromDb() : Observable<List<Employee>> =
            repository.getEmployee()

}