package DaoPattern;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String args[]) throws SQLException {
        ArrayList<PasswordInfo> list = new ArrayList<>();
        PasswordDAO pd = new PasswordDaoWithSqlite();

        System.out.println("insert");
        pd.insert(new PasswordInfo("https://www.smu.ac.kr", "smu", "abcde"));
        pd.insert(new PasswordInfo("https://www.smu2.ac.kr", "smu2", "abcde"));

        System.out.println("print all");
        list = (ArrayList<PasswordInfo>) pd.findAll();
        for(PasswordInfo pi : list){
            System.out.printf("%s, %s, %s\n", pi.getUrl(), pi.getId(), pi.getPassword());
        }
        System.out.println("");

        System.out.println("update");
        pd.update(new PasswordInfo("https://www.smu2.ac.kr", "smu1", "abcde"));

        PasswordInfo pwi = pd.findByKey("https://www.smu2.ac.kr");
        System.out.printf("%s, %s, %s\n", pwi.getUrl(), pwi.getId(), pwi.getPassword());
        System.out.println();

        System.out.println("delete");
        pd.delete("https://www.smu2.ac.kr" );

        list = (ArrayList<PasswordInfo>) pd.findAll();
        for(PasswordInfo pi : list){
            System.out.printf("%s, %s, %s\n", pi.getUrl(), pi.getId(), pi.getPassword());
        }
    }
}
