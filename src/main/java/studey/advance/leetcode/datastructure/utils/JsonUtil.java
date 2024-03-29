package studey.advance.leetcode.datastructure.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;

public final class JsonUtil {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	/**
	 * 将 POJO 转为 JSON
	 */
	public static <T> String toJson(T obj) {
		String json;
		try {
            OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	/**
	 * 将 POJO 转为 JSON 带格式化
	 */
	public static <T> String toJsonPretty(T obj) {
		String json;
		try {
            OBJECT_MAPPER.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
            json = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	/**
	 * 将 JSON 转为 POJO
	 */
	public static <T> T toObject(String json, Class<T> type) {
		T pojo;
		try {
			pojo = OBJECT_MAPPER.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pojo;
	}

	/**
	 * 将 JSON 转为 List
	 */
	public static <T> T toList(String json, TypeReference<T> type) {
		try {
			// 忽略不存在的元素
			OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return OBJECT_MAPPER.readValue(json, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static <K, V> HashMap<K, V> toMap(String json, Class<K> keyType, Class<V> valueType) {
		try {
			// 忽略不存在的元素
			OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return OBJECT_MAPPER.readValue(json, new TypeReference<HashMap<K, V>>() {
			});
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * 根据 Object 判断属性是否为空, 不会向下递归判断.
     * @param o Object
     * @return String 属性为空或缺失都会返回 true, Numbers 属性为 0 或缺失都会返回 true, 全部属性不为 0 或不缺失返回 false
     */
    public static boolean allFieldIsNULL(Object o){
        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                Object object = field.get(o);
                if (object instanceof CharSequence) {
                } else {
                    if (null == object){
                        return true;
                    }

                    if (object instanceof Number){
                        if (0 == (Long) object){
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("判断Json 对象属性为空异常");
        }
        return false;
    }

}
