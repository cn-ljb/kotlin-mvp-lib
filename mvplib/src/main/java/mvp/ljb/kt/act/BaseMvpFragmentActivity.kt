package mvp.ljb.kt.act

import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import mvp.ljb.kt.contract.IPresenterContract
import mvp.ljb.kt.view.MvpFragmentActivity

/**
 * Author:Ljb
 * Time:2018/12/28
 * There is a lot of misery in life
 **/
abstract class BaseMvpFragmentActivity<out P : IPresenterContract> : MvpFragmentActivity<P>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init(savedInstanceState)
        initView()
        initData()
    }


    protected abstract fun getLayoutId(): Int

    protected open fun init(savedInstanceState: Bundle?) {}

    protected open fun initView() {}

    protected open fun initData() {}

    override fun getResources(): Resources {
        val res = super.getResources()
        val newConfig = Configuration()
        newConfig.setToDefaults()
        res.updateConfiguration(newConfig, res.displayMetrics)
        return res
    }

    protected fun showToast(resId: Int) {
        Toast.makeText(this, resId, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(str: String?) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    protected fun goActivity(cls: Class<*>, bundle: Bundle?) {
        val intent = Intent(this, cls)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
    }

    protected fun goActivity(cls: Class<*>) {
        goActivity(cls, null)
    }

}