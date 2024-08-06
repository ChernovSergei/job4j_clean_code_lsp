package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.assertj.core.api.Assertions.*;

class ConsolePrinterTest {
    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    void print() {
        System.setOut(new PrintStream(outputStreamCaptor));
        ConsolePrinter printer = new ConsolePrinter();
        String ln = System.lineSeparator();
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        printer.print(menu);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("1.Сходить в магазин"
        + ln + "--1.1.Купить продукты"
        + ln + "----1.1.1.Купить хлеб"
        + ln + "----1.1.2.Купить молоко"
        + ln + "2.Покормить собаку");
    }
}