/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Student;
import org.apache.tomcat.util.digester.ArrayStack;

/**
 *
 * @author ACER
 */
public class StudentDBContext extends DBContext<Student> {

    public ArrayList<Student> getStudentbySidAndGid(int sessionid) {
        ArrayList<Student> students = new ArrayStack<>();
        try {
                String sql = "select t.RollNumber,t.Name,se.SessionID from Enroll e left join Session se  on se.GroupID=e.GroupId\n"
                        + "                         left join Student t on t.RollNumber=e.RollNumber\n"
                        + "						 where se.SessionID=?";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setInt(1, sessionid);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Student student=new Student();
                student.setRollnumber(rs.getString(1));
                student.setName(rs.getString(2));
                students.add(student);
            }
        } catch (Exception e) {
        }
        return students;
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Student get(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Student entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
