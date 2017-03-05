package com.eurela.project;


import com.eurela.project.problem_26.Solution;

import java.io.IOException;
import java.net.URISyntaxException;

public class App {

    public static void main(String[] args) throws IOException, URISyntaxException {
//        BigDecimal one = new BigDecimal("1");
//        BigDecimal seven = new BigDecimal("3");
//        System.out.println(1.0/3.0);
//        System.out.println(one.divide(seven, 60, BigDecimal.ROUND_HALF_UP).toString());
        System.out.println(Solution.compute(1000));
//        System.out.println(10%6);
    }

}
