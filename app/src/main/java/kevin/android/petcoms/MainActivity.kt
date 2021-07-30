package kevin.android.petcoms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kevin.android.petcoms.databinding.ActivityMainBinding
import kevin.android.petcoms.fragments.record.adapter.RecordViewPagerAdapter

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null // 뷰 바인딩 활용 (findViewById 사용 할 필요 없음) 접근 방법 : binding.id . . .
    private val binding get() = mBinding!! // 매번 null check 할 필요 없이 바인딩 변수 재 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        putBottomNavigation() // 바텀 네비게이션 세팅
    }

    private fun putBottomNavigation() { // bottomNavigation menu setting
        val navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        // 액티비티가 종료되면 남아있는 메모리 정리
        mBinding = null
        super.onDestroy()
    }

}