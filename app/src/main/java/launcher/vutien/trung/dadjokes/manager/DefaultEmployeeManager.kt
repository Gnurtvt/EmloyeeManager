package launcher.vutien.trung.dadjokes.manager

import android.util.Log
import io.reactivex.Observable
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl

class DefaultEmployeeManager(
    private val repository: EmployeeRepositoryImpl,
    private val api: ClientApi
) : EmployeeManager {

    override fun getEmployee(): Observable<List<Employee>> =
        Observable.concat(
            getFromApi(),
            getFromDb()
        )


    private fun getFromApi(): Observable<List<Employee>> =
        api.getEmployees().doOnNext(this::saveEmpsToDb)

    private fun getFromDb(): Observable<List<Employee>> =
        repository.getEmployee()

    private fun saveEmpsToDb(emps: List<Employee>) {
        if (emps.isNotEmpty())
            for (emp in emps) {
                Log.i("DATABASE", emp.toString())
                repository.insertEmp(emp)
            }
    }
}