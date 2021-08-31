/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Ryan Turner
 */
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void compileOutput(Map<String, Float> values)
    {
        System.out.println(values.get("euros") + " euros at an exchange rate of " + values.get("rate") + " is\n" +
                values.get("totalDollars") + " U.S. Dollars.");
    }

    public static Map<String, Float> calculateTotal(Map<String, Float> values)
    {
        DecimalFormat df = new DecimalFormat("#.##");
        Float dollarAmount = values.get("rate") * values.get("euros");
        values.put("totalDollars", Float.valueOf(df.format(dollarAmount)));

        return values;
    }

    public static Map<String, Float> gatherInput() throws IOException {
        DecimalFormat df = new DecimalFormat("#.##");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Float> input = new HashMap<>();

        System.out.println("How many Euros are you exchanging? ");
        input.put("euros", Float.valueOf(df.format(Float.parseFloat(reader.readLine()))));

        System.out.println("What is the exchange rate? ");
        input.put("rate", Float.valueOf(df.format(Float.parseFloat(reader.readLine()))));

        return input;
    }

    public static void main( String[] args ) throws IOException {
        Map<String, Float> values = gatherInput();
        Map<String, Float> valuesWithTotal = calculateTotal(values);
        compileOutput(valuesWithTotal);
    }
}
