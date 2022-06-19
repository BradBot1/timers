package fun.bb1.timers.scheduler;

import java.util.HashSet;
import java.util.Set;

import fun.bb1.timers.AbstractTimer;

/**
 * Copyright 2022 BradBot_1
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * @author BradBot_1
 *
 */
public class TaskSet extends java.util.concurrent.ConcurrentHashMap<ITask, AbstractTimer> {

	private static final long serialVersionUID = -8543061263875521464L;
	
	public Set<ITask> getReadyTasks() {
		Set<ITask> tasks = new HashSet<ITask>();
		for (Entry<ITask, AbstractTimer> entry : entrySet()) {
			if (entry.getValue().hasEnded()) {
				tasks.add(entry.getKey());
				remove(entry.getKey());
			}
		}
		return tasks;
	}
	
}
