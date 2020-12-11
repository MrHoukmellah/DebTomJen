package com.TPJEE.JDBCORMSingleton.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.TPJEE.JDBCORMSingleton.BO.entities.Product;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public Product save(Product p) {
		
		//static call to get Singleton Connection
		Connection sc = SingletonConnection.getConnection();
		
		try {
			PreparedStatement ps = sc.prepareStatement("INSERT INTO PRODUCT (DESIGNATION,PRICE,QUANTITY) VALUES (?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.executeUpdate();
			ps.close();
			PreparedStatement ps2 = sc.prepareStatement("SELECT MAX(ID) AS MAX_ID FROM PRODUCT");
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setId((int) rs.getLong("MAX_ID"));
			}
			ps2.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
		
	}

	@Override
	public List<Product> getProductsByKeyWord(String kw) {
		
		Product p = new Product();
		List<Product> productsById = new ArrayList<Product>();
		Connection sc = SingletonConnection.getConnection();
		//static call to get Singleton Connection
		
		try {
			PreparedStatement ps = sc.prepareStatement("SELECT * FROM PRODUCT WHERE DESIGNATION LIKE ? ");
			ps.setString(1, kw);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {				
				p.setId((int) rs.getInt("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrice((double) rs.getDouble("PRICE"));				
				p.setQuantity((int) rs.getInt("QUANTITY"));
				productsById.add(p);
				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productsById;		
	}

	@Override
	public Product getProductById(String id) {
		
		//static call to get Singleton Connection
		Connection sc = SingletonConnection.getConnection();
		
		Product p = new Product();
		//static call to get Singleton Connection
		
		try {
			PreparedStatement ps = sc.prepareStatement("SELECT * FROM PRODUCTS WHERE ID LIKE ? ");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {				
				p.setId((int) rs.getInt("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrice((double) rs.getDouble("PRICE"));				
				p.setQuantity((int) rs.getInt("QUANTITY"));				
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public Product update(Product p) {
		
		//static call to get Singleton Connection
		Connection sc = SingletonConnection.getConnection();
		
		//static call to get Singleton Connection
		
		try {
			PreparedStatement ps = sc.prepareStatement("UPDATE PRODUCTS DESIGNATION = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?");
			ps.setString(1,p.getDesignation());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			ps.setInt(4,p.getId());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public Product delete(String id) {
		
		//static call to get Singleton Connection
		Connection sc = SingletonConnection.getConnection();
		Product p = new Product();
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps2 = sc.prepareStatement("SELECT * FROM PRODUCT WHERE ID LIKE ?");
			ps2.setString(1,id);
			p.setId(Integer.parseInt(id));
			ResultSet rs = ps2.executeQuery();
			if(rs.next()) {
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("QUANTITY"));
			}
			PreparedStatement ps = sc.prepareStatement("DELETE FROM PRODUCT WHERE ID LIKE ?");

			ps.setString(3, id);

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
}
