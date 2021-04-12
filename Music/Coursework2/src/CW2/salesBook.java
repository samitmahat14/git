package CW2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
public class salesBook {
    public static void main(String[] args) {
    	salesBook vm =new salesBook();
        
    }
    salesBook(){
        
        
        JFrame f=new JFrame("Bookstore Inventory Management System");
        JButton btnBack ;
        JLabel lNo,lAb;
        String[] column = {"Book Number","Book Name","Author Name","Date Published","Price", "Quantity Sold"};
         
        lAb = new JLabel("Sold Books");
        f.add(lAb);
        lAb.setBounds(400, -20, 300, 100);
        
        String query="Select * from soldbooks";
        Connectiondb db= new Connectiondb();
        ArrayList<Booking> book= new ArrayList<Booking>();
        
        
        
        try {
            ResultSet result=  db.Con().executeQuery(query);
            System.out.println(result);
            
            while(result.next()) {
                String BookName=result.getString("BookName");
                String AuthorName=result.getString("AuthorName");
                String date=result.getString("DatePublished");
                String Field=result.getString("Price");
                int bookNumber=Integer.parseInt(result.getString("BookCode"));
                int Quantity=Integer.parseInt(result.getString("QuantitySold"));
                Booking stff =new Booking(BookName, AuthorName, date, Field,bookNumber,Quantity);
                book.add(stff);
                
                
            }
            
            
            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        lNo = new JLabel("No of books Sold:"+ book.size());
        f.add(lNo);
        lNo.setBounds(50, 410, 300, 100);
        
        Object[][] data = new Object[book.size()] [column.length];
        
        for(int i=0; i<book.size(); i++) {
            data[i][0]=book.get(i).bookNumber;
            data[i][1]=book.get(i).BookName;
            data[i][2]=book.get(i).AuthorName;
            data[i][3]=book.get(i).date;
            data[i][4]=book.get(i).Field;
            data[i][5]=book.get(i).Quantity;
        }
 
        
        JTable jt =new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        sp.setBounds(50,50,800,400);
        
        
        //button
        
        btnBack=new JButton("Back");
        f.add(btnBack);
        btnBack.setBounds(30, 10, 70, 30);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dash();
                f.dispose();
            }
        });
        
       
        
                
                
                
            
                
                
                
                
                
            
            
       
        
        
        
        
   
        
        
        
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         
        f.setLayout(null);  
        f.setSize(1000,600);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
    }
}
