/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Session;

/**
 *
 * @author ACER
 */
public class SessionDBContext extends DBContext<Session>{
    
    public ArrayList<Session> schedule(int lectureid){
        ArrayList<Session> slist=new ArrayList<>();
        try {
            String sql="select s.SessionID,ts.sid,r.RoomName,s.Date,g.Group_Code,l.LectureName,ts.time_start,ts.time_end from Session s left join [Group] g on s.GroupID=g.Id\n" +
"                        left join Lecture l on g.LectureID=l.LectureID\n" +
"                        left join Room r on s.RoomID=r.RoomID \n" +
"						left join TimeSlot ts on s.SlotID=ts.sid \n" +
"						where l.LectureID='sonnt5'";
            PreparedStatement stm=connection.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                 Session s=new Session();
                 s.setSessionid(rs.getInt(1));
                 s.setGroupid(rs.getString(4));
                 s.setSlotid(rs.getInt(2));
                 s.setLectureid(rs.getString(5));
                 s.setDate(rs.getDate(3));
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
