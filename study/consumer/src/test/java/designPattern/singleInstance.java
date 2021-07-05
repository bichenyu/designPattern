package designPattern;

public class singleInstance {
    public static void main(String[] args) {
        enumDemo s1 = enumDemo.getInstance();
        enumDemo s2 = enumDemo.getInstance();
        System.out.println(s1 == s2);
    }
    /**
     * 饿汉式
     */
    static class demo{
        private static demo instance =new demo();
        private demo(){
            System.out.print("饿汉式构造器初始化");
        }
        public static demo getInstance(){
            return instance;
        }
    }
    /**
     * 懒汉式
     */
    static class lazyDemo{
        private static lazyDemo instance;
        public static lazyDemo getInstance(){
            if(instance==null){
                instance=new lazyDemo();
            }
            return  instance;
        }
        private  lazyDemo(){
            System.out.print("懒汉式单例模式");
        }
    }
    /**
     * 静态内部类
     */
    static class  innerDemo{
        private innerDemo(){
            System.out.print("静态内部类");
        }
        static class  inInnerDemo{
            private static final innerDemo instance=new innerDemo();
        }
        public static innerDemo getInstance(){
            return inInnerDemo.instance;
        }
    }
    /**
     * 枚举
     */
    static class enumDemo{
        public static enumDemo getInstance(){
            return Demo.INSTANCE.getInstance();
        }
        private static enum Demo{
            INSTANCE;
            private enumDemo enumdemo;
            private Demo(){
                System.out.print("枚举类");
                enumdemo=new enumDemo();
            }
            public enumDemo getInstance(){
                return enumdemo;
            }
        }
    }
    /**
     * 双重检测锁
     */
    static class doubleCheckDemo{
        private  static volatile doubleCheckDemo dcd;//禁止指令重排
        private doubleCheckDemo(){
            System.out.print("双重检测");
        }
        public static doubleCheckDemo getInstance(){
            if(dcd==null){
                synchronized (doubleCheckDemo.class){
                    if(dcd==null){
                        dcd=new doubleCheckDemo();
                    }
                }
            }
            return  dcd;
        }
    }
}
