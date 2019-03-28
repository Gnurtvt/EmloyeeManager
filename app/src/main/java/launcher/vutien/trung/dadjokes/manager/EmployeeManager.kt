package launcher.vutien.trung.dadjokes.manager

import launcher.vutien.trung.dadjokes.entity.Employee
import io.reactivex.Observable

interface EmployeeManager{
    fun getEmployee() : Observable<List<Employee>>
}