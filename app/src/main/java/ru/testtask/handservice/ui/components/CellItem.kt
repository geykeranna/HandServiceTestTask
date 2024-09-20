package ru.testtask.handservice.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.testtask.handservice.R
import ru.testtask.handservice.domain.models.Cell
import ru.testtask.handservice.ui.components.utils.mapOfIcon

@Composable
fun CellItem(
    cell: Cell,
    modifier: Modifier = Modifier,
) {
    val icon = mapOfIcon.getOrDefault(cell.state.icon, R.drawable.alive_cell)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.size(40.dp),
            painter = painterResource(id = icon),
            contentDescription = cell.state.icon,
        )

        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top,
        ) {
            Text(
                text = cell.state.label,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Black,
            )
            Text(
                text = cell.state.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black,
            )
        }
    }
}