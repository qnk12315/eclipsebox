package com.example.demo.entity;
/**
 * 自定义返回json,日期格式化处理
 * @author qnk12
 *
 */
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class CustcomDateTimeSerializable extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) 
			throws IOException,JsonProcessingException  {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		gen.writeString(sdf.format(value));
		
	}

}	
