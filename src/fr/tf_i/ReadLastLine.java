package fr.tf_i;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Class using to read last CSV line (Work for other type of files too)
 */
public class ReadLastLine{

    /**
     * Read last Player1.csv line
     * @return the line
     * @throws Exception exception
     */
    public static String Player1CSV() throws Exception {

        FileInputStream in = new FileInputStream("Player1.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = null, tmp;

        while ((tmp = br.readLine()) != null)
        {
            strLine = tmp;
        }

        String lastLine = strLine;

        return lastLine;
    }

    /**
     * Read last Player2.csv line
     * @return the line
     * @throws Exception exception
     */
    public static String Player2CSV() throws Exception {

        FileInputStream in = new FileInputStream("Player2.csv");
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine = null, tmp;

        while ((tmp = br.readLine()) != null)
        {
            strLine = tmp;
        }

        String lastLine = strLine;

        return lastLine;
    }
}
