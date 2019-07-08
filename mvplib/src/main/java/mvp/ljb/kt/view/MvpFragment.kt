package mvp.ljb.kt.view

import android.os.Bundle
import android.support.v4.app.Fragment
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract

/**
 * Author:Ljb
 * Time:2019/7/4
 * There is a lot of misery in life
 **/
abstract class MvpFragment<out P : IPresenterContract> : Fragment(), IBaseView<P>, IViewContract {

    private var mPresenter: P? = null

    protected fun getPresenter() = mPresenter!!

    private fun initPresenter() {
        mPresenter = registerPresenter().newInstance()
        mPresenter?.register(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter()
        mPresenter?.onCreate()
    }

    override fun onStart() {
        super.onStart()
        mPresenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter?.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) {
            mPresenter!!.onDestroy()
            mPresenter = null
        }
    }
}
