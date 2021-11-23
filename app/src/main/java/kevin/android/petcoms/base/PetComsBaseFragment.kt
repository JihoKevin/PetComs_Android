package kevin.android.petcoms.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope

abstract class PetComsBaseFragment<T : ViewDataBinding>(layoutId: Int) : BaseFragment<T>(layoutId),
    CoroutineScope {

    @CallSuper
    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        observeData()
    }

    open fun initViews(view: View) {}

    open fun observeData() {}

    @CallSuper
    override fun onDestroy() {

        super.onDestroy()
    }
}