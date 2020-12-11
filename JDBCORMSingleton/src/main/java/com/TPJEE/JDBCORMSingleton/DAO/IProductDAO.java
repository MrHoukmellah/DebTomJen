package com.TPJEE.JDBCORMSingleton.DAO;

import java.util.List;
import com.TPJEE.JDBCORMSingleton.BO.entities.Product;

public interface IProductDAO {
	
	public Product save(Product p);
	public List<Product> getProductsByKeyWord(String kw);
	public Product getProductById(String id);
	public Product update(Product p);
	public Product delete(String id);
	
}
