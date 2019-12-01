package org.tank.core.db.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.tank.core.tool.lock.DistributedLock;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @interfaceName SuperService
 * @Description 基础业务接口
 * @Author lbx
 * @Date 2019/12/1 17:23
 * @Version 1.0.0
 **/
public interface SuperService<T> extends IService<T> {
    /**
     * 逻辑删除
     *
     * @param ids id集合(逗号分隔)
     * @return
     */
    boolean deleteLogic(@NotEmpty List<Integer> ids);
    /**
     * 幂等性新增记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper, String msg);
    /**
     * 幂等性新增记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @return
     */
    boolean saveByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper);
    /**
     * 幂等性新增记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @return
     */
    boolean saveByLock(T entity, DistributedLock lock, String lockKey);

    /**
     * 幂等性新增或更新记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper, String msg);

    /**
     * 幂等性新增或更新记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @return
     */
    boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper);
    /**
     * 幂等性新增或更新记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @return
     */
    boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey);

}
