/*
 * Copyright 2020-2024 Limbo Team (https://github.com/limbo-world).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.limbo.flowjob.tracker.core.dispatcher.strategies;

import org.limbo.flowjob.broker.api.constants.enums.LoadBalanceType;
import org.limbo.flowjob.tracker.core.dispatcher.WorkerSelector;
import org.limbo.flowjob.tracker.core.job.context.Task;
import org.limbo.flowjob.tracker.core.tracker.worker.Worker;

import java.util.Collection;

/**
 * 轮询作业分发器。
 * TODO
 *
 * @author Brozen
 * @since 2021-05-19
 * @see LoadBalanceType#ROUND_ROBIN
 */
public class RoundRobinWorkerSelector extends AbstractWorkerSelector implements WorkerSelector {

    /**
     * {@inheritDoc}
     * @param context 待下发的作业上下文
     * @param workers 待下发上下文可用的worker
     * @return
     */
    @Override
    protected Worker selectWorker(Task context, Collection<Worker> workers) {
        // TODO
        return workers.iterator().next();
    }

}
