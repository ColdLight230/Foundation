package java_knowledge;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

class SupperClass<T> {

}

class SubClass extends SupperClass<String> {
    public List<Map<String, Integer>> getValue() {
        return null;
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        // 可以获取类泛型的具体类型
        ParameterizedType superType = (ParameterizedType) SubClass.class.getGenericSuperclass();
        for (Type type : superType.getActualTypeArguments()) {
            System.out.println(type);
        }
        try {
            // 可以获取方法声明泛型的具体类型
            ParameterizedType superType3 = (ParameterizedType) SubClass.class.getMethod("getValue").getGenericReturnType();
            for (Type type : superType3.getActualTypeArguments()) {
                System.out.println(type);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
