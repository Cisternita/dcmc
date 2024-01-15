package dynamic;
import java.lang.reflect.Field;
public class access {
    public static String Key(Object object, String Attribute) throws Exception {
        Field field = object.getClass().getDeclaredField(Attribute);
        return field.getName().toString();
    }
    public static String Value(Object object, String Attribute) throws Exception {
        Field field = object.getClass().getDeclaredField(Attribute);
        if (field.get(object) == null) {
            return "null";
        }
        return field.get(object).toString();
    }
    public static void replace(Object object, String Attribute,  Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(Attribute);
        Class<?> fieldType = field.getType();
        if (fieldType.equals(int.class)) {
            if (value instanceof String) {
                int intValue = Integer.parseInt((String) value);
                field.setInt(object, intValue);
            } else {
                throw new IllegalArgumentException("Tipo de dato incompatible para el atributo " + Attribute + ". Se esperaba un valor de tipo int.");
            }
        } else if (fieldType.equals(float.class)) {
            if (value instanceof Float) {
                field.setFloat(object, (float) value);
            } else {
                throw new IllegalArgumentException("Tipo de dato incompatible para el atributo " + Attribute + ". Se esperaba un valor de tipo float.");
            }
        } else if (fieldType.equals(double.class)) {
            if (value instanceof Double) {
                field.setDouble(object, (double) value);
            } else {
                throw new IllegalArgumentException("Tipo de dato incompatible para el atributo " + Attribute + ". Se esperaba un valor de tipo double.");
            }
        } else if (fieldType.equals(String.class)) {
            if (value instanceof String) {
                field.set(object, value);
            } else {
                throw new IllegalArgumentException("Tipo de dato incompatible para el atributo " + Attribute + ". Se esperaba un valor de tipo String.");
            }
        } else {
            throw new IllegalArgumentException("Tipo de dato no soportado para el atributo " + Attribute);
        }
    }

}
