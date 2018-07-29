package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Customer;
import com.packt.webstore.domain.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Customer> getAllCustomers() {
        Map<String, Object> params = new HashMap<>();
        List<Customer> customer = new ArrayList<>();

        Customer cust = new Customer();
        cust.setCustomerId(1);
        cust.setName("Donald Trump");
        cust.setAddress("1600 Pennsylvania Ave NW, DC 20500");
        cust.setNoOfOrdersMade(1);

        customer.add(cust);

        return customer;
    }

    private static final class CustomerMapper implements RowMapper<Customer> {
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            // SQL query will be implemented later
            Customer customer = new Customer();
            customer.setCustomerId(1);
            customer.setName("Donald Trump");
            customer.setAddress("1600 Pennsylvania Ave NW, DC 20500");
            customer.setNoOfOrdersMade(1);

            return customer;
        }
    }
}