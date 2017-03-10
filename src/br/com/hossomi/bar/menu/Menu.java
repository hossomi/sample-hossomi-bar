package br.com.hossomi.bar.menu;

import java.util.ArrayList;
import java.util.List;

import br.com.hossomi.bar.menu.option.MenuOption;

public class Menu {

    private String label;
    private String prompt;

    private List<MenuOption> options = new ArrayList<>();

    public Menu(String label, String prompt) {
        this.label = label;
        this.prompt = prompt;
    }

    public String getLabel() {
        return label;
    }

    public String getPrompt() {
        return prompt;
    }

    public List<MenuOption> getOptions() {
        return options;
    }

    public void addOption(MenuOption option) {
        options.add(option);
    }
}
