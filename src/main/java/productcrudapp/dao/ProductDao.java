package productcrudapp.dao;

import java.util.List;

import productcrudapp.model.Product;

public interface ProductDao {
	 void createProduct(Product product);
	    List<Product> getProducts();
	    void deleteProduct(int pid);
	    Product getProduct(int pid);

}
