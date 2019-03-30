package launcher.vutien.trung.dadjokes.repository

import io.reactivex.Observable
import launcher.vutien.trung.dadjokes.entity.Employee

class EmployeeRepositoryImpl(private val db : AppDatabase) : EmployeeRepository{
    override fun insertMany(emps: List<Employee>) {
        db.employeeDao().insertMany(emps)
    }

    override fun insertEmp(emp: Employee) {
        db.employeeDao().insertEmployee(emp)
    }

    override fun getEmployee(): Observable<List<Employee>> {
        return db.employeeDao().getAll().toObservable()
    }
}