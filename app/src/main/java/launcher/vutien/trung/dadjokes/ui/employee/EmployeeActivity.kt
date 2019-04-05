package launcher.vutien.trung.dadjokes.ui.employee

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_employee.*
import launcher.vutien.trung.dadjokes.R
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.application.DadJokeApp
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.manager.DefaultEmployeeManager
import launcher.vutien.trung.dadjokes.repository.AppDatabase
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl
import launcher.vutien.trung.dadjokes.ui.BaseMvpActivity
import launcher.vutien.trung.dadjokes.ui.adapter.EmployeeAdapter
import javax.inject.Inject

class EmployeeActivity : BaseMvpActivity<EmployeeContract.View,EmployeeContract.UserActionListener>()
,EmployeeContract.View{

    @Inject
    lateinit var clientApi: ClientApi

    @Inject
    lateinit var repositoryImpl: EmployeeRepositoryImpl

    lateinit var employeeManager: DefaultEmployeeManager

    companion object {
        val TAG : String = "Acitivty"
    }

    override fun onLoadedEmployee(emps: List<Employee>) {
        Log.i(TAG,"Size : " + emps.size)
        rv_list_employee.adapter = EmployeeAdapter(emps,this)
    }

    override fun onLoadingEmployee() {
        Log.i(TAG,"onLoadingEmployee")

    }

    override fun onLoadEmployeeError() {
        Log.i(TAG,"onLoadEmployeeError")
    }

    override fun createPresenter(): EmployeeContract.UserActionListener {

        Log.i(TAG,"createPresenter")
        DadJokeApp.appComponent.inject(this)
        employeeManager = DefaultEmployeeManager(repositoryImpl,clientApi)

        return EmployeePresenter(employeeManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee)

        Log.i(TAG,"onCreate")

        rv_list_employee.layoutManager = LinearLayoutManager(this)

        presenter.loadEmployee()

    }
}