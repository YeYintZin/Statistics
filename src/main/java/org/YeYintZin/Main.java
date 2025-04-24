package org.YeYintZin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Double.parseDouble("1"));
        System.out.println(readData("src/main/resources/data.csv"));
    }

    public static List<List<Double>> readData(String path) {
        if (path == null) {
            return null;
        }
        List<List<Double>> table = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(path))) {
            while (sc.hasNext()) {
                table.add(strToDbl(sc.next().split(",")));
            }
            return table;
        } catch (IOException e) {
            System.out.println("File not found. " + e.getMessage());
        }
        return table;
    }

    public static List<Double> strToDbl(String[] datas) {
        List<Double> row = new ArrayList<>();
        for (String data : datas) {
            try {
                row.add(Double.parseDouble(data));
            } catch (NumberFormatException e) {
                System.out.println("Cannot convert " + e.getMessage());
            }
        }
        return row;
    }
}
