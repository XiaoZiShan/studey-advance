package studey.advance.basearithmetic.lambda;

import net.sf.cglib.beans.BeanCopier;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {


    /**
     * @param object 已赋值的bean
     * @param cls    待赋值的bean的class
     * @return 返回复制后的目标bean
     * @throws Exception
     * @Title: beanTobeanLowerCase
     * @Description: 对象bean间属性值复制：无视大小写和下划线_
     */
    public static Object beanTobeanLowerCase(Object object, Class<?> cls) throws Exception {
        Object obj = cls.newInstance();
        if (object != null) {
            Class<?> clsOld = object.getClass();
            Field[] fieldsOld = clsOld.getDeclaredFields();
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field fieldOld : fieldsOld) {
                String fieldNameOld = fieldOld.getName().replace("_", "");
                fieldNameOld = fieldNameOld.replace("", "");
                int modOld = fieldOld.getModifiers();
                if (Modifier.isPrivate(modOld) && !Modifier.isFinal(modOld)) {
                    fieldOld.setAccessible(true);
                    for (Field field : fields) {
                        String fieldName = field.getName().replace("_", "");
                        fieldName = field.getName().replace("", "");
                        int mod = field.getModifiers();
                        if (Modifier.isPrivate(mod) && !Modifier.isFinal(mod)) {
                            field.setAccessible(true);
                            if (fieldNameOld.equalsIgnoreCase(fieldName)) {
                                field.set(obj, fieldOld.get(object));
                            }
                        }
                    }
                }
            }
        }
        return obj;
    }

    /**
     * 拷贝list
     *
     * @param dest 待赋值
     * @param orig 已赋值
     * @return
     */
    public static <T> List<T> copyList(Class<T> dest, List orig) {
        if (orig.isEmpty()) {
            return new ArrayList<>();
        }
        BeanCopier beanCopier = BeanCopier.create(orig.get(0).getClass(),dest,false);
        List<T> resultList = new ArrayList<>(orig.size());
        try {
            for (Object o : orig) {
                if (o == null) {continue;}

                T destObject = dest.newInstance();

                beanCopier.copy(o,destObject,null);
                resultList.add(destObject);
            }
            return resultList;
        } catch (Exception e) {
        }
        return resultList;
    }

    /**
     * 拷贝vo
     *
     * @param dest 待赋值 class
     * @param orig 已赋值
     * @return
     */
    public static <T> T copyProperties(Class<T> dest, Object orig) {
        if (orig == null) {
            return null;
        }
        try {
            T destObject = dest.newInstance();
            copyProperties(destObject, orig);
            return destObject;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 拷贝 object
     *
     * @param dest 待赋值 object
     * @param orig 已赋值
     * @return
     */
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanCopier copier = BeanCopier.create(orig.getClass(), dest.getClass(), false);
            copier.copy(orig, dest,null);
        } catch (Exception e) {
        }
    }

}
