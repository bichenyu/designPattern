package designPattern;

public class factoryPattern {
    public static void main(String[] args) {
        Car baoma=CarFactory.createCar("baoma");
        baoma.run();
        Car baoma1= new BaomaFactory().createCar();

    }
    /**
     * 简单工厂
     */
    interface Car{
        public void run();
    }
    static class Baoma implements Car{

        @Override
        public void run() {
            System.out.print("宝马");
        }
    }
    static class Benze implements Car{

        @Override
        public void run() {
            System.out.print("奔驰");
        }
    }
    static class CarFactory{
        public static Car createCar(String name){
            if("".equals(name)){
                return null;
            }
            if("baoma".equals(name)){
                return new Baoma();
            }
            if("benze".equals(name)){
                return new Benze();
            }
            return null;
        }
    }

    //*******************************************8888
    /**
     * 工厂方法
     */
    interface carFactory{
        Car createCar();
    }
    static class BaomaFactory implements carFactory{
        @Override
        public Car createCar() {
            return new Baoma();
        }
    }
    //**************
    /**
     * 抽象工厂 工厂的工厂  构建产品族
     */
    public interface Engine {
        void run();
    }

    class EngineA implements Engine {
        public void run() {
            System.out.println("转的快!");
        }
    }
    class EngineB implements Engine {
        public void run() {
            System.out.println("转的慢!");
        }
    }
    interface  totalFactory{
        Car createCar();
        Engine createEngine();
    }
    class totalFactoryimpl implements totalFactory{

        @Override
        public Car createCar() {
            return new Baoma();
        }

        @Override
        public Engine createEngine() {
            return new EngineA();
        }
    }
}
