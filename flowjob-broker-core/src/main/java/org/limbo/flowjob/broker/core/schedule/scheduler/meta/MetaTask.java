/*
 * Copyright 2020-2024 Limbo Team (https://github.com/limbo-world).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.limbo.flowjob.broker.core.schedule.scheduler.meta;

import org.limbo.flowjob.broker.core.schedule.Scheduled;

/**
 * @author Brozen
 * @since 2022-10-11
 */
public interface MetaTask extends Scheduled {

    /**
     * @return 任务类型
     */
    MetaTaskType getType();

    /**
     * @return 任务id
     */
    String getMetaId();

    default String scheduleId() {
        return getType().name() + "-" + getMetaId();
    }

}
