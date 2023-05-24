package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Nguyễn Hoàng Anh
 */
public class AboutDao extends DBContext{
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public int getNumberGuest(){
        String query = "select sum(r.RoomMax)\n" +
                        "from tbBookDetails b, tbRoom r\n" +
                        "where b.RoomId = r.RoomId";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); 
            rs.next(); return rs.getInt(1);
        }catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getNumberRoom(){
        String query = "select count(r.RoomId)\n" +
                        "from tbRoom r";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); 
            rs.next(); return rs.getInt(1);
        }catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public int getNumberView(){
        String query = "select count(Distinct RoomView)\n" +
                        "from tbRoom ";
        try{
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery(); 
            rs.next(); return rs.getInt(1);
        }catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
}
