package launcher.vutien.trung.dadjokes.manager

import io.reactivex.Observable
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.repository.EmployeeRepository

class DefaultEmployeeManager(
    private val repository: EmployeeRepository,
    private val api: ClientApi
) : EmployeeManager {

    override fun getEmployee(): Observable<List<Employee>> =
        Observable.mergeDelayError(
            getFromDb(),
            getFromApi()
        )

    private fun getFromApi(): Observable<List<Employee>> =
        api.getEmployees().doOnNext(this::saveEmpsToDb)

    private fun getFromDb(): Observable<List<Employee>> =
        repository.getEmployee()

    private fun saveEmpsToDb(emps: List<Employee>) {
        if (emps.isNotEmpty())
            repository.insertMany(emps)
    }
}