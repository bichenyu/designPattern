import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class myAgent  {
    public static  void premain(String agentArgs, Instrumentation instrumentation){
      ClassFileTransformer classFileTransformer=new myTransformer();
      instrumentation.addTransformer(classFileTransformer);
    }


}



