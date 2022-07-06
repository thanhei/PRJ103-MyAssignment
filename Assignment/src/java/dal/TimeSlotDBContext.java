/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TimeSlot;

/**
 *
 * @author ACER
 */
public class TimeSlotDBContext extends DBContext<TimeSlot>{

    @Override
    public ArrayList<TimeSlot> list() {
        ArrayList<TimeSlot> tls=new ArrayList<>();
        try {
            String sql="select * from TimeSlot";
            PreparedStatement stm=connection.prepareStatement(sql);
            ResultSet rs=stm.executeQuery();
            while (rs.next()) {
                TimeSlot tl=new TimeSlot();
                tl.setSlotid(rs.getInt(1));
                tl.setTimestart(rs.getString(2));
                tl.setTimeend(rs.getString(3));
                tls.add(tl);              
            }
        } catch (Exception e) {
        }
        return tls;
    }

    @Override
    public TimeSlot get(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(TimeSlot entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
