package com.pde.pdes.portal.notify.service.impl;

import com.pde.Application;
import com.pde.pdes.portal.notify.po.PortalNotify;
import com.pde.pdes.portal.notify.service.PortalNotifyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author: jiangyiheng
 * @date: 2022/12/21
 * @description: 公告 notify service 测试类
 */

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class PortalNotifyServiceImplTest {

    @Resource
    private PortalNotifyService portalNotifyServiceImplUnderTest;


    /**
     * 分页进行模糊查询
     */
    @Test
    public void testFind() {

        // Run the test
        final List<PortalNotify> result = portalNotifyServiceImplUnderTest.find("14");

        // Verify the results
        System.out.println(result);

    }

    /**
     * 模糊查询未发布公告
     */
    @Test
    public void testFindDisablePublish() {

        // Run the test
        final List<PortalNotify> result = portalNotifyServiceImplUnderTest.findDisablePublish("14");

        // Verify the results
        System.out.println(result);

    }

    /**
     * 根据id 删除对应的公告
     */
    @Test
    public void testDeleteById() {

        // Run the test
        final boolean result = portalNotifyServiceImplUnderTest.deleteById("58");

        // Verify the results
        System.out.println(result);

    }

    /**
     * 进行对于公告的添加
     */
    @Test
    public void testAdd() {
        // Setup
        final PortalNotify portalNotify = new PortalNotify();
        portalNotify.setId(0);
        portalNotify.setTitle("title");
        portalNotify.setContent("content");
        portalNotify.setContentAbstract("contentAbstract");
        portalNotify.setEnablePublish(0);
        portalNotify.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        portalNotify.setModifiedTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final boolean result = portalNotifyServiceImplUnderTest.add(portalNotify);

        // Verify the results
        System.out.println(result);

    }

    /**
     * 对于公告数据的更新
     */
    @Test
    public void testUpdatePortalNotify() {
        // Setup
        final PortalNotify portalNotify = new PortalNotify();
        portalNotify.setId(59);
        portalNotify.setTitle("title11111111111");
        portalNotify.setContent("content");
        portalNotify.setContentAbstract("contentAbstract");
        portalNotify.setEnablePublish(0);
        portalNotify.setCreateTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        portalNotify.setModifiedTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());

        // Run the test
        final boolean result = portalNotifyServiceImplUnderTest.updatePortalNotify(portalNotify);

        // Verify the results
        System.out.println(result);
    }

    /**
     * 公告的批量删除
     */
    @Test
    public void testDeleteBatchByIds() {

        // Run the test
        final Integer result = portalNotifyServiceImplUnderTest.deleteBatchByIds(Arrays.asList(0));

        // Verify the results
        System.out.println(result);

    }

    /**
     * 根据id 查询公告
     */
    @Test
    public void testSelectById() {

        // Run the test
        final PortalNotify result = portalNotifyServiceImplUnderTest.selectById(59);

        // Verify the results
        System.out.println(result);
    }
}
