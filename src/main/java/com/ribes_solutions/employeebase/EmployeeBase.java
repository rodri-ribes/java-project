/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ribes_solutions.employeebase;

import dao.EmployeeDao;
import gui.Layout;

/**
 *
 * @author Rodrigo
 */
public class EmployeeBase {

    public static void main(String[] args) {
        Layout window = new Layout();
        
        EmployeeDao dao = new EmployeeDao();
        
        window.setVisible(true);
       
    }
}
