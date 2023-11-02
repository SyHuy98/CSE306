package CSE306;

import java.io.*;


public class CountCharacter {
    public static void main(String[] args) throws IOException {
        String name = "C:\\Users\\Syhuy98\\java-project\\src\\main\\doc1.txt";
        InputStream inputStream = new FileInputStream(new File(name));
        InputStreamReader reader = new InputStreamReader(inputStream,"UTF-8");
        int data = reader.read();
        String content = "";
        int count =0;
        while(data != -1){
            char ch = (char)data;
            content += ch;
            data = reader.read();
            count++;
        }
        System.out.println(content);
        System.out.println("The number of The Character in the file is: "+ count);

        reader.close();
    }
    }



