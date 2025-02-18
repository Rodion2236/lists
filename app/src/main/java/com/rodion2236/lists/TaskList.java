package com.rodion2236.lists;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private final List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public boolean addTask(String task) { //добавление задачи в список
        if (tasks.contains(task)) { // проверка на содержание
            System.out.println("Уже существует");
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean removeTaskByIndex(int index) { //удаление по индексу
        if (index < 0 || index >= tasks.size()) { //условия для корректной работы
            System.out.println("Не существует");
            return false;
        }
        tasks.remove(index);
        return true;
    }

    public boolean removeTaskByName(String name) { //удаление по названию
        if (!tasks.contains(name)) { // проверка на содержание
            System.out.println("Не существует");
            return false;
        }
        tasks.remove(name);
        return true;
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