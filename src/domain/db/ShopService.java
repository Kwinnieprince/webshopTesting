package domain.db;

import domain.model.Product;
import java.util.List;
import java.util.Properties;

public class ShopService {
    private Properties properties;
    ProductDb productDb;

    public ShopService(Properties properties){
        this.properties = properties;
        productDb = new ProductDBPostgres(properties);
    }


    public Product getProduct(int id){
        return productDb.get(id);
    }

    public List<Product>getAll(){
        return productDb.getAll();
    }

    public void updateProduct(Product product){
        productDb.update(product);
    }

    public void addProduct(Product product){
        productDb.add(product);
    }

    public void deleteProduct(int id) {
        productDb.delete(id);
    }

    public int getNumberOfProducts(){
        return productDb.getNumbeOfProducts();
    }

}
