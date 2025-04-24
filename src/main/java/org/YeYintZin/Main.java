package org.YeYintZin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * Creates a table from a CSV file
     * @param path Content Source Root path
     * @return Table
     */
    public static List<List<Double>> readData(String path) {
        //TODO Fix first index first row error
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

    /**
     * Converts String[] -> List(Double)
     * @param datas The inputted String
     * @return datas as a list of double
     */
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

    /**
     * Calculates the mean of a column of data
     * @param clm The column, as an index
     * @param table The table
     * @return The mean/average of the dataset
     */
    public static double mean(int clm, List<List<Double>> table) {
        List<Double> values = new ArrayList<>();
        double sum = 0;
        for (List<Double> row : table) {
            values.add(row.get(clm));
        }
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    /**
     * Get a value from the table
     * @param row row
     * @param clm column
     * @param table data
     * @return value at (row,clm)
     */
    public static double getValue(int row, int clm, List<List<Double>> table) {
        return table.get(row).get(clm);
    }
}
