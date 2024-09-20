package ru.testtask.handservice.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.testtask.handservice.R
import ru.testtask.handservice.ui.components.CellList
import ru.testtask.handservice.ui.theme.Gradient
import ru.testtask.handservice.ui.theme.Primary

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainScreenViewModel = koinViewModel()
) {
    val list by viewModel.getData().collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Gradient)
    ) {
        Scaffold(
            modifier = modifier
                .padding(horizontal = 14.dp, vertical = 20.dp),
            containerColor = Color.Transparent,
            topBar = {
                Text(
                    modifier = Modifier
                        .padding(bottom = 19.dp, top = 23.dp)
                        .fillMaxWidth(),
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            },
            bottomBar = {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 18.dp),
                    onClick = { viewModel.obtainEvent(MainScreenViewModel.Event.OnAddItems) },
                    shape = RoundedCornerShape(4.dp),
                    colors = ButtonColors(
                        contentColor = Color.White,
                        containerColor = Primary,
                        disabledContentColor = Color.White,
                        disabledContainerColor = Primary,
                    )
                ) {
                    Text(
                        modifier = Modifier,
                        text = stringResource(id = R.string.button_label).uppercase(),
                        style = MaterialTheme.typography.labelSmall,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        ) { padding ->
            CellList(
                modifier = Modifier.padding(padding).fillMaxSize(),
                cells = list,
            )
        }
    }
}