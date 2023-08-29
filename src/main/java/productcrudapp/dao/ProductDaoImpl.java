package productcrudapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrudapp.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	 @Autowired
	    private HibernateTemplate hibernateTemplate;

	    @Override
	    @Transactional
	    public void createProduct(Product product) {
	        this.hibernateTemplate.saveOrUpdate(product);
	    }
	    
	    @Override
	    public List<Product> getProducts() {
	        List<Product> products = this.hibernateTemplate.loadAll(Product.class);
	        return products;
	    }
	    
	    @Override
	    @Transactional
	    public void deleteProduct(int pid) {
	        Product p = this.hibernateTemplate.load(Product.class, pid);
	        this.hibernateTemplate.delete(p);
	    }
	    
	    @Override
	    public Product getProduct(int pid) {
	        return this.hibernateTemplate.get(Product.class, pid);
	    }
}
