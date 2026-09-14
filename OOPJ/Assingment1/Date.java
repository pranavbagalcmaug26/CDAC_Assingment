package Assingment1;

public class Date {
    private int day;
    private int month;
    private int year;

    public void setDate(int dd,int mm,int yyyy){
        year=yyyy;
        if(mm<1 || mm>12){
            month=1;
        }else{
            month=mm;
        }

        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            if(dd<1 || dd>31){
                day=1;
            }else{
                day=dd;
            }
        }
        else if(month==4 || month==6 || month==9 || month==11){
            if(dd<1 || dd>30){
                day=1;
            }else{
                day=dd;
            }
        }else {
            boolean leapYaer;
            if((year%400==0) || (year%4==0 && year%100!=0)){
                leapYaer=true;
            }else{
                leapYaer=false;
            }
            if(leapYaer){
                if(dd<1 || dd>29){
                    day=1;
                }else{
                    day=dd;
                }
            }else{
                if(dd<1 || dd>28){
                    day=1;
                }else{
                    day=dd;
                }
            }
        }
    }
    public void addDays(int days){
        while(days>0){
            int totalDays;
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                totalDays=31;
            }else if(month==4 || month==6 || month==9 || month==11){
                totalDays=30;
            }else{
                if((year%400==0) || (year%4==0 && year%100!=0)){
                    totalDays=29;
                }else{
                    totalDays=28;
                }
            }
            day++;
            days--;

            if(day>totalDays){
                day=1;
                month++;
                if(month>12){
                    month=1;
                    year++;
                }
            }
        }
    }
    public void addMonths(int months){
        while(months>0){
            month++;
            months--;
            if(month>12){
                month=1;
                year++;
            }
            int totalDays;
            if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
                totalDays=31;
            }else if(month==4 || month==6 || month==9 || month==11){
                totalDays=30;
            }else{
                if((year%400==0) || (year%4==0 && year%100!=0)){
                    totalDays=29;
                }else{
                    totalDays=28;
                }
            }
            if(day > totalDays){
                day=totalDays;
            }
        }
    }
    public void addYears(int years){
        year=year+years;
        if (month==2 && day==29){
            if(!((year%400==0) || (year%4==0 && year%100!=0))){
                day=28;
            }
        }
    }
    public void display(){
        System.out.println("Date: "+day+ "/"+month+ "/"+year);
    }
}
