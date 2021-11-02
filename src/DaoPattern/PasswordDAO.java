package DaoPattern;

import java.sql.SQLException;
import java.util.List;

public interface PasswordDAO {
    public void insert(PasswordInfo p);
    public List<PasswordInfo> findAll() throws SQLException;
    public PasswordInfo findByKey(String url);
    public void update(PasswordInfo p);
    public void delete(String url);
    public void delete(PasswordInfo p);
}
