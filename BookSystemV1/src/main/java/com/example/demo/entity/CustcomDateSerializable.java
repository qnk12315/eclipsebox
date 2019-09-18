package com.example.demo.entity;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 自定义返回json,日期格式化处理
 * @author qnk12
 *
 */
public class CustcomDateSerializable extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) 
			throws IOException,JsonProcessingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		gen.writeString(sdf.format(value));
	}
	
}
