package br.com.hossomi.bar.controller;

import java.util.List;
import java.util.Scanner;

import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.Option;
import br.com.hossomi.bar.service.MenuService;

/**
 * Implementa o fluxo da aplicação e a saída ao usuário.
 */
public class MenuController {

    /**
     * Esse controlador basicamente mostra o menu atual na tela e colhe entradas de usuário.
     */
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    /**
     * Inicia o fluxo da aplicação.
     */
    public void execute() {
        boolean exit = false;

        // Loop principal
        while (!exit) {
            Menu menu = menuService.getCurrentMenu();
            int option = 0;

            /*
             * Se não houver um menu, consideramos que o usuário saiu da aplicação.
             */
            if (menu == null) {
                System.out.println("Bye!");
                return;
            }

            /*
             * Imprime o menu na tela.
             */
            System.out.println(menu.getPrompt());
            showOptions(menu);

            /*
             * O try serve para tratar exceções, que são erros de execução do programa.
             *
             * Se alguma exceção for gerada dentro desse bloco, as demais linhas do bloco não serão
             * executadas.
             *
             * Se houver um catch com a exceção que foi gerada, o bloco desse catch será executado.
             *
             * As linhas após o try serão executadas normalmente.
             */
            try {
                /*
                 * Lê entrada do usuário e executa a opção escolhida.
                 */
                option = readOption();
                menu.getOptions().get(option - 1).select();
            }

            /*
             * Aqui tratamos o erro gerado quando a opção não existe. Essa exceção pode ser gerada
             * na linha 64 ao chamar .get(x), em que x é maior ou igual ao número de elementos da
             * lista de opções menu.getOptions().
             */
            catch (IndexOutOfBoundsException e) {
                System.out.println("Sorry, there is no option " + option + "...");
            }

            /*
             * Aqui "tratamos" todos os erros restantes (toda exceção extende Exception). No
             * entanto, os demais erros são irrecuperáveis, então apenas mostramos ao usuário uma
             * mensagem de erro e saímos do programa.
             */
            catch (Exception e) {
                System.out.println("Sorry, I cannot handle a " + e.getClass().getSimpleName() + ": " + e.getMessage());
                System.out.println("I have to go. Bye!");
                exit = true;
            }

            System.out.println("----------------------------------------");
        }
    }

    private void showOptions(Menu menu) {
        List<Option> options = menu.getOptions();
        for (int i = 0; i < options.size(); i++) {
            Option option = options.get(i);
            System.out.println((i + 1) + ". " + option.getLabel());
        }
    }

    private int readOption() {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
