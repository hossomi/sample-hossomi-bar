package br.com.hossomi.bar.util;

/**
 * Às vezes, queremos algumas operações úteis mas que não se encaixam muito bem em nenhuma camada ou
 * em nenhuma classe, ou podem até mesmo ser utilizados em vários lugares.
 *
 * Pra esses casos podemos implementar as classes de utilidades. Elas não são feitas para serem
 * instancaidas (e por isso eu costumo fazê-las abstract, mas você pode usar um construtor private)
 * e possuem apenas métodos static.
 */
public abstract class Utils {

    /**
     * Formata um valor no formato "$ 00.00", alinhando o valor à direita.
     */
    public static String formatCost(double cost) {
        return String.format("$%6.2f", cost);
    }
}
