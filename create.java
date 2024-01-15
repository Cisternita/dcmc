package dynamic;
import org.objectweb.asm.*;
import java.util.Map;
public class create {
    public static ClassWriter Class(String name, String superClass, String interfaces)throws Exception{
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        if (superClass.equals("0")){
            superClass = "java/lang/Object";
        }
        if (interfaces.equals("0")){
            interfaces.equals(null);
        }
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, name, null, superClass, null);
        cw.visitEnd();
        return cw;
    }
    public static void Attribute(ClassWriter cw, Map<String, String> attributes){
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            String attributeName = entry.getKey();
            String attributeType = entry.getValue();
            // Añade el atributo a la clase con los modificadores necesarios
            cw.visitField(Opcodes.ACC_PUBLIC, attributeName, functions.asmType(attributeType), null, null);
            cw.visitEnd();
        }
    }
}