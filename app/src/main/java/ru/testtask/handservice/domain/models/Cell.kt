package ru.testtask.handservice.domain.models

data class Cell (
    val id: Long = 0,
    val state: CellState,
){
    companion object {
        val defaultCell = Cell(
            id = 0,
            state = CellState.DEFAULT
        )
    }
}


