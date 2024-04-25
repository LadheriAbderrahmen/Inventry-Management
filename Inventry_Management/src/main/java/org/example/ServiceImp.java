package org.example;

import org.example.Models.Category;
import org.example.Models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceImp {
    public static List<Category> getCtegories() throws SQLException {
        List<Category> Categlist= new ArrayList<>();

        try(Connection conn = ConfigDBConnection.Connection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dbo.Categorie");
        ){
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("Id_Categorie");
                String categoryName = resultSet.getString("Name_Categ");
                Categlist.add(new Category(categoryId , categoryName));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Categlist;
    }

    public static List<Product> getProducts() throws SQLException {
        List<Product> Prodlist= new ArrayList<>();

        try(Connection conn = ConfigDBConnection.Connection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM dbo.Product");
        ){
            while (resultSet.next()) {
                int ProdId = resultSet.getInt("Id_Prod");
                String ProdName = resultSet.getString("nom");
                int ProdQte = resultSet.getInt("Qte_Prod");
                Prodlist.add(new Product(ProdId , ProdName,ProdQte));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return Prodlist;
    }

    public static void AddProd(String ProdName , int Qte, int IdCateg){
        try(Connection conn = ConfigDBConnection.Connection();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO Product (nom , Qte_Prod, Id_Categorie) VALUES (?,?, ?)");

        ){
            statement.setString(1,ProdName);
            statement.setInt(2,Qte);
            statement.setInt(3,IdCateg);

            int  rowAffected=statement.executeUpdate();

            if (rowAffected >0){
                System.out.println("Product added successfully.");
            }else{
                System.out.println("Failed to add product.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void UpdateProduct(int IDProd , int NewQte){
        try(Connection conn = ConfigDBConnection.Connection();
            PreparedStatement statement = conn.prepareStatement("UPDATE Product SET Qte_Prod = ? WHERE Id_Prod = ?")) {

            statement.setInt(1, NewQte);
            statement.setInt(2, IDProd);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product quantity updated successfully.");
            } else {
                System.out.println("Failed to update product quantity. No matching product ID found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while updating product quantity: " + e.getMessage(), e);
        }
    }
    public static void DeleteProd(int IdProd){
        try (Connection conn = ConfigDBConnection.Connection();
             PreparedStatement statement = conn.prepareStatement("DELETE FROM Product WHERE Id_Prod = ?")) {

            statement.setInt(1, IdProd);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
            } else {
                System.out.println("Failed to delete product. No matching product ID found.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error while deleting product: " + e.getMessage(), e);
        }
    }


}
