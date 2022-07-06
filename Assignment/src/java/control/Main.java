/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class Main {
     public static void main(String[] args) {
         int year=LocalDate.now().getYear()-1;
         ArrayList<Integer> years=new ArrayList<>();
         for(int i=0;i<=3;i++){
            years.add(year+i);
        }
         System.out.println(years);
    }
}
