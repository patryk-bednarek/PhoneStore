package pl.edu.wszib.phone.store.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.phone.store.dao.IPhoneDAO;
import pl.edu.wszib.phone.store.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class PhoneDAOImpl implements IPhoneDAO {

    @Autowired
    Connection connection;
    @Override
    public Phone getPhoneById(int id) {
        String sql = "SELECT * FROM tphone WHERE id = ?;";

        try{
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return new Phone(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("software"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("pieces"));
            }

        }   catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void updatePhone(Phone phone) {
        String sql = "UPDATE tphone SET brand = ?, model = ?, software = ?, price = ?, pieces = ? WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setString(1, phone.getBrand());
            preparedStatement.setString(2, phone.getModel());
            preparedStatement.setString(3, phone.getSoftware());
            preparedStatement.setDouble(4, phone.getPrice());
            preparedStatement.setInt(5, phone.getPieces());
            preparedStatement.setInt(6, phone.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = new ArrayList<>();
        try{
            String sql = "SELECT * FROM tphone;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                phones.add(new Phone(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("model"),
                        resultSet.getString("software"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("pieces")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phones;
    }
}
