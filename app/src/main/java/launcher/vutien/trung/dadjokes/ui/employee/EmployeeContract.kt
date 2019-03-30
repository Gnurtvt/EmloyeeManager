package launcher.vutien.trung.dadjokes.ui.employee

import com.hannesdorfmann.mosby.mvp.MvpPresenter
import launcher.vutien.trung.dadjokes.entity.Employee
import launcher.vutien.trung.dadjokes.ui.BaseMvpView

interface EmployeeContract {
    interface View : BaseMvpView {
        fun onLoadedEmployee(emps: List<Employee>)
        fun onLoadingEmployee()
        fun onLoadEmployeeError()
    }

    interface UserActionListener : MvpPresenter<View> {
        fun loadEmployee()
    }
}