/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Attendance;
import model.Student;

/**
 *
 * @author ACER
 */
public class AttendanceDBContext extends DBContext<Attendance> {
    
    public ArrayList<Attendance> listbyGid(int gid){
        ArrayList<Attendance> alist=new ArrayList<>();
        try {
            String sql="select a.aid,a.rollnumer,a.status,a.sessionId from Attendance a join Session se on a.sessionId=se.SessionID where se.GroupID=? \n" +
"                                order by se.Date asc";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1, gid);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Attendance a=new Attendance();
                a.setAid(gid);
                Student s=new Student();
                s.setRollnumber(rs.getString(2));
                a.setStudent(s);
                a.setStatus(rs.getBoolean(3));
                a.setSid(rs.getInt(4));
                alist.add(a);
            }
            
        } catch (Exception e) {
        }
        return alist;
    }

    public ArrayList<Attendance> getStudentbySeid(int seid) {
        ArrayList<Attendance> alist = new ArrayList<>();
        try {
            String sql = "select a.aid,s.RollNumber,s.Name,a.status,a.sessionId from Attendance a left join Student s on a.rollnumer=s.RollNumber\n"
                    + "                                    where a.sessionId=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, seid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendance a = new Attendance();
                a.setAid(rs.getInt(1));
                Student student = new Student();
                student.setRollnumber(rs.getString(2));
                student.setName(rs.getString(3));
                a.setStudent(student);
                a.setStatus(rs.getBoolean(4));
                a.setSid(rs.getInt(5));
                alist.add(a);
            }

        } catch (Exception e) {
        }
        return alist;
    }

    public void SaveChange(ArrayList<Attendance> alist) {
        for (Attendance a : alist) {
            if (a.getAid() == -1) {
                try {
                    String sql = "INSERT INTO [Attendance]\n"
                            + "           ([rollnumer]\n"
                            + "           ,[status]\n"
                            + "           ,[sessionId])\n"
                            + "     VALUES\n"
                            + "           (?,?,?)";
                    PreparedStatement stm=connection.prepareStatement(sql);
                    stm.setString(1, a.getStudent().getRollnumber());
                    stm.setBoolean(2, a.getStatus());
                    stm.setInt(3, a.getSid());
                    stm.executeUpdate();
                } catch (Exception e) {
                }
            } else{
                try {
                    String sql="Update Attendance set status=? where aid=?";
                    PreparedStatement stm=connection.prepareStatement(sql);
                    stm.setBoolean(1, a.getStatus());
                    stm.setInt(2, a.getAid());
                    stm.executeUpdate();
                } catch (Exception e) {
                }
            }
        } 
    }

    @Override
    public ArrayList<Attendance> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendance get(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendance entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
