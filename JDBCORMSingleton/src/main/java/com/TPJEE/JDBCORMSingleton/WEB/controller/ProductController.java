package com.TPJEE.JDBCORMSingleton.WEB.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.TPJEE.JDBCORMSingleton.BO.entities.Product;
import com.TPJEE.JDBCORMSingleton.DAO.IProductDAO;
import com.TPJEE.JDBCORMSingleton.DAO.ProductDAOImpl;
import com.TPJEE.JDBCORMSingleton.WEB.model.ProductModel;

/**
 * Servlet implementation class ProductController
 */
@WebServlet(name = "products", urlPatterns = "/products" )
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IProductDAO dao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new ProductDAOImpl();
		
	}

	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ProductModel pm = new ProductModel();
		pm.setProducts(dao.getProductsByKeyWord("%"));
		pm.setKeyWord("");
		String path = request.getServletPath();
		if(path.equals("/index")) {
			ServletContext sc = request.getServletContext();
			sc.setAttribute("allProducts", pm);
			request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductModel pm = new ProductModel();
		String path = request.getServletPath();
		if(path.equals("/search")) {
			String kw = request.getParameter("keyword");
			List<Product> pbk = dao.getProductsByKeyWord(kw);
			pm.setKeyWord(kw);
			pm.setProducts(pbk);
			request.setAttribute("productModel", pm);
			request.getRequestDispatcher("ProductsIndex.jsp").forward(request, response);
		}
		if(path.equals("/productDescription")) {
			String id = request.getParameter("id");
			Product p = dao.getProductById(id);
			request.setAttribute("productById", p);
			request.getRequestDispatcher("ProductDescription.jsp").forward(request, response);
		}
		if(path.equals("/addProduct")) {
			Product p = new Product();
			p.setDesignation(request.getParameter("designation"));
			p.setPrice(Double.parseDouble(request.getParameter("price")));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			p = dao.save(p);
			request.setAttribute("productToAdd", p);
			request.getRequestDispatcher("AddProducts.jsp").forward(request, response);
		}
		if(path.equals("/productsManage")) {
			List<Product> p = dao.getProductsByKeyWord("%");
			request.setAttribute("productToAdd", p);
			request.getRequestDispatcher("manageProducts.jsp").forward(request, response);
		}
		if(path.equals("/productsManage/delete")) {
			Product p = new Product();
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setPrice(Double.parseDouble(request.getParameter("price")));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			p.setDesignation(request.getParameter("designation"));
			p = dao.delete(Integer.toString(p.getId()));
			request.setAttribute("deletedproduct", p);
			PrintWriter out = response.getWriter();
			out.println("This product "+p.getDesignation()+" has been removed");
			request.getRequestDispatcher("manageProducts.jsp").forward(request, response);
		}
		if(path.equals("/productsManage/delete")) {
			Product p = new Product();
			p.setId(Integer.parseInt(request.getParameter("id")));
			p.setPrice(Double.parseDouble(request.getParameter("price")));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
			p.setDesignation(request.getParameter("designation"));
			p = dao.update(p);
			request.setAttribute("deletedproduct", p);
			PrintWriter out = response.getWriter();
			out.println("This product "+p.getDesignation()+" has been removed");
			request.getRequestDispatcher("manageProducts.jsp").forward(request, response);
		}
		
		
	}

}
