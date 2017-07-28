package com.example.db.swagger.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.example.db.swagger.types.EmpDetails;

public class EmpConfigResultSetExtractor implements ResultSetExtractor<List<EmpDetails>> {

    public List<EmpDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<EmpDetails> empDetailList = new ArrayList<EmpDetails>();

        while (rs.next()) {

            EmpDetails empDetails = new EmpDetails();
            empDetails.setId(rs.getInt("ID"));
            empDetails.setFirstName(rs.getString("FirstName"));
            empDetails.setLastName(rs.getString("LastName"));
            empDetails.setAddress(rs.getString("Address"));
            empDetails.setCity(rs.getString("City"));
            empDetails.setEmail(rs.getString("Email"));
            empDetails.setMobile(rs.getString("Mobile"));
            empDetailList.add(empDetails);
        }

        return empDetailList;
    }

}
