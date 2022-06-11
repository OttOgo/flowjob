package org.limbo.flowjob.broker.dao.converter;

import com.google.common.base.Converter;
import org.limbo.flowjob.broker.api.constants.enums.JobScheduleStatus;
import org.limbo.flowjob.broker.core.plan.job.context.JobRecord;
import org.limbo.flowjob.broker.core.utils.TimeUtil;
import org.limbo.flowjob.broker.dao.entity.JobInstancePO;
import org.springframework.stereotype.Component;

/**
 * @author Devil
 * @since 2021/7/24
 */
@Component
public class JobRecordPoConverter extends Converter<JobRecord, JobInstancePO> {

    @Override
    protected JobInstancePO doForward(JobRecord record) {
        JobInstancePO po = new JobInstancePO();
        JobRecord.ID recordId = record.getId();
        po.setPlanId(recordId.planId);
        po.setPlanRecordId(recordId.planRecordId);
        po.setPlanInstanceId(recordId.planInstanceId);
        po.setJobId(recordId.jobId);
        po.setState(record.getState().status);
        po.setAttributes(record.getAttributes());
        po.setStartAt(TimeUtil.toLocalDateTime(record.getStartAt()));
        po.setEndAt(TimeUtil.toLocalDateTime(record.getEndAt()));
        return po;
    }

    @Override
    protected JobRecord doBackward(JobInstancePO po) {
        JobRecord record = new JobRecord();
        JobRecord.ID recordId = new JobRecord.ID(
                po.getPlanId(),
                po.getPlanRecordId(),
                po.getPlanInstanceId(),
                po.getJobId()
        );
        record.setId(recordId);
        record.setState(JobScheduleStatus.parse(po.getState()));
        record.setAttributes(record.getAttributes());
        record.setStartAt(TimeUtil.toInstant(po.getStartAt()));
        record.setEndAt(TimeUtil.toInstant(po.getEndAt()));
        return record;
    }

}
