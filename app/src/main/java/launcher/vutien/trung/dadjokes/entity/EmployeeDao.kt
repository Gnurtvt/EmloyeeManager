package launcher.vutien.trung.dadjokes.entity

import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import io.reactivex.Maybe

interface EmployeeDao{
    @Insert (onConflict = REPLACE)
    fun insertEmployee(emp : Employee)

    @Query("SELECT * FROM Employee")
    fun getAll() : Maybe<List<Employee>>

    @Insert (onConflict = REPLACE)
    fun insertMany(emps : List<Employee>)

}