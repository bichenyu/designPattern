package designPattern;

/**
 *@Description  strategy  strategies too many and need to expose to everybody
 *@Author  bichenyu
 *@Date  2021-7-5
 */
public class strategyPattern {
    public static void main(String[] args) {
        Context context;
        context=new Context(new payAli());
        context.pay();
    }
    abstract static class PayStrategy{
        abstract void payMethod();
    }
    static class payWechat extends PayStrategy{

        @Override
        void payMethod() {
            System.out.println("wechat");
        }
    }
    static class payAli extends PayStrategy{

        @Override
        void payMethod() {
            System.out.println("ali");
        }
    }
    static class Context{
        PayStrategy payStrategy;
        public Context(PayStrategy payStrategy){
            this.payStrategy=payStrategy;
        }
        public void pay(){
            payStrategy.payMethod();
        }
    }
}
