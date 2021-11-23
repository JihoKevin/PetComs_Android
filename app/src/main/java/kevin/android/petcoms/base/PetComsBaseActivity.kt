package kevin.android.petcoms.base

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class PetComsBaseActivity : AppCompatActivity(), CoroutineScope {

    private var fetchJob: Job = Job()
    override val coroutineContext: CoroutineContext
        get() = fetchJob + Dispatchers.Main

    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()
    }
}