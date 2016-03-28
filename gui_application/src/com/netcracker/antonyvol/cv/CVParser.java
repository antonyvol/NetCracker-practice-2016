package com.netcracker.antonyvol.cv;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by antonyvol on 25.03.16.
 */

/*
    класс CVParser для парсинга текстового файла резюме

    конструктор принимает строку с адресом файла, открывает
    и парсит его, заполняя поля класса

    поля аналогичны классу CV, за исключением
    getBirthdate - возвращает дату рождения типа Date
    getGender - возвращает пол в формате Gender
 */

public class CVParser {
    private Gender gender;
    private Date birthdate;
    private String fullname;
    private String about;
    private String job;
    private int salary;

    public CVParser (String addr) {
        ArrayList<String> list = new ArrayList<>();
        try( Scanner in = new Scanner(new File(addr)) ) {
            while (in.hasNextLine()) {
                list.add(in.nextLine());
            }

            String[] array = list.toArray(new String[0]);
            String[] tempArr;

            tempArr = array[0].split(":");
            fullname = tempArr[1].substring(1, tempArr[1].length());

            tempArr = array[1].split(":");
            gender = tempArr[1].equals(" Мужской") ? Gender.MALE : Gender.FEMALE;

            tempArr = array[2].split(":");
            birthdate = new Date(tempArr[1].substring(1, tempArr[1].length()));

            tempArr = array[3].split(":");
            job = tempArr[1].substring(1, tempArr[1].length());

            tempArr = array[4].split(":");
            salary = Integer.parseInt(tempArr[1].substring(1, tempArr[1].length()));

            tempArr = array[5].split(":");
            about = tempArr[1].substring(1, tempArr[1].length());

        } catch (FileNotFoundException ex) {
            System.err.println("File not found!");
        }

    }

    public int getSalary() { return salary; }
    public String getJob() { return job; }
    public String getAbout() { return about; }
    public String getFullname() { return fullname; }
    public Date getBirthdate() { return birthdate; }
    public Gender getGender() { return gender; }

}
