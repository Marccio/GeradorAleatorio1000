import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class RandomGen {

    public static void main(String[] args) {
        Random random = new Random();
        ArrayList <String> matriz = new ArrayList<>();//tabela n grande
        ArrayList <String> res = new ArrayList<>();//tabela resultados

        for(int i=0;i<100;i++) {
            for(int j=0;j<10;j++) {
                String r = arr(random.nextInt(10000));
                matriz.add(r);
                String sub = r.substring(2,4);
                double subD = Double.parseDouble(sub)/100;

                if(subD<=0.05) {
                    res.add(""+11);
                } else if(subD<=0.15) {
                    res.add(""+13);
                } else if(subD<=0.28) {
                    res.add(""+15);
                } else if(subD<=0.56) {
                    res.add(""+17);
                } else if(subD<=0.68) {
                    res.add(""+19);
                } else if(subD<=0.86) {
                    res.add(""+21);
                } else {
                    res.add(""+23);
                }
            }
        }

        String filePath = "C:/Users/marci/Desktop/MCM.csv";
        String appendText = "P Medio;Bruto\n";

        for (int i=0; i<res.size(); i++) {
            appendText += res.get(i) +";"+ matriz .get(i)+"\n";
        }
        appendUsingFileWriter(filePath, appendText);

    }

    public static String arr(int number) {
        String value = "" + number;
        String zero = "";

        if(value.length()<4) {
            for(int x=0;x<(4-value.length());x++) {
            zero += "0";
        }
        return zero + value;
        } else {
            return value;
        }
    }

    private static void appendUsingFileWriter(String filePath, String text) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            // Below constructor argument decides whether to append or override
            fr = new FileWriter(file, true);
            fr.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
