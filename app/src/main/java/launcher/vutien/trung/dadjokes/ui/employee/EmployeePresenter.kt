package launcher.vutien.trung.dadjokes.ui.employee

import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.manager.EmployeeManager
import launcher.vutien.trung.dadjokes.ui.BaseMvpPresenter

class EmployeePresenter(private val empMgr : EmployeeManager)
    : BaseMvpPresenter<EmployeeContract.View>(),
        EmployeeContract.UserActionListener{

    companion object {
        val TAG : String = "Presenter"
    }
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun loadEmployee() {
        Log.i(TAG,"loadEmployee")
        compositeDisposable.add(
        empMgr.getEmployee().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { view?.onLoadingEmployee() }
            .subscribe(this::handleResponse,
            this::handleError))
    }

    private fun handleResponse(emps : List<Employee>){
        view?.onLoadedEmployee(emps)
    }

    private fun handleError(e : Throwable){
        Log.i(TAG,"handleError $e")
        view?.onLoadEmployeeError()
    }
}