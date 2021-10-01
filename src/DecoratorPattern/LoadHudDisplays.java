package DecoratorPattern;

import java.io.*;
import java.util.ArrayList;

public class LoadHudDisplays implements LoadDisplayInterface{
    private String filename;
    private ArrayList<String> titleList;
    public LoadHudDisplays(String filename){
        this.filename = filename;
        titleList = new ArrayList<>();
    }

    @Override
    public ArrayList<String> load() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\chick\\Desktop\\study\\Java\\Pattern\\src\\DecoratorPattern\\displays.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = null;
        while((line = br.readLine()) != null){
            titleList.add(line);
        }

        fr.close();
        br.close();
        return titleList;
    }
}
