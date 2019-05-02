package org.capljf.bigspring.common;

import org.capljf.bigspring.BigspringApplicationTests;
import org.capljf.bigspring.common.async.Task;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * @author jifang.liu created on 2019/5/2 16:27
 */
public class AsyncTests extends BigspringApplicationTests {

    @Resource
    private Task task;

    @Test
    public void test() throws Exception {

        long start = System.currentTimeMillis();

        Future<String> task1 = task.doTaskOne();
        Future<String> task2 = task.doTaskTwo();
        Future<String> task3 = task.doTaskThree();

        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        long end = System.currentTimeMillis();

        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }

}
