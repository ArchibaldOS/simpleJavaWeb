package org.smart4j.chapter2.test;

/**
 * @author Archibald
 * @version:
 * @time: 6/4/2017.
 */

/**
 * 单元测试各单元相互独立，大概不需要指定@test的执行顺序？
 * 如果需要指定@test的执行顺序，则可调用以下两个注释
 *  @FixMethodOrder(MethodSorters.JVM): 根据JVM返回的顺序来决定test方法的执行顺序。每次测试这个顺序可能都不一样
    @FixMethodOrder(MethodSorters.NAME_ASCENDING): 根据test方法名按照字典顺序升序排序

 * JUnit4通过注解的方式来识别测试方法。目前支持的主要注解有：
 @BeforeClass 全局只会执行一次，而且是第一个运行
 @Before 在测试方法运行之前运行
 @Test 测试方法
 @After 在测试方法运行之后允许
 @AfterClass 全局只会执行一次，而且是最后一个运行
 @Ignore 忽略此方法
 */

import org.junit.*;

import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;
import java.util.*;

/**
 * 单元测试
 */

public class CustomerServiceTest {

    private final CustomerService customerService;


    public CustomerServiceTest() {
        this.customerService = new CustomerService();
    }

    @BeforeClass
    public static void init() throws Exception {
      DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerListTest()throws Exception{
        List<Customer>customerList = customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String,Object>fieldMap = new HashMap<String,Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","123456789");
        boolean result = customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest() throws Exception{
        long id = 1;
        Map<String,Object>fieldMap = new HashMap<String,Object>();
        fieldMap.put("contact","Eric");
        boolean result = customerService.updateCustomer(id,fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest() throws Exception{
        long id = 2;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
