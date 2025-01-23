package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Bathroom;
import com.entity.Bedroom;
import com.entity.Hall;
import com.entity.Kitchen;
import com.entity.cart;
import com.entity.order_details;
import com.entity.orders;



public class DAO3 {
	private Connection conn;
	
	public DAO3(Connection conn) {
		this.conn = conn;
	}
	
	
	// view Bedroom
	
	public List<Bedroom> getAllbedroom(){
		List<Bedroom> listv = new ArrayList<Bedroom>();
		
		Bedroom v = null;
		
		try {
			String sql = "select * from bedroom";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				v = new Bedroom();
				v.setBname(rs.getString(1));
				v.setCname(rs.getString(2));
				v.setPname(rs.getString(3));
				v.setPprice(rs.getInt(4));
				v.setPquantity(rs.getInt(5));
				v.setPimage(rs.getString(6));
				listv.add(v);
				
			}
			
			
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return listv;
		}
		
	// view Kitchen
	
		public List<Kitchen> getAllkitchen(){
			List<Kitchen> listv = new ArrayList<Kitchen>();
			
			Kitchen v = null;
			
			try {
				String sql = "select * from kitchen";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next())
				{
					v = new Kitchen();
					v.setBname(rs.getString(1));
					v.setCname(rs.getString(2));
					v.setPname(rs.getString(3));
					v.setPprice(rs.getInt(4));
					v.setPquantity(rs.getInt(5));
					v.setPimage(rs.getString(6));
					listv.add(v);
					
				}
				
				
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				return listv;
			}

		// view Hall
		
			public List<Hall> getAllhall(){
				List<Hall> listv = new ArrayList<Hall>();
				
				Hall v = null;
				
				try {
					String sql = "select * from hall";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next())
					{
						v = new Hall();
						v.setBname(rs.getString(1));
						v.setCname(rs.getString(2));
						v.setPname(rs.getString(3));
						v.setPprice(rs.getInt(4));
						v.setPquantity(rs.getInt(5));
						v.setPimage(rs.getString(6));
						listv.add(v);
						
					}
					
					
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					return listv;
				}
			
			// view Bathroom
			
			public List<Bathroom> getAllbathroom(){
				List<Bathroom> listv = new ArrayList<Bathroom>();
				
				Bathroom v = null;
				
				try {
					String sql = "select * from bathroom";
					PreparedStatement ps = conn.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
					
					while(rs.next())
					{
						v = new Bathroom();
						v.setBname(rs.getString(1));
						v.setCname(rs.getString(2));
						v.setPname(rs.getString(3));
						v.setPprice(rs.getInt(4));
						v.setPquantity(rs.getInt(5));
						v.setPimage(rs.getString(6));
						listv.add(v);
						
					}
					
					
						
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					return listv;
				}


	
	
		

	//==================================
			// addtocartnull
			
			public boolean checkaddtocartnull(cart c)
			{
				boolean f = false;
			
			
				try{
					String sql = "select * from cart  where Name =? and bname=? and cname =? and pname = ? and pprice = ? and pimage = ?";
					PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1,c.getName());
				ps.setString(2, c.getBname());
				ps.setString(3, c.getCname());
				ps.setString(4, c.getPname());
				ps.setInt(5, c.getPprice());
				ps.setString(6, c.getPimage());
				
				ResultSet rs=ps.executeQuery();
				if (rs.next()==true)
					f = true;
				else
					f = false;
				
				}catch(Exception ex){
				   System.out.println(ex.getMessage());
				}

			return f;
					
			}
			
		// update cart	
			public int updateaddtocartnull(cart c) {
				
				int i = 0;
				try{
					String sql = "update cart set pquantity = (pquantity + 1) where Name =? and bname = ? and cname = ? and pname = ? and pprice = ? and pimage = ?" ;
					PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, c.getName());
				ps.setString(2, c.getBname());
				ps.setString(3, c.getCname());
				ps.setString(4, c.getPname());
				ps.setInt(5, c.getPprice());
				ps.setString(6, c.getPimage());
				
				i = ps.executeUpdate();
				if(i > 0)
					i = 1;
				
				
				}catch(Exception ex){
				   System.out.println(ex.getMessage());
				}

			return i;
				
				
				
			}
			
			//
	public int addtocartnull(cart c) {
				
				int i = 0;
				try{
					String sql = "insert into cart values(?,?,?,?,?,?,?)" ;
					PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, c.getName());
				ps.setString(2, c.getBname());
				ps.setString(3, c.getCname());
				ps.setString(4, c.getPname());
				ps.setInt(5, c.getPprice());
				ps.setInt(6, c.getPquantity());
				ps.setString(7, c.getPimage());
				
				i = ps.executeUpdate();
				if(i > 0)
					i = 1;
				
				
				}catch(Exception ex){
				   System.out.println(ex.getMessage());
				}

			return i;
				
				
				
			}
		
		
	
		
		// view orders
	
	
	public List<orders> getOrders(String o){
		List<orders> listv = new ArrayList<orders>();
		
		orders v = null;
		
		try {
			String sql = "select * from orders where Customer_Name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, o);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				v = new orders();
				v.setOrder_Id(rs.getInt(1));
				v.setCustomer_Name(rs.getString(2));
				v.setCustomer_City(rs.getString(3));
				v.setDate(rs.getString(4));
				v.setTotal_Price(rs.getInt(5));
				v.setStatus(rs.getString(6));
				listv.add(v);
				
			}
			
			
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return listv;
		}

	
	//view orders by Date
		

	public List<orders> getOrdersbydate(String d){
		List<orders> listv = new ArrayList<orders>();
		
		orders v = null;
		
		try {
			String sql = "select * from orders where Date = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				v = new orders();
				v.setOrder_Id(rs.getInt(1));
				v.setCustomer_Name(rs.getString(2));
				v.setCustomer_City(rs.getString(3));
				v.setDate(rs.getString(4));
				v.setTotal_Price(rs.getInt(5));
				v.setStatus(rs.getString(6));
				listv.add(v);
				
			}
			
			
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return listv;
		}

			//view order_details by date
	
	public List<order_details> getOrderdetails(String d){
		List<order_details> listd = new ArrayList<order_details>();
		
		order_details v = null;
		
		try {
			String sql = "select * from Order_details where Date = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, d);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				v = new order_details();
				v.setDate(rs.getString(1));
				v.setName(rs.getString(2));
				v.setBname(rs.getString(3));
				v.setCname(rs.getString(4));
				v.setPname(rs.getString(5));
				v.setPprice(rs.getInt(6));
				v.setPquantity(rs.getInt(7));
				v.setPimage(rs.getString(8));
				
				listd.add(v);
				
			}
			
			
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return listd;
		}

	
}
