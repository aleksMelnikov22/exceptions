package impl;

import exceptions.DataCountException;
import exceptions.DataFormatException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class User {
    private String surname;
    private String name;
    private String patronymic;
    private String birthday;
    private Integer phoneNumber;
    private String sex;
    public User(String inputString) throws DataCountException, DataFormatException {
        String[] input = inputString.split(" ");
        if(input.length!= 6){
            throw new DataCountException();
        }

        this.surname = input[0];
        if(!isAlpha(this.surname)) throw new DataFormatException("Фамилия должна содержать только буквы");

        this.name = input[1];
        if(!isAlpha(this.name)) throw new DataFormatException("Имя должно содержать только буквы");

        this.patronymic = input[2];
        if(!isAlpha(this.patronymic)) throw new DataFormatException("Отчество должно содержать только буквы");

        this.birthday = input[3];
        if(!isValidDate(this.birthday)) throw new DataFormatException("Некорректная дата рождения");

        try{
        this.phoneNumber = Integer.parseInt(input[4]);
        if(phoneNumber < 0) throw new NumberFormatException("Номер телефона должен быть больше 0");
        }catch (NumberFormatException e){
            throw new DataFormatException("Некорректный номер телефона " + e.getMessage());
        }

        this.sex = input[5];
        if(!isSex(this.sex)) throw new DataFormatException("Пол должен быть мужской - m или женский - f");
    }
    public String getSurname() {
        return surname;
    }
    private boolean isValidDate(String dateStr){
        DateFormat sdf = new SimpleDateFormat("dd.mm.yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public boolean isAlpha(String inName) {
        char[] chars = inName.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSex(String inSex) {
        return inSex.toLowerCase().matches("[fm]+");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(surname);
        sb.append(" ");
        sb.append(name);
        sb.append(" ");
        sb.append(patronymic);
        sb.append(" ");
        sb.append(birthday);
        sb.append(" ");
        sb.append(phoneNumber);
        sb.append(" ");
        sb.append(sex);
        return sb.toString();
    }
}