package designPattern;
/**
 *@Description  数据库访问的封装 单元测试 doget/dopost
 *@Author  bichenyu
 *@Date  2021-7-5
 */
public class modelPattern {
    public static void main(String[] args) {
        modelPattern m=new modelPattern();
        restaurantTemplate restaurantTemplate= new restaurantChinese();
        restaurantTemplate.process();
    }
    abstract static class restaurantTemplate{
        public void menu(){
            System.out.println("看菜单");
        }
        abstract void order();
        public void eat(){
            System.out.println("eating");
        }
        abstract void pay();
        public void process(){
            menu();;
            order();
            eat();
            pay();
        }

    }
     static class restaurantChinese extends restaurantTemplate{
        @Override
        void order() {
            System.out.println("宫保鸡丁");
        }
        @Override
        void pay() {
            System.out.println("28");
        }
    }
}
