/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dal.LectureDBContext;
import dal.SessionDBContext;
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
import model.Session;
import model.TimeSlot;
import model.Week;

/**
 *
 * @author ACER
 */
public class SessionController extends HttpServlet {
   
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
            out.println("<title>Servlet SessionController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SessionController at " + request.getContextPath () + "</h1>");
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
        HttpSession session=request.getSession();
       
        if(session.getAttribute("account")!=null){
             SessionDBContext sdb=new SessionDBContext();
        ArrayList<Session> selist=new ArrayList<>();
            LectureDBContext ldb=new LectureDBContext();
           Account acc=(Account)session.getAttribute("account");
           String username=acc.getUsername();
        selist=sdb.schedule(ldb.getLecturebyUsername(username).getLectureid());
        TimeSlotDBContext tbd=new TimeSlotDBContext();
        ArrayList<TimeSlot> tlist=new ArrayList<>();
        tlist=tbd.list();
        
        
       int year=LocalDate.now().getYear()-1;
       ArrayList<Integer> years=new ArrayList<>();
        for(int i=0;i<=3;i++){
            years.add(year+i);
        }
        request.setAttribute("years", years);
       String date=String.format("%02d", LocalDate.now().getMonthValue())+"-"+String.format("%02d", LocalDate.now().getDayOfMonth());
//      LocalDate today2=LocalDate.parse(year+"-"+date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate today=LocalDate.now();
   
       
       LocalDate startDate= LocalDate.parse("2022-01-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));            
            ArrayList<Week> weeks=new ArrayList<>();
            request.setAttribute("startdate", startDate);
            for(int i=0;i<363;i=i+7){
                LocalDate endDate=startDate.plusDays(6);
                Week week=new Week();
                week.setStartdate(startDate);
                week.setEndate(endDate);
                weeks.add(week);
                startDate=endDate.plusDays(1);               
            }
            
            for (Week week : weeks) {
                for(int i=0;i<6;i++){
                    if(week.getStartdate().plusDays(i).equals(today)){
                        today=week.getStartdate();
                    } else if(week.getStartdate().plusDays(-i).equals(today)){                      
                              today=week.getStartdate();
                         }                   
                }
    
            
        }
            request.setAttribute("slots", tlist);
            request.setAttribute("sessions", selist);
            request.setAttribute("today", today);
    //            request.setAttribute("today2", today2);
            request.setAttribute("weeks", weeks);
        request.getRequestDispatcher("../view/lecture/Schedule.jsp").forward(request, response);
        } else {
            response.getWriter().println("acces denided");
        }
        
        
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
        HttpSession session=request.getSession();
         SessionDBContext sdb=new SessionDBContext();
        ArrayList<Session> selist=new ArrayList<>();
        LectureDBContext ldb=new LectureDBContext();
           Account acc=(Account)session.getAttribute("account");
           String username=acc.getUsername();
        selist=sdb.schedule(ldb.getLecturebyUsername(username).getLectureid());
        TimeSlotDBContext tbd=new TimeSlotDBContext();
        ArrayList<TimeSlot> tlist=new ArrayList<>();
        tlist=tbd.list();
        int year=LocalDate.now().getYear()-1;
       ArrayList<Integer> years=new ArrayList<>();
        for(int i=0;i<=3;i++){
            years.add(year+i);
        }
        request.setAttribute("years", years);        
        String raw_year=request.getParameter("year");
        LocalDate raw_date= LocalDate.parse(request.getParameter("week1"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String raw_month=String.format("%02d", raw_date.getMonthValue());
        String raw_day=String.format("%02d", raw_date.getDayOfMonth());

       LocalDate today=LocalDate.parse(raw_year+"-"+raw_month+"-"+raw_day, DateTimeFormatter.ofPattern("yyyy-MM-dd")); 
        LocalDate startDate= LocalDate.parse(raw_year+"-01-03", DateTimeFormatter.ofPattern("yyyy-MM-dd"));            
            ArrayList<Week> weeks=new ArrayList<>();
            request.setAttribute("startdate", startDate);
            for(int i=0;i<363;i=i+7){
                LocalDate endDate=startDate.plusDays(6);
                Week week=new Week();
                week.setStartdate(startDate);
                week.setEndate(endDate);
                weeks.add(week);
                startDate=endDate.plusDays(1);               
            } 

             request.setAttribute("slots", tlist);
            request.setAttribute("sessions", selist);
      request.setAttribute("today", today);
      request.setAttribute("weeks", weeks);
      request.getRequestDispatcher("../view/lecture/Schedule.jsp").forward(request, response);
        
       
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
