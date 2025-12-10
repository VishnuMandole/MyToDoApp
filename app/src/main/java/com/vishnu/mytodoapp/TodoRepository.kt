package com.vishnu.mytodoapp


class TodoRepository(private val dao: TodoDao) {

    val todos = dao.getAllTodos()

    suspend fun insert(todo: TodoEntity) = dao.insert(todo)

    suspend fun delete(todo: TodoEntity) = dao.delete(todo)

    suspend fun update(todo: TodoEntity) = dao.update(todo)
}
