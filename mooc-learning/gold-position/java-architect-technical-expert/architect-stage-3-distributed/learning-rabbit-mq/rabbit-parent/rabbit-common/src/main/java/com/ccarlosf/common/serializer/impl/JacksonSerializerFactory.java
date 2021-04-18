package com.ccarlosf.common.serializer.impl;

import com.ccarlosf.common.serializer.Serializer;
import com.ccarlosf.common.serializer.SerializerFactory;
import com.ccarlosf.rabbit.api.Message;

public class JacksonSerializerFactory implements SerializerFactory {

	/** 单例模式 */
	public static final SerializerFactory INSTANCE = new JacksonSerializerFactory();
	
	@Override
	public Serializer create() {
		return JacksonSerializer.createParametricType(Message.class);
	}

}
