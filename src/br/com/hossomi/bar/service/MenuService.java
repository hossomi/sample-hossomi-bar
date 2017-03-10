package br.com.hossomi.bar.service;

import java.util.LinkedList;
import java.util.List;

import br.com.hossomi.bar.menu.Menu;
import br.com.hossomi.bar.menu.option.Option;

/**
 * Possui a lógica dos menus, como a pilha de menus em que o usuário está e mÉtodos para manipular
 * essa pilha.
 */
public class MenuService {

    /**
     * A pilha de menus. O topo da pilha é o menu atual.
     */
    private LinkedList<Menu> menuStack = new LinkedList<>();

    public Menu getCurrentMenu() {
        /*
         * Um operador ternário (?:) tem a mesma lógica do if-then-else, mas em apenas uma
         * expressão. É apenas uma conveniência; quando bem utilizado, é mais legível/agradável, mas
         * depende de quem está lendo.
         */
        return !menuStack.isEmpty()
                ? menuStack.getFirst()
                : null;
    }

    /**
     * Volta para o menu anterior.
     */
    public void back() {
        if (menuStack.size() > 0) {
            menuStack.pop();
        }
    }

    /**
     * Avança para o menu fornecido, adicionando-o ao topo da pilha.
     */
    public void enter(Menu menu) {
        menuStack.push(menu);
    }
}
