package org.tank.core.db.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.tank.core.tool.lock.DistributedLock;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
  * @description 业务封装基础类
  * @author lbx
  * @date 2019/12/1 17:23
  * @version 1.0.0
 **/
@Validated
public class SuperServiceImpl<M extends BaseMapper<T>, T extends SuperEntity> extends ServiceImpl<M, T> implements SuperService<T> {
    /**
     * 逻辑删除
     * @param ids       实体对象
     * @return
     */
    @Override
    public boolean deleteLogic(@NotEmpty List<Integer> ids) {
        return super.removeByIds(ids);
    }

    /**
     * 幂等性新增记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    @Override
    public boolean saveByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper, String msg) {
        return false;
    }
    /**
     * 幂等性新增记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @return
     */
    @Override
    public boolean saveByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper) {
        return this.saveByLock(entity,lock,lockKey,countWrapper,null);
    }
    /**
     * 幂等性新增记录
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @return
     */
    @Override
    public boolean saveByLock(T entity, DistributedLock lock, String lockKey) {
        return this.saveByLock(entity,lock,lockKey,null,null);
    }
    /**
     * 幂等性新增或更新记录
     * 例子如下：
     * String username = sysUser.getUsername();
     * boolean result = super.saveOrUpdateIdempotency(sysUser, lock
     *                 , LOCK_KEY_USERNAME+username
     *                 , new QueryWrapper<SysUser>().eq("username", username));
     *
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @param msg          对象已存在提示信息
     * @return
     */
    @Override
    public boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper, String msg) {
        return false;
    }
    /**
     * 幂等性新增或更新记录
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @param countWrapper 判断是否存在的条件
     * @return
     */
    @Override
    public boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey, Wrapper<T> countWrapper) {
        return this.saveOrUpdateByLock(entity,lock,lockKey,countWrapper,null);
    }
    /**
     * 幂等性新增或更新记录
     * @param entity       实体对象
     * @param lock         锁实例
     * @param lockKey      锁的key
     * @return
     */
    @Override
    public boolean saveOrUpdateByLock(T entity, DistributedLock lock, String lockKey) {
        return this.saveOrUpdateByLock(entity,lock,lockKey,null,null);
    }
}
