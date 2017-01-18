/*
 * Copyright (C) 2015 Square, Inc.
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
package com.pj.mvp.api.support;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.pj.mvp.model.base.HttpResult;
import com.pj.mvp.utils.DesUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLDecoder;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 自定义gson适配器的GsonResponseBodyConverter
 * 返回解密及返回参数定义的成功失败等统一参数的处理
 * @param <T>
 */
final class CustomGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
  private final Gson gson;
  private final TypeAdapter<T> adapter;
  private static final Charset UTF_8 = Charset.forName("UTF-8");

  CustomGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
    this.gson = gson;
    this.adapter = adapter;
  }

  @Override public T convert(ResponseBody value) throws IOException {
    //ResponseBody的string只能读取一次
    String result = value.string();
    String responseBody = URLDecoder.decode(DesUtil.decrypt(result), "utf-8");
    new LoggerImpl().log(responseBody);
    HttpResult httpResult = new Gson().fromJson(responseBody,HttpResult.class);
    if(!httpResult.isSuccess()){
      value.close();
      throw new ApiException(httpResult.getState(),httpResult.getMessage());
    }
    //处理统一返回结果
    InputStream inputStream = new ByteArrayInputStream(responseBody.getBytes());
    Reader reader = new InputStreamReader(inputStream, UTF_8);
    JsonReader jsonReader = gson.newJsonReader(reader);
    try {
      return adapter.read(jsonReader);
    } finally {
      value.close();
    }
  }
}
