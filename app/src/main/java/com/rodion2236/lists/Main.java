package com.rodion2236.lists;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskList taskList = new TaskList();
        UserInterface ui = new UserInterface(sc, taskList);

        ui.start();
    }
}