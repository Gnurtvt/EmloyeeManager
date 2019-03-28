package launcher.vutien.trung.dadjokes.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import launcher.vutien.trung.dadjokes.R
import launcher.vutien.trung.dadjokes.api.ClientApi
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.manager.DefaultEmployeeManager
import launcher.vutien.trung.dadjokes.repository.AppDatabase
import launcher.vutien.trung.dadjokes.repository.EmployeeRepositoryImpl
import retrofit2.Retrofit
import launcher.vutien.trung.dadjokes.utils.*
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.jvm.java

class BaseMvpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_mvp)
        loadData()
    }

    private fun loadData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val api = retrofit.create(ClientApi::class.java)
        api.getEmployees()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleRespond)

//        val repositoryImpl = EmployeeRepositoryImpl(AppDatabase.getInstance(this)!!)
//
//
//        val empMgr = DefaultEmployeeManager(repositoryImpl,api)
//
//        empMgr.getEmployee()
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(this::handleRespond)
    }

    private fun handleRespond(emps : List<Employee>){
        for(shiba in emps){
            println("Traveling : $shiba")
        }
    }
}
