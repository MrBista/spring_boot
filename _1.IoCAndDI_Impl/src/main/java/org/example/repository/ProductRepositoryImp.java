package org.example.repository;

import org.example.model.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImp implements ProductRepository{
    private final DataSource dataSource;


    public ProductRepositoryImp(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO product (name, author, year_published, desc) values(?, ?, ?, ?)";
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0){
                throw new SQLException("Faild to insert product no affected rows");
            }
            ResultSet rs = ps.getResultSet();
            if (rs.next()){
                product.setId(rs.getLong("id"));
            }
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, author, year_published, desc from products";
        List<Product> products = new ArrayList<>();
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Product product = mapRowToProduct(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product findById(Long id) {
        String sql = "SELECT id, name, author, year_published, desc from products where id=?";
        Product product = null;
        try(Connection connection = dataSource.getConnection()){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                product = mapRowToProduct(rs);
            }

        }catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }

    public Product mapRowToProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setDesc(rs.getString("desc"));
        product.setYearPublished(rs.getInt("year_published"));
        product.setAuthor(rs.getString("author"));
        return product;
    }
}
