package org.example;
import org.example.util.HibernateUtil;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.persistirProduto("Produto 8", 58.45, 3);

    }
}