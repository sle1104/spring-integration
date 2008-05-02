/*
 * Copyright 2002-2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.channel.factory;


import org.springframework.integration.channel.AbstractMessageChannel;
import org.springframework.integration.channel.DispatcherPolicy;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.util.Assert;

/**
 * Default implementation of a {@link ChannelFactory}, which will create instances of a
 * {@link QueueChannel}. 
 * 
 * @author Marius Bogoevici
 */
public class QueueChannelFactory extends AbstractChannelFactory{

	int queueCapacity = QueueChannel.DEFAULT_CAPACITY;
		
	public int getQueueCapacity() {
		return queueCapacity;
	}

	/**
	 * Sets the queue capacity for the newly created channels.
	 * By default, the queue capacity is {@literal QueueChannel.DEFAULT_CAPACITY}
	 * @param queueCapacity
	 */
	public void setQueueCapacity(int queueCapacity) {
		Assert.state(queueCapacity > 0, "Queue capacity must be greater than zero");
		this.queueCapacity = queueCapacity;
	}

	protected AbstractMessageChannel createChannelInternal(DispatcherPolicy dispatcherPolicy) {
		return  new QueueChannel(queueCapacity, dispatcherPolicy);
	}

}
