package br.com.hossomi.bar.util;

public abstract class Utils {
    public static String formatCost(double cost) {
        return String.format("$%6.2f", cost);
    }
}
