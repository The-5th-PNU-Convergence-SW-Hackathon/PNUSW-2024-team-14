package com.example.jasmin2.ui.theme



import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(
    query: String,//textfield에 입력한 내용이 여기에 저장됨
    onQueryChanged: (String) -> Unit, //입력한 내용이 변경될때마다 호출됨
    onSearch: (String) -> Unit //검색버튼을 누를떄 호출됨

) { // 세개의 매개변수를 받습니다 바로 query, onQueryChange,onSearch랍니다.
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)

        ){
            TextField(
                value = query, //텍스트 필드에 표시되는 현재 텍스트
                onValueChange = { newQuery ->
                    onQueryChanged(newQuery) // query 업데이트 콜백 호출
                },
                trailingIcon = {
                    IconButton(onClick = { onSearch(query) }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                },
                placeholder = {
                    Text(text = "어떤 헬스장을 찾으시나요?") //query가 비었을때 표시되는거
                },

                modifier = Modifier
                    .padding(50.dp)

                    .heightIn(min = 56.dp)
                    .border(10.dp, Color.Gray, RoundedCornerShape(12.dp))
            )}
    }
}


@Composable
@Preview
fun SearchBarPreview() {
    var query by remember { mutableStateOf("") }

    SearchBar(
        query = query,
        onQueryChanged = { newQuery -> query = newQuery },
        onSearch = { searchQuery -> /* 검색 로직 처리 */ }
    )
}

