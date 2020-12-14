package com.kk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtil {


    public static String getJson(Object o){
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static String getJson(Object o, String dataForm){
        ObjectMapper mapper = new ObjectMapper();

        //关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        //自定义时间格式

        SimpleDateFormat sdf = new SimpleDateFormat(dataForm);
        mapper.setDateFormat(sdf);
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
