package ru.testtask.handservice.ui.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.testtask.handservice.domain.models.Cell

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CellList(
    cells: List<Cell>,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    LaunchedEffect(cells.size) {
        if (cells.isNotEmpty()) {
            listState.animateScrollToItem(cells.size - 1)
        }
    }

    LazyColumn(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        reverseLayout = true,
        state = listState,
    ) {
        items(cells){ cell ->
            CellItem(
                modifier = Modifier.animateItemPlacement(
                    animationSpec = tween(durationMillis = 600)
                ),
                cell = cell,
            )
        }
    }
}