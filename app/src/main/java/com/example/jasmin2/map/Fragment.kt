package com.example.jasmin2.map

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kakao.vectormap.KakaoMapSdk

class MapFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showMapView()
    }


    private fun showMapView() {

        // KakaoMapSDK 초기화!!
        KakaoMapSdk.init(requireContext(), KAKAO_MAP_KEY)

    }
}