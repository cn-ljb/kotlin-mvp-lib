package mvp.ljb.kt.view

import android.app.Activity
import android.os.Bundle
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract


abstract class MvpActivity<out P : IPresenterContract> : Activity(), IBaseView<P>, IViewContract {


    private var mPresenter: P? = null

    protected fun getPresenter() = mPresenter!!

    private fun initPresenter() {
        val clazz = registerPresenter()
        val constructor = clazz.getConstructor()
        mPresenter = constructor.newInstance()
        mPresenter?.registerMvpView(this)
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
