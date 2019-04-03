package launcher.vutien.trung.dadjokes.repository
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.entity.EmployeeDao
import kotlin.jvm.java

@Database(entities = [
Employee::class
], version = 1
,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){
    abstract fun employeeDao() : EmployeeDao

    companion object {

        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "employee-db")
                    .allowMainThreadQueries()
                    .build()
            }
            return instance!!
        }

        fun destroyInstance() {
            instance = null
        }
    }
}