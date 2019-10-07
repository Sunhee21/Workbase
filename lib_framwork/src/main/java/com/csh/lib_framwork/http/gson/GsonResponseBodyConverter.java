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
package com.csh.lib_framwork.http.gson;

import com.csh.lib_framwork.http.ApiConfig;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Converter;

import java.io.IOException;
import java.lang.reflect.Type;

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, Type type) {
        this.gson = gson;
        this.adapter = adapter;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String str = value.string();
        try {
            JSONObject jo = new JSONObject(str);

            if (jo.has("msg") && jo.has("code")) {
                String msg = jo.getString("msg");
                int code = jo.getInt("code");
                if (code != ApiConfig.apiConfigImpl.getSuccessCode()) {
                    if (jo.has("data"))
                        throw new DataResultException(code, msg, jo.getString("data"));
                    else
                        throw new DataResultException(code, msg, null);
                } else {
//                    JsonReader jsonReader =
                    try {
                        T result = gson.fromJson(str, type);
//                        if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
//                            throw new JsonIOException("JSON document was not fully consumed.");
//                        }
                        return result;
                    } finally {
                        value.close();
                    }
                }
            }

        } catch (JSONException je) {
            throw new JsonIOException("数据解析错误");
        }
        return null;
    }
}
