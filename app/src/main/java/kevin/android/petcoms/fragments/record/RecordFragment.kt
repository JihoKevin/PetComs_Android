package kevin.android.petcoms.fragments.record

import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentRecordBinding

// EntryPoint만 걸어주고
@AndroidEntryPoint
// 기본 Fragment() 상속받는 부분을 Base로 상속받고, <> 제네릭 부분에 아래처럼 Binding파일 생성된거 넣어주세요!
class RecordFragment : PetComsBaseFragment<FragmentRecordBinding>() {

    // 이렇게 binding 가져오고
    override fun getViewBinding(): FragmentRecordBinding = FragmentRecordBinding.inflate(layoutInflater)

    override fun observeData() {
        // 이 부분은 나중에 라이브데이터 observe 하는 부분을 싹 다 모아놓을거예요~!
    }

    // 텍스트, 리사이클러뷰, 그래프 등등 ..... 모든 뷰가 바뀌는 부분은 이곳에서 실행됩니다. 아래 예시처럼요!
    override fun initViews() {
        binding.txtTest.text = "테스트 입니다."
    }
}



