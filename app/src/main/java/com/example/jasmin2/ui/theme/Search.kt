package com.example.jasmin2.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onSearch: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(50.dp) // 패딩을 Row에 설정합니다.
        ) {
            TextField(

                value = query,
                onValueChange = { newQuery ->
                    onQueryChanged(newQuery)
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
                    Text(
                        text = "어떤 헬스장을 찾으시나요?",
                        fontSize = 15.sp)
                },
                modifier = Modifier
                    .width(300.dp)
                    .heightIn(20.dp),

                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.LightGray // focusedContainerColor 및 unfocusedContainerColor 대신 사용
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
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
