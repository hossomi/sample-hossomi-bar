package br.com.hossomi.bar.menu;

import java.util.ArrayList;
import java.util.List;

import br.com.hossomi.bar.menu.option.Option;

/**
 * Nesse caso o menu não possui lógica nenhuma, servindo apenas para agrupar opções. No entanto,
 * observe que os dados que ele possui são mais voltados ao fluxo da aplicação do que dados.
 */
public class Menu {

    private String label;
    private String prompt;

    private List<Option> options = new ArrayList<>();

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

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(Option option) {
        options.add(option);
    }
}
