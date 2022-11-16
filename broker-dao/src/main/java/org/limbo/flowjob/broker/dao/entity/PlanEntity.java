package org.limbo.flowjob.broker.dao.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.limbo.flowjob.broker.dao.support.DBFieldHelper;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * plan 计划
 *
 * @author Devil
 * @since 2021/7/23
 */
@Setter
@Getter
@Table(name = "flowjob_plan")
@Entity
@DynamicInsert
@DynamicUpdate
public class PlanEntity extends BaseEntity {
    private static final long serialVersionUID = -6323915044280199312L;
    /**
     * 所属应用
     */
    private Long appId;
    /**
     * 下次触发时间
     */
    private LocalDateTime nextTriggerAt;
    /**
     * 上次完成时间
     */
    private LocalDateTime lastFeedbackAt;
    /**
     * 当前版本。可能发生回滚，因此 currentVersion 可能小于 recentlyVersion 。
     * 对应 planInfo-id
     */
    private Long currentVersion;

    /**
     * 最新版本
     * 对应 planInfo-id
     */
    private Long recentlyVersion;

    /**
     * 是否启动 新建plan的时候 默认为不启动
     * 接口调用的时候会修改 leader 内存数据以及 db数据 需要保障一致性
     */
    @Getter(AccessLevel.NONE)
    private Long isEnabled;

    public boolean isEnabled() {
        return DBFieldHelper.greaterThanZero(isEnabled);
    }
}
