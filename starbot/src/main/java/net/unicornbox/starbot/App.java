package net.unicornbox.starbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App
{

    static String[] input = { "qu", "elle", "pp", "pe", "ch", "an", "ph", "th", "ie" };

    static String[] output = { "k", "el", "p", "p", "x", "en", "f", "t", "y" };

    public static void main(String[] args) throws IOException
    {
        while (true)
        {
            System.out.println("Hello welcome to starbucks, what is your name?");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            if (s == null)
            {
                return;
            }
            System.out.println("Here is your coffee, " + starbuckit(s));

        }
    }

    private static String starbuckit(String s)
    {
        s = s.toLowerCase();
        for (int i = 0; i < input.length; i++)
        {
            if (s.contains(input[i]))
            {
                s = replaceWithLuck(s, input[i], output[i]);
            }
            else if (s.contains(output[i]))
            {
                s = replaceWithLuck(s, output[i], input[i]);
            }
        }
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        if (Math.random() > 0.5)
        {
            // remove random letter
            int indexToRemove = (int) (Math.random() * s.length() + 1);
            s = s.substring(0, indexToRemove - 1) + s.substring(indexToRemove);
        }
        return s;
    }

    public static String replaceWithLuck(String toReplace, String old, String newS)
    {
        if (Math.random() < 0.85)
        {
            return toReplace.replace(old, newS);
        }
        else
        {
            return toReplace;
        }
    }
}