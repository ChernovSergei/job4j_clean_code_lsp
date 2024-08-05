package ru.job4j.ood.isp.menu;

import java.util.Scanner;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {

    public static final ActionDelegate STUB_ACTION = () -> System.out.println("Some action");

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        Scanner in = new Scanner(System.in);
        String selection = "";
        while (!selection.equals("5")) {
            System.out.println("Enter command: \n"
                + "1. Add item into the root; \n"
                + "2. Add item into the root item; \n"
                + "3. Action; \n"
                + "4. Print out menu; \n"
                + "5. Exit; \n");
            selection = in.nextLine();
            if (selection.equals("1")) {
                System.out.print("Enter root item name - ");
                String rootName = in.nextLine();
                menu.add(Menu.ROOT, rootName, STUB_ACTION);
            }
            if (selection.equals("2")) {
                System.out.print("Enter root item name - ");
                String rootName = in.nextLine();
                System.out.print("Enter child item name - ");
                String childName = in.nextLine();
                menu.add(rootName, childName, STUB_ACTION);
            }
            if (selection.equals("3")) {
                System.out.print("Enter an item name - ");
                String itemName = in.nextLine();
                if (menu.select(itemName).isPresent()) {
                    menu.select(itemName).get().getActionDelegate().delegate();
                } else {
                    System.out.println("No action is assigned of the item");
                }
            }
            if (selection.equals("4")) {
                ConsolePrinter printer = new ConsolePrinter();
                printer.print(menu);
            }
        }
    }
}
