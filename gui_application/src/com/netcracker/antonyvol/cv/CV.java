package com.netcracker.antonyvol.cv;

/**
 * Created by antonyvol on 25.03.16.
 */

enum Gender { MALE, FEMALE };

/*
    класс Date для хранения и обработки даты

    конструктор принимает на вход строку c датой, парсит ее
    и заполняет соответствующие поля класса

    int year - год
    int month - месяц
    int day - день

    get... - геттеры полей класса
    !! getBirthdate и getGender возвращают String

    showData - возвращает строку в формате дд.мм.гггг
 */

class Date {
    private int year;
    private int month;
    private int day;

    Date(String strDate) {
        String[] parsed = strDate.split("\\.");
        day = Integer.parseInt(parsed[0]);
        month = Integer.parseInt(parsed[1]);
        year = Integer.parseInt(parsed[2]);
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }
    public String showDate() { return day + "." + month + "." + year; }
}

/*
    класс CV,  инкапсулирующий информацию о соискателе

    конструктор принимает строку с адресом файла резюме
    и парсит ее с помощью класса CVParser

    Gender gender - пол соискателя, MALE/FEMALE
    Date birthdate - дата рождения соискателя
    String fullname - ФИО соискателя
    String about - "О себе"
    String job - желаемая позиция соискателя
    String salary - желаемая зарплата соискателя

    get... - геттеры полей класса
 */

public class CV {
    private Gender gender;
    private Date birthdate;
    private String fullname;
    private String about;
    private String job;
    private int salary;

    public CV (String addr) {
        CVParser parser = new CVParser(addr);

        gender = parser.getGender();
        birthdate = parser.getBirthdate();
        fullname = parser.getFullname();
        about = parser.getAbout();
        job = parser.getJob();
        salary = parser.getSalary();
    }

    public String getGender() { return gender.toString(); }
    public String getBirthdate() { return birthdate.showDate(); }
    public String getFullname() { return fullname; }
    public String getAbout() { return about; }
    public String getJob() { return job; }
    public int getSalary() { return salary; }
}
