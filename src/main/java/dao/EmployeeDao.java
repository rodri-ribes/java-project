/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.ribes_solutions.employeebase.models.Employee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rodrigo
 */
public class EmployeeDao {
      
    public Connection connect(){
        Connection connection = null;

        String database = "company";
        String user = "root";
        String password = "";
        String host = "localhost";
        String puerto = "3306";
        String driver = "com.mysql.jdbc.Driver";
        String connectionUrl = "jdbc:mysql://" + host + ":" + puerto + "/" + database + "?useSSL=false";
        
        
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionUrl, user, password);
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return connection;
    }
    
    public void add(Employee employee){
        Connection connection = null;
        
        try {
            connection = connect();
            
            String sql = "INSERT INTO `employee` (`id`, `name`, `lastname`, `dni`, `email`, `birthdate`, `salary`, `position`, `deparment`) VALUES (NULL, '"+ employee.getName() +"', '"+ employee.getLastname() +"', '"+ employee.getDni() +"', '"+ employee.getEmail() +"', '"+ employee.getBirthdate() +"', '"+ employee.getSalary() +"', '"+ employee.getPosition() +"', '"+ employee.getDeparment() +"');";
        
            Statement statement = connection.createStatement();
            
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    public List<Employee> getEmployees(){
        Connection connection = null;
        List<Employee> list = new ArrayList<>();
        
        try {
            connection = connect();
            
            String sql = "SELECT * FROM `employee`";
        
            Statement statement = connection.createStatement();
            
            ResultSet resp = statement.executeQuery(sql);
            
            while(resp.next()){
                Employee employee = new Employee();
                
                employee.setId(resp.getInt("id"));
                employee.setName(resp.getString("name"));
                employee.setLastname(resp.getString("lastname"));
                employee.setDni(resp.getString("dni"));
                employee.setEmail(resp.getString("email"));
                employee.setBirthdate(resp.getString("birthdate")); 
                employee.setSalary(resp.getFloat("salary"));    
                employee.setPosition(resp.getString("position"));    
                employee.setDeparment(resp.getString("deparment"));    
                    
                list.add(employee);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
        public void update(Employee employee){
        Connection connection = null;
        
        try {
            connection = connect();
            
            String sql = "UPDATE `employee` SET `name` = '"+ employee.getName() +"', "
                    + "`lastname` = '"+ employee.getLastname() +"', "
                    + "`dni` = '"+ employee.getDni()+"', "
                    + "`email` = '"+ employee.getEmail() +"', "
                    + "`birthdate` = '"+ employee.getBirthdate()+"', "
                    + "`salary` = '"+ employee.getSalary()+"', "
                    + "`position` = '"+ employee.getPosition()+"', "
                    + "`deparment` = '"+ employee.getDeparment()+"' "
                    + "WHERE `employee`.`id` = "+ employee.getId();
        
            Statement statement = connection.createStatement();
            
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
      public void delete(int id){
        Connection connection = null;
        
        try {
            connection = connect();
            
            String sql = "DELETE FROM employee WHERE `employee`.`id` = "+ id;
        
            Statement statement = connection.createStatement();
            
            statement.execute(sql);
            
        } catch (Exception ex) {
            Logger.getLogger(EmployeeDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
