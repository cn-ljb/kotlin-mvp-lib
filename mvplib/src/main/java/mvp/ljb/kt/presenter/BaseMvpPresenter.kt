package mvp.ljb.kt.presenter

import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.contract.IViewContract

/**
 * Author:Ljb
 * Time:2018/12/28
 * There is a lot of misery in life
 **/

abstract class BaseMvpPresenter<out V : IViewContract> : IBasePresenter<V>, IPresenterContract {

    private var mMVPView: V? = null

    @Suppress("UNCHECKED_CAST")
    override fun registerMvpView(mvpView: IViewContract) {
        mMVPView = mvpView as V
    }

    override fun getMvpView() = mMVPView!!

    override fun onCreate() {
    }

    override fun onStart() {
    }

    override fun onResume() {
    }

    override fun onPause() {
    }

    override fun onStop() {
    }

    override fun onDestroy() {
    }

}


