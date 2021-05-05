package com.ccarlos.rabbit.common.serializer.impl;

import com.ccarlos.rabbit.common.serializer.Serializer;
import com.ccarlos.rabbit.common.serializer.SerializerFactory;
import com.ccarlos.rabbit.api.Message;

public class JacksonSerializerFactory implements SerializerFactory {

	/** 单例模式 */
	public static final SerializerFactory INSTANCE = new JacksonSerializerFactory();
	
	@Override
	public Serializer create() {
		return JacksonSerializer.createParametricType(Message.class);
	}

}
