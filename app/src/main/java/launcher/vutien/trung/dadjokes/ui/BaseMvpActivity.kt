package launcher.vutien.trung.dadjokes.ui

import com.hannesdorfmann.mosby.mvp.MvpActivity
import com.hannesdorfmann.mosby.mvp.MvpPresenter

abstract class BaseMvpActivity<V : BaseMvpView , P : MvpPresenter<V>> : MvpActivity<V,P>(){

}
