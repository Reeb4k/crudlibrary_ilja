package com.sda.database.repository;


import com.sda.database.connection.DatabaseConnection;
import com.sda.database.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class EmployeeRepository implements CrudRepository<EmployeeEntity> {

    private final DatabaseConnection databaseConnection;

    @Override
    public List<EmployeeEntity> findAll() {
        List<EmployeeEntity> employeeEntities = new ArrayList<>();
        try {
            ResultSet resultset = databaseConnection.read("select * from Employee");

            while (resultset.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setAge(resultset.getInt("age"));
                employeeEntity.setId(resultset.getInt("id"));
                employeeEntity.setName(resultset.getString("name"));
                employeeEntity.setPhone(resultset.getString("phone_no"));
                employeeEntity.setCity(resultset.getString("city"));

                employeeEntities.add(employeeEntity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employeeEntities;
    }

    @Override
    public Optional<EmployeeEntity> findById(long id) {


        /*List<EmployeeEntity> employeeEntities = new ArrayList<>();
        try {
            ResultSet resultset = databaseConnection.read("select * from Employee where e.id=" + id);

            while (resultset.next()) {
                EmployeeEntity employeeEntity = new EmployeeEntity();
                employeeEntity.setId(resultset.getInt("id"));
                employeeEntity.setId(resultset.getInt("age"));
                employeeEntity.setName(resultset.getString("name"));
                employeeEntity.setName(resultset.getString("city"));
                employeeEntity.setName(resultset.getString("phone"));

                employeeEntities.add(employeeEntity);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }*/
        return null;
    }
}

