package launcher.vutien.trung.dadjokes.ui.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.employee_item.view.*
import launcher.vutien.trung.dadjokes.R
import launcher.vutien.trung.dadjokes.entity.Employee

class EmployeeAdapter(val items : List<Employee>, val context : Context) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.employee_item,p0,false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.tvEmployeeId?.text = items.get(p1).id.toString()
        p0.tvEmployeeName?.text = items.get(p1).name
        p0.tvEmployeeSalary?.text = items.get(p1).salary.toString()
        p0.container.setCardBackgroundColor(if(p1%2==0) Color.LTGRAY else Color.GRAY)
    }

}

class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val tvEmployeeId = view.tv_idEmp
    val tvEmployeeName = view.tv_nameEmp
    val tvEmployeeSalary = view.tv_salary
    val container = view.cv_container
}