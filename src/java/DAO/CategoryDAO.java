/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.PhanLoai;

/**
 *
 * @author dell
 */
public class CategoryDAO extends dal.DBContext{
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public List<PhanLoai> getAllCate() {
        List<PhanLoai> listCate  = new ArrayList<>();
        String query = "SELECT * FROM PhanLoai";
        try{
            System.out.println("No co vao day");
            System.out.println(connection.prepareStatement(query));
            ps = connection.prepareStatement(query);
            System.out.println("ket noi thanh cong");
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                listCate.add(new PhanLoai(rs.getInt(1), rs.getString(2)));
            }
            ps.close();
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return listCate;
    }
}
