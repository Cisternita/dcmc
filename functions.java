package dynamic;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import java.util.ArrayList;
import java.util.Map;
public class functions {
    public static String asmType(String DataType){
        if (DataType.equals("int")) {
            return Type.INT_TYPE.getDescriptor();
        } else if (DataType.equals("float")) {
            return Type.FLOAT_TYPE.getDescriptor();
        } else if (DataType.equals("double")) {
            return Type.DOUBLE_TYPE.getDescriptor();
        } else if (DataType.equals("String")) {
            return Type.getType(String.class).getDescriptor();
        } else if (DataType.equals("ArrayList")) {
            return Type.getType(ArrayList.class).getDescriptor();
        } else if (DataType.equals("Map")) {
            return Type.getType(Map.class).getDescriptor();
        } else if (DataType.equals("Object")) {
            return Type.getType(Object.class).getDescriptor();
        } else if (DataType.equals("boolean")) {
            return Type.BOOLEAN_TYPE.getDescriptor();
        } else if (DataType.equals("byte")) {
            return Type.BYTE_TYPE.getDescriptor();
        } else if (DataType.equals("char")) {
            return Type.CHAR_TYPE.getDescriptor();
        } else if (DataType.equals("short")) {
            return Type.SHORT_TYPE.getDescriptor();
        } else if (DataType.equals("long")) {
            return Type.LONG_TYPE.getDescriptor();
        } else if (DataType.equals("void")) {
            return Type.VOID_TYPE.getDescriptor();
        }
        return null;
    }
    public static class ClassLoad extends ClassLoader {
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }
    public static void voidConstructor(ClassWriter cw) {
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(Opcodes.ALOAD, 0); // Carga "this"
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false); // Invoca al constructor de la superclase (java.lang.Object)
        mv.visitInsn(Opcodes.RETURN); // Retorna desde el constructor
        mv.visitMaxs(1, 1); // Define los valores máximos de stack y variables locales
        mv.visitEnd();
    }
}
