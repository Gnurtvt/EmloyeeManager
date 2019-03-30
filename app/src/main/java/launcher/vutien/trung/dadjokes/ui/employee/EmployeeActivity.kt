package launcher.vutien.trung.dadjokes.ui.employee

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_employee.*
import launcher.vutien.trung.dadjokes.R
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.manager.DefaultEmployeeManager
import launcher.vutien.trung.dadjokes.repository.AppDatabase
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl
import launcher.vutien.trung.dadjokes.ui.BaseMvpActivity
import launcher.vutien.trung.dadjokes.ui.adapter.EmployeeAdapter
import launcher.vutien.trung.dadjokes.utils.Constants
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EmployeeActivity : BaseMvpActivity<EmployeeContract.View,EmployeeContract.UserActionListener>()
,EmployeeContract.View{
    companion object {
        val TAG : String = "Acitivty"
    }

    override fun onLoadedEmployee(emps: List<Employee>) {
        rv_list_employee.adapter = EmployeeAdapter(emps,this)
    }

    override fun onLoadingEmployee() {
        Log.i(TAG,"onLoadingEmployee")

    }

    override fun onLoadEmployeeError() {
        Log.i(TAG,"onLoadEmployeeError")
    }

    override fun createPresenter(): EmployeeContract.UserActionListener {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val api = retrofit.create(ClientApi::class.java)
        val repositoryImpl = EmployeeRepositoryImpl(AppDatabase.getInstance(this)!!)
        val employeemanager  = DefaultEmployeeManager(repositoryImpl,api)
        return EmployeePresenter(employeemanager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)
        Log.i(TAG,"onCreate")

        rv_list_employee.layoutManager = LinearLayoutManager(this)

        load_emp_btn.setOnClickListener {
            presenter.loadEmployee()
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.loadEmployee()
    }
}