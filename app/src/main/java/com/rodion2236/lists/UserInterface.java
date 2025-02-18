package com.rodion2236.lists;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner sc;
    private final TaskList taskList;

    public UserInterface(Scanner sc, TaskList taskList) {
        this.sc = sc;
        this.taskList = taskList;
    }

    public void start() {
        while (true) {
            displayMenu();
            String operation = sc.nextLine();
            selectOperation(operation);
        }
    }

    private void displayMenu() {
        System.out.printf("Выберите операцию:\n");
        System.out.printf("0. Выход из программы\n");
        System.out.printf("1. Добавить задачу\n");
        System.out.printf("2. Показать задачи\n");
        System.out.printf("3. Удалить задачу по номеру\n");
        System.out.printf("4. Удалить задачу по названию\n");
        System.out.printf("5. Удалить задачи по ключевому слову\n");
    }

    private void selectOperation(String operation) {
        try {
            int numberOperation = Integer.parseInt(operation);
            switch (numberOperation) {
                case 0:
                    System.exit(0);
                case 1:
                    addTask();
                    break;
                case 2:
                    showTasks();
                    break;
                case 3:
                    deleteTaskByIndex();
                    break;
                case 4:
                    deleteTaskByName();
                    break;
                case 5:
                    deleteTasksByKeyword();
                    break;
                default:
                    System.out.println("Введен некорректный номер операции");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введен некорректный номер операции");
        }
    }

    private void emptyList() { //чтоб не вводить кучу раз
        System.out.println("Список задач пустой");
    }

    private void addTask() { //добавление задачи в список ui
        System.out.println("Введите название задачи");
        String task = sc.nextLine();
        if (taskList.addTask(task)) {
            System.out.println("Задание добавлено успешно");
        } else {
            System.out.println("Уже существует");
        }
        showTasks();
    }

    private void showTasks() { //вывод списка на экран ui
        List<String> tasks = taskList.getAllTasks();
        if (tasks.isEmpty()) {
            emptyList();
        } else {
            int counter = 1;
            for (String task : tasks) {
                System.out.println(counter++ + ". " + task);
            }
        }
    }

    private void deleteTaskByIndex() { //удаление по индексу ui
        if (taskList.isEmpty()) {
            emptyList();
            return;
        }
        System.out.println("Введите номер задачи");
        String input = sc.nextLine();
        try {
            int index = Integer.parseInt(input);
            if (taskList.removeTaskByIndex(index - 1)) {
                System.out.println("Задание удалено успешно");
            } else {
                System.out.println("Не существует");
            }
        } catch (NumberFormatException e) {
            System.out.println("Введено некорректное значение");
        }
        showTasks();
    }

    private void deleteTaskByName() { //удаление по названию ui
        if (taskList.isEmpty()) {
            emptyList();
            return;
        }
        System.out.println("Введите задачу для удаления");
        String task = sc.nextLine();
        if (taskList.removeTaskByName(task)) {
            System.out.println("Задание удалено успешно");
        } else {
            System.out.println("Не существует");
        }
        showTasks();
    }

    private void deleteTasksByKeyword() { //удаление по ключевому слову ui
        if (taskList.isEmpty()) {
            emptyList();
            return;
        }
        System.out.println("Введите ключевое слово");
        String keyword = sc.nextLine();
        taskList.removeTasksByKeyword(keyword);
        System.out.println("Успешно удалены все задачи, содержащие " + keyword);
        showTasks();
    }
}