package designPattern;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyPattern {
    public static  void main(String[] args) {
//        UserDao userDao = new UserDao();
//        userDaoProxy userDaoProxy = new userDaoProxy(userDao);
//        userDaoProxy.save();
        //*******************************************
//        userDao1 userDao1Impl=new userDaoImpl();
//        InvocationHandleImpl in=new InvocationHandleImpl(userDao1Impl);
//        ClassLoader loader=userDao1Impl.getClass().getClassLoader();
//        Class<?>[]  interfaces=userDao1Impl.getClass().getInterfaces();
//
//        userDao1 newproxy= (userDao1) Proxy.newProxyInstance(loader,interfaces,in);
//        newproxy.save();
//        newproxy.delete();
        //*******************************

        CglibProxy cglibProxy = new CglibProxy();
        userDao1 userDao = (userDao1) cglibProxy.getInstance(new userDaoImpl());
        userDao.save();
    }
    /**
     * spring AOP 日志打印 异常处理 事务控制 权限控制
     */
    /**
     * 静态代理 每个需要代理的对象都需要手动建立对象类，
     */
    static class UserDao{
        public void save(){
            System.out.print("保存");
        }
    }
    static  class userDaoProxy{
        private UserDao userDao;
        public userDaoProxy(UserDao userDao){
            this.userDao=userDao;
        }
        public void save() {
            System.out.println("开启事物...");
            userDao.save();
            System.out.println("关闭事物...");
        }
    }
    /**
     * 动态代理  JDK代理
     */
    interface userDao1{
        void save();
        void delete();
    }
    static class userDaoImpl implements  userDao1{

        @Override
        public void save() {
            System.out.println("动态代理保存");
        }

        @Override
        public void delete() {
            System.out.println("动态代理删除");
        }
    }
    static class InvocationHandleImpl implements InvocationHandler{
        private Object target;

        // 通过构造函数传入目标对象
        public  InvocationHandleImpl(Object target) {
            this.target = target;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("调用开始处理");
            //下面invoke()方法是以反射的方式来创建对象，第一个参数是要创建的对象，第二个是构成方法的参数，由第二个参数来决定创建对象使用哪个构造方法
            Object result = method.invoke(target, args);
            System.out.println("调用结束处理");
            return result;
        }
    }

    /**
     * cglib动态代理  和jdk一样，使用反射完成，不同的是 可知直接代理类，jdk代理是需要 目标类实现接口
     */
    static class CglibProxy{
        private Object targetObject;
        public Object getInstance(Object targetObject){
            this.targetObject=targetObject;
            Enhancer enhancer=new Enhancer();
            enhancer.setSuperclass(targetObject.getClass());
            enhancer.setCallback(new org.springframework.cglib.proxy.MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    System.out.println("开启事物");
                    Object res = methodProxy.invokeSuper(o, objects);
                    System.out.println("关闭事物");
                    return res;
                }
            });
            return  enhancer.create();
        }
    }
}
