package org.tank.core.db.model;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.tank.core.tool.utils.DateUtil;

import java.util.Date;

/**
  * @description 基础实体类
  * @author lbx
  * @date 2019/12/1 17:24
  * @version 1.0.0
 **/
@Data
public class SuperEntity {

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private Long createId;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建名称")
    private Long createName;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private Long updateId;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private Long updateName;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = DateUtil.PATTERN_DATETIME)
    @JsonFormat(pattern = DateUtil.PATTERN_DATETIME)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 状态[0:未删除,1:删除]
     */
    @TableLogic
    @ApiModelProperty(value = "是否已删除")
    private Integer delFlag;
}
