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

package org.limbo.flowjob.tracker.core.schedule;

/**
 * 可执行对象
 *
 * @param <T> 可执行对象执行时所需的上下文
 * @author Brozen
 * @since 2021-07-13
 */
public interface Executable<T> {

    /**
     * 获取执行上下文
     */
    default T getContext() {
        throw new UnsupportedOperationException();
    }

}
