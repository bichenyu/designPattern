package designPattern;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 *@Description  jianzaozhe  builder concreteBuilder director product
 * focus on the order
 *@Author  bichenyu
 *@Date  2021-7-5
 */
public class builderPattern {
    public static void main(String[] args) {
        PersonDirector pb = new PersonDirector();
        Arms arms = pb.constructPerson(new AArmsBuilder());
        System.out.println(arms.getHelmet());
        System.out.println(arms.getArmor());
        System.out.println(arms.getWeapon());
    }
    static class Arms{
        private String helmet;
        private String armor;
        private String weapon;

        public String getHelmet() {
            return helmet;
        }

        public void setHelmet(String helmet) {
            this.helmet = helmet;
        }

        public String getArmor() {
            return armor;
        }

        public void setArmor(String armor) {
            this.armor = armor;
        }

        public String getWeapon() {
            return weapon;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }
    }

    interface  personBuilder{
        void builderHelmet();
        void builderArmor();
        void builderWeapon();
        Arms builderArms(); //组装

    }
    static class AArmsBuilder implements  personBuilder{
        private Arms arms;
        public AArmsBuilder(){
            arms=new Arms();
        }

        @Override
        public void builderHelmet() {
            arms.setHelmet("头盔A");
        }

        @Override
        public void builderArmor() {
            arms.setArmor("铠甲A");
        }

        @Override
        public void builderWeapon() {
            arms.setWeapon("武器A");
        }

        @Override
        public Arms builderArms() {
            return arms;
        }
    }
    static class PersonDirector{
        Arms constructPerson(personBuilder personBuilder){
            personBuilder.builderArmor();
            personBuilder.builderHelmet();
            personBuilder.builderWeapon();
            return personBuilder.builderArms();
        }
    }
}
