package com.rodion2236.lists;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(String task) { //добавление задачи в список
        if (tasks.contains(task)) { // проверка на содержание
            throw new IllegalArgumentException("Уже существует");
        }
        tasks.add(task);
    }

    public void removeTaskByIndex(int index) { //удаление по индексу
        if (index < 0 || index >= tasks.size()) { //условия для корректной работы
            throw new IndexOutOfBoundsException("Не существует");
        }
        tasks.remove(index);
    }

    public void removeTaskByName(String name) { //удаление по названию
        if (!tasks.contains(name)) { // проверка на содержание
            throw new IllegalArgumentException("Не существует");
        }
        tasks.remove(name);
    }

    public void removeTasksByKeyword(String keyword) { //удаление по ключу
        tasks.removeIf(task -> task.contains(keyword));
    }

    public List<String> getAllTasks() { //получить список
        return new ArrayList<>(tasks);
    }

    public boolean isEmpty() { //список пустой
        return tasks.isEmpty();
    }
}