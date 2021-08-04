package kevin.android.petcoms

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kevin.android.petcoms.databinding.ActivityMainBinding
import kevin.android.petcoms.fragments.record.adapter.RecordViewPagerAdapter

class MainActivity : AppCompatActivity() {

    //val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        putBottomNavigation() // 바텀 네비게이션 세팅
    }

    private fun putBottomNavigation() { // bottomNavigation menu setting
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()

        bottomNavigationView.setupWithNavController(navController)
    }

    override fun onDestroy() {
        // 액티비티가 종료되면 남아있는 메모리 정리
        super.onDestroy()
    }

}