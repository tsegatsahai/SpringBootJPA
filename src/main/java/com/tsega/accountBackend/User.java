package com.tsega.accountBackend;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@Entity
public class User {
    private @Id @GeneratedValue int id;
    private String email;
    private String password;
    private String name;
    private String birthday;
    private char gender;

    public User(String email, String password, String name, String birthday, char gender) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        int size = email.length();
        int atCounter = 0;
        //if the first letter is not a character, it's invalid
        if(!Character.isLetter(email.charAt(0))){
            System.out.println("Invalid: Email must start with a letter");
            return false;
        }
        //if the last letter is not a character, it's invalid
        if(!Character.isLetter(email.charAt(size -1))){
            System.out.println("Invalid: Email must end with a letter");
            return false;
        }
        for(int i = 0; i < size; i++){
            //if there is a space char, it's invalid
            if(email.charAt(i) == ' '){
                System.out.println("Invalid: Email must not include white space");
                return false;
            }
            if(email.charAt(i) == '@'){
                atCounter++;
            }

        }
        //if there is more than one @ or no @, it's invalid
        if(atCounter != 1){
            System.out.println("Invalid: Email must have exactly one '@'");
            return false;
        }

        String[] splitByAt = email.split("@");
        String domain = splitByAt[1];
        boolean dotIsThere = false;
        //domain must begin and end with a letter
        //must also be characters and dots only
        if(!Character.isLetter(domain.charAt(0)) || !Character.isLetter(domain.charAt(domain.length() - 1))){
            System.out.println("Invalid: Domain must begin with a letter and end with a letter as well");
            return false;
        }
        for(int i = 0; i < domain.length(); i++){
            if(domain.charAt(i) == '.'){
                dotIsThere = true;
                //if two dots consecutively, it's invalid
                if(i < domain.length() - 1 && domain.charAt(i + 1) == '.'){
                    System.out.println("Invalid: Domain can't have consecutive dots");
                    return false;
                }
            }else if(!Character.isLetter(domain.charAt(i))){
                System.out.println("Invalid: Domain contains an invalid character");
                return false;
            }
        }
        if(!dotIsThere){
            System.out.println("Invalid domain");
            return false;
        }
        this.email = email;
        return true;
    }

    public String getPassword() {
        return password;
    }

    public boolean setPassword(String password) {
        //a valid password must be six characters or longer (according to Hulu)
        if(password.length() < 6){
            System.out.println("Invalid: Password must be six characters and above");
            return false;
        }else{
            this.password = password;
            return true;
        }
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        //A valid name would not include numbers or special characters (except '-' and white space)
        name = name.trim(); //get rid of trailing white space
        for(int i = 0; i < name.length(); i++){
            if(!(Character.isLetter(name.charAt(i)) || name.charAt(i) == ' ' || name.charAt(i) == '-')){
                System.out.println("Invalid Name");
                return false;
            }
        }
        this.name = name;
        return true;
    }

    public String getBirthday() {
        return birthday;
    }

    public boolean setBirthday(String birthday) {
        //for a birth date to be valid it must be entered in the format MM/DD/YYYY
        String[] bdaySplit = birthday.split("/");
        if(bdaySplit.length != 3){
            System.out.println("Invalid birthday");
            return false;
        }

        Integer month = Integer.parseInt(bdaySplit[0]);
        int day = Integer.parseInt(bdaySplit[1]);
        int year = Integer.parseInt(bdaySplit[2]);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        Integer currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDate = Calendar.getInstance().get(Calendar.DATE);
        List<Integer> monthWith31Days = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        //validating the month
        if(month > 12 || month < 1){
            System.out.println("Invalid month");
            return false;
        }
        //validating the date
        if(monthWith31Days.contains(month) && (day > 31 || day < 1)){
            System.out.println("Invalid date");
            return false;
        }
        if(month == 2 && (day < 1 || day > 28) ){
            System.out.println("Invalid date");
            return false;
        }
        if(day < 1 || day > 30){
            System.out.println("Invalid date");
            return false;
        }
        //validating the year
        if(year > currentYear || year < 1920){
            System.out.println("Invalid year");
            return false;
        }
        //validating that it's not a future date
        if(year == currentYear && month > currentMonth + 1){
            System.out.println("Invalid birthday");
            return false;
        }
        if(year == currentYear && month.equals(currentMonth + 1) && day > currentDate){
            System.out.println("Invalid birthday");
            return false;
        }
        this.birthday = birthday;
        return true;
    }

    public char getGender() {
        return gender;
    }

    public boolean setGender(char gender) {
        gender = Character.toUpperCase(gender);
        if(gender == 'F' || gender == 'M'){
            this.gender = gender;
            return true;
        }else{
            System.out.println("Invalid gender: Please indicate 'M' or 'F'");
            return false;
        }
    }
}
