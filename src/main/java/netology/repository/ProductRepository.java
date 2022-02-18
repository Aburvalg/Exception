package netology.repository;

import netology.domain.AlreadyExistsException;
import netology.domain.NotFoundException;
import netology.domain.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void save(Product product) throws AlreadyExistsException {

//        if (findById(id) == product.getId()) {
//            throw new AlreadyExistsException("Product with id: " + id + " already exists");
//        }

        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public Product[] showAll() {
        return products;
    }

    public void removeById(int id) throws NotFoundException {

        if (findById(id) == null) {
            throw new NotFoundException("Product with id:" + id + " not found");
        }

        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }


}
