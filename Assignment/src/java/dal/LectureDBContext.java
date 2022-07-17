/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Lecture;

/**
 *
 * @author ACER
 */
public class LectureDBContext extends DBContext<Lecture>{
    
    public Lecture getLecturebyUsername(String username){
        try {
            String sql="select * from lecture where username =?";
            PreparedStatement stm=connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Lecture lec=new Lecture();
                lec.setLectureid(rs.getString(1));
                lec.setLecturename(rs.getString(2));
                lec.setUsername(rs.getString(3));
                return lec;
            }
        } catch (Exception e) {
        }
        
        return null;
    }

    @Override
    public ArrayList<Lecture> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Lecture get(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Lecture entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
