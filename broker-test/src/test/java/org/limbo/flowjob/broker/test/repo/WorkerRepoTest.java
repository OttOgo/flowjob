/*
 *
 *  * Copyright 2020-2024 Limbo Team (https://github.com/limbo-world).
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * 	http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.limbo.flowjob.broker.test.repo;

import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.limbo.flowjob.broker.dao.entity.WorkerEntity;
import org.limbo.flowjob.broker.dao.entity.WorkerExecutorEntity;
import org.limbo.flowjob.broker.dao.repositories.WorkerEntityRepo;
import org.limbo.flowjob.broker.dao.repositories.WorkerExecutorEntityRepo;
import org.limbo.flowjob.broker.dao.support.DBFieldHelper;
import org.limbo.flowjob.common.constants.WorkerStatus;
import org.limbo.flowjob.common.utils.json.JacksonUtils;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Devil
 * @since 2022/6/24
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WorkerRepoTest {

    @Setter(onMethod_ = @Inject)
    private WorkerExecutorEntityRepo workerExecutorEntityRepo;

    @Setter(onMethod_ = @Inject)
    private WorkerEntityRepo workerEntityRepo;

    @Test
    public void findExecutor() {
        List<WorkerExecutorEntity> workerExecutorEntities = workerExecutorEntityRepo.findByWorkerId(1234566L);
        System.out.println(JacksonUtils.toJSONString(workerExecutorEntities));
    }

    @Test
    public void findWorker() {
        List<WorkerEntity> byStatusAndDeleted = workerEntityRepo.findByStatusAndIsDeleted(WorkerStatus.RUNNING.status, DBFieldHelper.FALSE_LONG);
        for (WorkerEntity workerEntity : byStatusAndDeleted) {
            System.out.println(workerEntity.getId() + " " + workerEntity.getStatus() + workerEntity.isDeleted());
        }
    }

    @Test
    @Transactional
    public void delete() {
        int d = workerExecutorEntityRepo.deleteByWorkerId(1234566L);
        System.out.println(d);
    }

}
