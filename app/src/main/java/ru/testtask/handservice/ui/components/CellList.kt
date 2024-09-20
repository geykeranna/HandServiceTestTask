package ru.testtask.handservice.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.testtask.handservice.domain.models.Cell

@Composable
fun CellList(
    cells: List<Cell>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .background(Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        items(cells){ cell ->
            CellItem(
                modifier = Modifier,
                cell = cell,
            )
        }
    }
}