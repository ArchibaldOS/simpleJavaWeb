package org.smart4j.chapter2.service;

/**
 * @author Archibald
 * @version:
 * @time: 6/4/2017.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *  提供客户数据服务
 */
public class CustomerService {

    public static final Logger LOGGER = (Logger) LoggerFactory.getLogger(CustomerService.class);


    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class,sql);
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        String sql = "SELECT * FROM customer" + " WHERE id = "+id;
        return DatabaseHelper.queryEntity(Customer.class,sql);
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object>fieldMap){
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id, Map<String,Object>fieldMap){
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
       return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
