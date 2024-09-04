package com.example.jasmin2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import com.kakao.vectormap.KakaoMap
import com.kakao.vectormap.KakaoMapReadyCallback
import com.kakao.vectormap.MapLifeCycleCallback
import com.kakao.vectormap.MapView
import com.example.jasmin2.R
import com.kakao.vectormap.BuildConfig
import com.kakao.vectormap.KakaoMapSdk
import com.kakao.vectormap.LatLng
import com.kakao.vectormap.camera.CameraUpdateFactory

class MapActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private var kakaoMap: KakaoMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KakaoMapSdk.init(this, BuildConfig.KAKAO_MAP_KEY)
        //KAKAO_MAP_KEY는 엑세스 키가 필요하며, 보안상 local.properties 파일에서 작성되었기 때문에 현재 값이 있지 않다.

        setContentView(R.layout.activity_map)  // activity_map.xml 레이아웃 사용

        // MapView 초기화
        mapView = findViewById(R.id.map_view)


        // 지도 시작 및 콜백 설정
        mapView.start(object : MapLifeCycleCallback() {
            override fun onMapDestroy() {
                // 지도 API가 정상적으로 종료될 때 호출됨
                Log.d("MapActivity", "Map is destroyed")
            }

            override fun onMapError(error: Exception) {
                // 인증 실패 및 지도 사용 중 에러가 발생할 때 호출됨
                Log.e("MapActivity", "Map error: ${error.message}")
            }
        }, object : KakaoMapReadyCallback() {
            override fun onMapReady(map: KakaoMap) {
                // 인증 후 API가 정상적으로 실행될 때 호출됨
                kakaoMap = map
                Log.d("MapActivity", "Map is ready")
                // 여기서 kakaoMap 객체를 사용해 마커 추가 등 지도 설정 가능
            }

            override fun getPosition(): LatLng {
                // 지도 시작 시 위치 좌표를 설정 (예: 부산대학교의 다른 위치)
                return LatLng.from(37.406960, 127.115587)
            }
        })
    }

    override fun onResume() {
        super.onResume()
        mapView.resume()  // MapView의 resume 호출
    }

    override fun onPause() {
        super.onPause()
        mapView.pause()  // MapView의 pause 호출
    }
}
