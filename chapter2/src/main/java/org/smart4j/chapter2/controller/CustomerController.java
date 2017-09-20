//package org.smart4j.chapter2.controller;
//
//import com.mysql.fabric.xmlrpc.base.Param;
//import org.smart4j.chapter2.model.Customer;
//import org.smart4j.chapter2.service.CustomerService;
//
//import javax.inject.Inject;
//import javax.swing.text.View;
//import javax.xml.crypto.Data;
//import javax.xml.ws.Action;
//import java.util.List;
//import java.util.Map;
//import java.lang.annotation.*;
//
///**
// * @author Archibald
// * @version:
// * @time: 6/11/2017.
// */
//
///**
// * 处理客户管理相关请求
// */
//public class CustomerController {
//
//    @Inject
//    private CustomerService customerService;
//
//    /**
//     * 进入 客户列表 界面
//     */
//    @Action("get:/customer")
//    public View idex(Param param){
//        List<Customer> customerList = customerService.getCustomerList();
//        return new View("customer.jsp").addModel("customerList",customerList);
//    }
//
//    /**
//     * 显示客户基本信息
//     */
//    @Action("get:/cusstomer_show")
//    public View show(Param param) {
//        long id = param.getLong("id");
//        Customer customer = customerService.getCustomer(id);
//        return new View("customer_show.jsp").addModel("customer", customer);
//    }
//
//    /**
//     * 进入 创建客户 界面
//     */
//    @Action("get:/customer_create")
//    public View create(Param param){
//        return new View("Customer_create.jsp");
//    }
//
//    /**
//     * 处理 创建客户 请求
//     */
//    @Action("get:/customer_create")
//    public Data createSubmit(Param param){
//        Map<String,Object>fieldMap = param.getMap();
//        boolean result = customerService.createCustomer(fieldMap);
//        return new Data(result);
//    }
//
//    /**
//     * 进入 编辑客户 页面
//     */
//    @Action("get:/customer_edit")
//    public View edit(Param param){
//        long id = param.getLong("id");
//        Customer customer = customerService.getCustomer(id);
//        return new View("customer_edit.jsp").addModel("customer",customer);
//    }
//
//    /**
//     * 处理 编辑客户 请求
//     */
//    @Action("put:/customer_edit")
//    public Data editSubmit(Param param){
//        long id = param.getLong("id");
//        Map<String,Object>fieldMap = param.getMap();
//        boolean result = customerService.updateCustomer(id,fieldMap);
//        return new Data(result);
//    }
//
//    /**
//     * 处理 删除客户 请求
//     */
//    @Action("delete:/customer_edit")
//    public Data delete(Param param){
//        long id = param.getLong("id");
//        boolean result = customerService.deleteCustomer(id);
//        return new Data(result);
//    }
//}
