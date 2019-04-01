package launcher.vutien.trung.dadjokes.entity
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Employee(
        @PrimaryKey @ColumnInfo(name = "employee_id") @SerializedName("id") var id : Int,
        @ColumnInfo(name="employee_name") @SerializedName("first_name") var firstName : String,
        @ColumnInfo(name="employee_salary") @SerializedName("last_name") var lastName : String
//        @ColumnInfo(name="employee_age") @SerializedName("employee_age") var age : Int,
//        @ColumnInfo(name="profile_img") @SerializedName("profile_image") var avatar : String
)