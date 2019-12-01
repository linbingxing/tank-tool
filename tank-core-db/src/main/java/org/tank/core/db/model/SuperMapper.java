package org.tank.core.db.model;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
  * @description mapper 父类，注意这个类不要让 mp 扫描到！！
  * @author lbx
  * @date 2019/12/1 17:36
  * @version 1.0.0
 **/
public interface SuperMapper<T> extends BaseMapper<T> {

    //todo 后面需要可以放公共方法

}
