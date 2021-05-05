package com.ccarlos.rabbit.producer.task;

import java.util.List;

import com.ccarlos.rabbit.producer.broker.RabbitBroker;
import com.ccarlos.rabbit.producer.entity.BrokerMessage;
import com.ccarlos.rabbit.producer.service.MessageStoreService;
import com.ccarlos.rabbit.task.annotation.ElasticJobConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;

import lombok.extern.slf4j.Slf4j;

@Component
@ElasticJobConfig(
		name= "com.ccarlos.rabbit.producer.task.RetryMessageDataflowJob",
		cron= "0/10 * * * * ?",
		description = "可靠性投递消息补偿任务",
		overwrite = true,
		shardingTotalCount = 2
		)
@Slf4j
public class RetryMessageDataflowJob implements DataflowJob<BrokerMessage>{

	@Autowired
	private MessageStoreService messageStoreService;
	
	@Autowired
	private RabbitBroker rabbitBroker;
	
	private static final int MAX_RETRY_COUNT = 3;
	
	@Override
	public List<BrokerMessage> fetchData(ShardingContext shardingContext) {
		return null;
	}

	@Override
	public void processData(ShardingContext shardingContext, List<BrokerMessage> dataList) {
	}
	
	

}
