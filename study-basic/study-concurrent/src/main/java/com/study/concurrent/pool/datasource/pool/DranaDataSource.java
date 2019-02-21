package com.study.concurrent.pool.datasource.pool;

import com.dranawhite.common.common.ThreadUnit;
import com.dranawhite.common.exception.DranaRuntimeException;

import java.util.Random;

/**
 * @author liangyuquan
 * @version $Id: DranaDataSource.java, v 0.1 2019-02-19 18:46 liangyuquan Exp $$
 */
public class DranaDataSource {

    private BlockedConnectionPool pool;

    public void initConnectionPool() {
        pool = new BlockedConnectionPool(30, 50, 100, 10, 300);
        pool.startPoolDestroyer();
    }

    public void execute(String connType) {
        ConnectionHolder connectionHolder = null;
        try {
            long startTime = System.currentTimeMillis();
            connectionHolder = pool.borrow(connType);
            if (!connectionHolder.using.compareAndSet(true, false)) {
                System.out.println("空的连接，ConnType = " + connType + "; Id: " + connectionHolder.getId());
            }
            connectionHolder.getConnection();
            long endTime = System.currentTimeMillis();
            // 模拟耗时操作
            Random random = new Random(12);
            System.out.println("获取连接: ConnType = " + connType + "; Id: " + connectionHolder.getId() +
                    "; CostTime: " + (endTime - startTime) + "ms");
            ThreadUnit.sleep(random.nextInt(12));
        } catch (DranaRuntimeException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (connectionHolder != null) {
                if (!connectionHolder.using.compareAndSet(false, true)) {
                    System.out.println("空的连接释放，ConnType = " + connType + "; Id: " + connectionHolder.getId());
                }
                pool.release(connectionHolder);
            }
        }
    }
}
