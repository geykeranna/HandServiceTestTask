package ru.testtask.handservice.domain.models

enum class CellState(
    val label: String,
    val description: String,
    val icon: String,
) {
    DEATH_CELL(
        label = "Мёртвая",
        description = "или прикидывается",
        icon = "death_cell"
    ),
    ALIVE_CELL(
        label = "Живая",
        description = "и шевелится!",
        icon = "alive_cell"
    ),
    LIFE(
        label = "Жизнь",
        description = "Ку-ку!",
        icon = "life"
    ),
    DEFAULT (
        label = "Просто клеточка",
        description = "просто существует",
        icon = "default"
    );

    companion object {
        fun getValue(value: String): CellState{
            return try {
                 valueOf(value.uppercase())
            } catch (e: IllegalArgumentException) {
                CellState.DEFAULT
            }
        }
    }
}
