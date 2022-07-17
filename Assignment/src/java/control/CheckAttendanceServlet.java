/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dal.AttendanceDBContext;
import dal.LectureDBContext;
import dal.SessionDBContext;
import dal.StudentDBContext;
import dal.TimeSlotDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Account;
import model.Attendance;
import model.Session;
import model.Student;
import model.TimeSlot;
import model.Week;


/**
 *
 * @author ACER
 */
public class CheckAttendanceServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CheckAttendanceServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckAttendanceServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        StudentDBContext sdb=new StudentDBContext();
        AttendanceDBContext adb=new AttendanceDBContext();
        String gid=request.getParameter("gid");
        String seid=request.getParameter("seid");
        String lid=request.getParameter("lid");
        request.setAttribute("gid", gid);
        request.setAttribute("seid", seid);
        request.setAttribute("lid", lid);
        ArrayList<Attendance> attendances=adb.getStudentbySeid(Integer.parseInt(seid));
        if(attendances.size()==0){
            ArrayList<Student> students=sdb.getStudentbySidAndGid(Integer.parseInt(seid));
            request.setAttribute("students", students);
        } else {
            request.setAttribute("attendances", attendances);
        }
          
       
        request.getRequestDispatcher("../view/lecture/checkattendance.jsp").forward(request, response);

        
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String seid=request.getParameter("seid");
        String[] aid=request.getParameterValues("aid");
        String[] rollnumber=request.getParameterValues("rollnumber");
        ArrayList<Attendance> attendances=new ArrayList();

        for(int i=0;i<rollnumber.length;i++){
            Attendance a=new Attendance();
           if(aid==null){
               a.setAid(-1);
           } else {
               a.setAid(Integer.parseInt(aid[i]));
           }
            Student s=new Student();
            s.setRollnumber(rollnumber[i]);
            a.setStudent(s);
            a.setStatus((request.getParameter("status"+i).equals("1")));
            a.setSid(Integer.parseInt(request.getParameter("seid")));
            attendances.add(a);
        }
        AttendanceDBContext adb=new AttendanceDBContext();
        adb.SaveChange(attendances);
        
       //
        response.sendRedirect("lecture/schedule");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
