package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.Menu.MenuItemInfo;
import java.util.Iterator;

public class ConsolePrinter implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        Iterator<MenuItemInfo> iterator = menu.iterator();
        while (iterator.hasNext()) {
            MenuItemInfo item = iterator.next();
            long dotsQty = item.getNumber().chars().filter(ch -> ch == '.').count() - 1;
            String numbers = item.getNumber();
            String name = item.getName();
            String spaces = "";
            for (int i = 0; i < dotsQty; i++) {
                spaces = spaces.concat("--");
            }
            System.out.println(spaces + numbers + name);
        }
    }
}
