package br.com.hossomi.bar.controller;

import java.util.List;
import java.util.Scanner;

import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.MenuOption;
import br.com.hossomi.bar.service.CartService;
import br.com.hossomi.bar.service.MenuService;

public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    public void execute() {
        boolean exit = false;

        while (!exit) {
            Menu menu = menuService.getCurrentMenu();
            int option = 0;
            if (menu == null) {
                System.out.println("Bye!");
                return;
            }

            System.out.println(menu.getPrompt());
            showOptions(menu);

            try {
                option = readOption();
                menuService.selectOption(option-1);
            }
            catch (IndexOutOfBoundsException e) {
                System.out.println("Sorry, there is no option " + option + "...");
            }
            catch (Exception e) {
                System.out.println("Sorry, I cannot handle a " + e.getClass().getSimpleName() + ": " + e.getMessage());
                System.out.println("I have to go. Bye!");
                exit = true;
            }

            System.out.println("----------------------------------------");
        }
    }

    private void showOptions(Menu menu) {
        List<MenuOption> options = menu.getOptions();
        for (int i = 0; i < options.size(); i++) {
            MenuOption menuOption = options.get(i);
            System.out.println((i + 1) + ". " + menuOption.getLabel());
        }
    }

    private int readOption() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
