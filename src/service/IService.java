
package service;

import java.sql.SQLException;
import java.util.List;

public interface IService <t>{
public void ajouter(t p) throws SQLException;
    public void modifier(t p) throws SQLException;
    public boolean supprimer(t p) throws SQLException;
    public List<t> recuperer() throws SQLException;
}
