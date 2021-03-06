package com.lits.hw9;

public class SpaceX extends SpaceCenter {
    // Параметри Crew Dragon і секцій
    public static String name = "<Crew Dragon>";
    public static int
            fuel = 300,            // паливо
            consumption = 1,       // розхід палива на 1 км
            maxSpeed = 600,        // максимальна швидкість
            distance = 300,        // відстань з Землі до МКС
            distanceMks;           // відстань до МКС
    public int
            height = 25,           // висота ракети
            weight = 8000,         // вага ракети
            weightSection = 1000;  // вага секцій

    // Дані ракети
    public void dataSpaceX() {
        System.out.println("Ракета: " + name + " компанії " + getNameCompany());
        System.out.println("Місія: " + super.mission + " , дистанція: " + distance + " km");
        System.out.println("Параметри: Висота " + height + " метрів " + "Вага " + weight + " кг");
    }

    //  Відокремлення секцій
    public void sepSection(int nameSection) {
    }

    // Летимо у космос
    public void goSpace() {

        // Розганяємось
        for (int speed = 0; speed <= maxSpeed; speed += 100) {
            System.out.println("Швидкість " + speed);

            if (speed == 400) {
                // зменшення маси ракети відділенням секції 1
                weight -= weightSection;

                // зменшення дистанції і палива до МКС
                distance -= 50;
                fuel = distance / consumption;

            } else if (speed == 500) {
                // зменшення маси ракети відділенням секції 2
                weight -= weightSection;

                // зменшення дистанції і палива до МКС
                distance -= 50;
                fuel = distance / consumption;

            } else if (speed == 600) {
                // зменшення маси ракети відділенням секції 3
                weight -= weightSection;

                // зменшення дистанції і палива до МКС
                distance -= 50;
                fuel = distance / consumption;

            }

            switch (speed) {
                case 100:
                    // Статус ракети
                    System.out.println("Статус ракети: " + Status.FLY);
                    break;
                case 400:
                    // 400 км/год, Секція 1 відділяється
                    SpaceX sectionOne = new SectionOne();
                    sectionOne.sepSection(1);
                    // Виводим змінені параметри у консоль
                    System.out.println("Вага ракети " + weight + ", палива " + fuel + ", дистанція до МКС " + distance);
                    break;
                case 500:
                    // 500 км/год, Секція 2 відділяється
                    SpaceX sectionTwo = new SectionTwo();
                    sectionTwo.sepSection(2);
                    // Виводим змінені параметри у консоль
                    System.out.println("Вага ракети " + weight + ", палива " + fuel + ", дистанція до МКС " + distance);
                    break;
                case 600:
                    // 600 км/год, Секція 3 відділяється
                    SpaceX sectionThree = new SectionThree();
                    sectionThree.sepSection(3);
                    // Виводим змінені параметри у консоль
                    System.out.println("Вага ракети " + weight + ", палива " + fuel + ", дистанція до МКС " + distance);

                    // Ми в космосі
                    System.out.println("");
                    System.out.println("Ми в космосі!!!");
                    break;
            }
        }
    }

    // На скільки км вистачить палива
    public void distanceMks() throws MyException {
        People max = new People();

        // на скільки км вистачить палива і надсилаю пілоту

        try {

            distanceMks = fuel / consumption;

            // якщо палива не хватає тоді меседж Exception
            if (fuel / consumption < distance) {
                throw new MyException(" Нехватка палива до МКС");
            }
        } catch (MyException e) {
            e.printStackTrace();
        }

        max.sendToCenter(distanceMks);
    }
}