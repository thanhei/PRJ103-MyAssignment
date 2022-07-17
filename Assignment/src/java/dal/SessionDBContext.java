/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Group;
import model.Session;

/**
 *
 * @author ACER
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Session> schedule(String lectureid) {
        ArrayList<Session> slist = new ArrayList<>();
        try {
            String sql = "select s.SessionID,ts.sid,r.RoomName,s.Date,g.Id as groupID,g.Group_Code,sj.SubjectCode,l.LectureID,ts.time_start,ts.time_end from Session s left join [Group] g on s.GroupID=g.Id\n" +
"                                           left join Lecture l on g.LectureID=l.LectureID\n" +
"                    					left join Subject sj on g.SubjectID=sj.SubjectID\n" +
"                                           left join Room r on s.RoomID=r.RoomID \n" +
"                    					left join TimeSlot ts on s.SlotID=ts.sid \n" +
"                   					\n" +
"                    					where l.LectureID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, lectureid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Session s = new Session();
                s.setSessionid(rs.getInt(1));
                Group g=new Group();
                g.setId(rs.getInt(5));
                g.setGroup_code(rs.getString(6));
                s.setGroup(g);
                s.setSlotid(rs.getInt(2));
                s.setLectureid(rs.getString(8));
                s.setSubjectCode(rs.getString(7));
                s.setRoomName(rs.getString(3));
                s.setDate(LocalDate.parse(rs.getString(4), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                slist.add(s);
            }

        } catch (Exception e) {
        }
        return slist;
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Session get(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Session entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
