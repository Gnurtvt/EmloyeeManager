package launcher.vutien.trung.dadjokes.repository

import launcher.vutien.trung.dadjokes.entity.Employee
import io.reactivex.Observable

interface EmployeeRepository{
    fun getEmployee() : Observable<List<Employee>>
    fun insertEmp(emp : Employee)
    fun insertMany(emps : List<Employee>)
}