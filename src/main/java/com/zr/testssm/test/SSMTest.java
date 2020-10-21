package com.zr.testssm.test;

import com.zr.testssm.bean.Items;
import com.zr.testssm.dao.ItemsDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @ClassName : SSMTest  //类名
 * @Description : 测试类   //描述
 * @Author : Program_Dog  //作者
 * @Date: 2020-10-14 01:50  //时间
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:spring_mvc_context.xml"})
public class SSMTest {

    @Autowired
    WebApplicationContext context;

    MockMvc mockMvc;

    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void test01() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/qureyAll")).andReturn();
//        MockHttpServletRequest request = result.getRequest();
//        List<Items> items = (List<Items>) request.getAttribute("itemList");
//        for (Items item:items
//             ) {
//            System.out.println(item);
//        }
    }

    @Test
    public void test02(){

//		导入Spring核心配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		获取bean
        ItemsDao itemsDao = applicationContext.getBean(ItemsDao.class);
//		执行查询
        List<Items> items = itemsDao.qureyAll();
//		输出结果
        System.out.println(items);
    }
}
