package dal;

import context.DBContext;
import entity.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyễn Hoàng Anh
 */
public class RoomDao extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Room> getAllRoom() {
        List<Room> list = new ArrayList<>();
        try {
            String query = """
                    SELECT DISTINCT r.RoomId, r.RoomName, r.RoomBed, c.CateId, p.RoomPrice, r.RoomImg,
                                    r.RoomSize, r.RoomView, r.RoomMax, r.RoomStar, r.RoomDes
                    FROM tbRoom r
                    INNER JOIN tbCate c ON r.CateId = c.CateId
                    INNER JOIN tbRoomPrice p ON r.RoomId = p.RoomId and (GETDATE() <= p.EndDate or p.EndDate is null)
                    LEFT JOIN tbBookDetails b ON r.RoomId = b.RoomId
                    WHERE ( NOT EXISTS (
                      SELECT 1
                      FROM tbBookDetails bd
                      WHERE bd.RoomId = r.RoomId
                    )
                    or (GETDATE() > b.EndDate or GETDATE() < b.StartDate))""";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Room(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getDouble(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Room> getSearchRoom(String inDate, String outDate, String cate, String adult, String children) {
        System.out.println(inDate + " " + outDate + " " + cate);
        List<Room> list = new ArrayList<>();
        try {
            String query = """
                    SELECT DISTINCT r.RoomId, r.RoomName, r.RoomBed, c.CateId, p.RoomPrice, r.RoomImg,
                                    r.RoomSize, r.RoomView, r.RoomMax, r.RoomStar, r.RoomDes
                    FROM tbRoom r
                    INNER JOIN tbCate c ON r.CateId = c.CateId and c.CateId = ?
                    INNER JOIN tbRoomPrice p ON r.RoomId = p.RoomId and (GETDATE() <= p.EndDate or p.EndDate is null)
                    LEFT JOIN tbBookDetails b ON r.RoomId = b.RoomId
                    WHERE r.RoomMax >= ? and ( NOT EXISTS (
                      SELECT 1
                      FROM tbBookDetails bd
                      WHERE bd.RoomId = r.RoomId
                    )
                    or ((?>=b.EndDate )or(?<=b.StartDate)))""";
            conn = new DBContext().getConnection();
            int x = Integer.parseInt(adult) + Integer.parseInt(children) / 2, a, b;
            int numberCate = Integer.parseInt(cate);
            if (numberCate != 0) {
                a = numberCate;
                b = numberCate;
            } else {
                String query2 = """
                                select count (CateId)
                                from tbCate""";
                ps = conn.prepareStatement(query2);
                rs = ps.executeQuery();
                rs.next();
                a = 1; b = rs.getInt(1);
            }
            ps = conn.prepareStatement(query);
            ps.setString(3, inDate);
            ps.setString(4, outDate);
            ps.setInt(2, x);
            for (int i = a; i <= b; i++) {
                ps.setInt(1, i);
                rs = ps.executeQuery();
                while(rs.next()) {
                    list.add(new Room(rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getDouble(5),
                            rs.getString(6),
                            rs.getDouble(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getString(11)));
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
