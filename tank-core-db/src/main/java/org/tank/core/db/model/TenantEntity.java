package org.tank.core.db.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
  * @description 租户基础实体类
  * @author lbx
  * @date 2019/12/1 17:31
  * @version 1.0.0
 **/
@Data
public class TenantEntity extends SuperEntity {

    /**
     * 租户ID
     */
    @ApiModelProperty(value = "租户ID")
    private String tenantId;


}
