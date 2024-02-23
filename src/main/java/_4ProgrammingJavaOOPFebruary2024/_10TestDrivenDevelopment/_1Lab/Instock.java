package _4ProgrammingJavaOOPFebruary2024._10TestDrivenDevelopment._1Lab;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.products.contains(product);
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        Product fondProduct = null;
        for (Product product1 : products) {
            if (product1.getLabel().equals(product)) {
                fondProduct = product1;
            }
        }
        if (fondProduct == null) {
            throw new IllegalArgumentException();
        } else {
            fondProduct.setQuantity(quantity);
        }
    }

    @Override
    public Product find(int index) {
        return this.products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        for (Product product1 : products) {
            if (product1.getLabel().equals(label)) {
                return product1;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > this.products.size()) {
            return new ArrayList<>();
        }
        return this.products.stream().limit(count).sorted(Comparator.comparing(Product::getLabel)).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getPrice() > lo && product.getPrice() <= hi) {
                products.add(product);
            }
        }
        Collections.reverse(products);
        return products;
//        return this.products
//                .stream()
//                .filter(p -> p.getPrice() > lo && p.getPrice() <= hi)
//                .sorted(Comparator.comparing(Product::getPrice).reversed())
//                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getPrice() == price) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count > this.products.size()) {
            throw new IllegalArgumentException("Less products in stock than " + count);
        }
        return this.products.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        List<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if (product.getQuantity() == quantity) {
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Iterator<Product> iterator() {
        return this.products.iterator();
    }
}
