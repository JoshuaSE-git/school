//import Scanner

/**
 * Program Description
 * 1) Fill in steps
 * 
 * @author Name, optional email
 * @version v1.0
 * @since date
 */

public class ValidDate_Starter { //Remove _Starter.
    public static void main (String[] args){
        //int vars for month, day, year
        //String vars for temp, output
        //Create a Scanner object
        //Update delimiter to "/"

        //create a blank output, output = "";
        //Message to have users enter date in mm/dd/yyyy format
        //use Scanner object to assign month
        //use Scanner object to assign day
        temp = keyboard.nextLine().substring(1);  //ie, assigns "2022" to temp, if /2022 is in the buffer!
        //use Integer wrapper class to convert temp to int

        //create an isValid flag set to false;
        
        ////Create if-else if to look for when:
        ////Section 1, day is less than 1
        if (day < XX)
            //Update output to something like - Can never have less than 1 day in a month.

        ////Section 2, day is larger than 31
        else if (day > XX)
            //Update output to something like - Can never have more than 31 days in a month.

        ////Section 3, btw 1 and 31 days, can use a switch that evaluates months with intentional bleed through
        else{  
            switch(var?){
                ////Cases for all 31 day months
                case 1:
                    ... //fill in other cases for months with 31 days
                case 12:
                        //update isValid to true
                        //prevent bleed through here with ?
                
                ////Cases for all 30 day months
                case X: //replace X
                    ...  //fill in other cases for 30 day months
                case Y:  //replace Y
                        if(day <=X)  //replace X
                            //update isValid to true
                        else
                            //Update output to something like - Can not have 31 days for this month.
                        //prevent bleed through here with ?
                    
                ////This is February
                case 2: 
                        //create isLeapYear flag and set to false
                        if(year%400==0 || (year%4==0&&!(year%100==0)))  ////Carefully look at || and && combo
                            //update isLeapYear flag to true
                            if (isLeapYear){ ////use isLeapYear flag
                                if(day <=X) //Update X
                                    //Update isValid to true
                                else
                                    //Update output to something like - Can not have 30 or more days in a leap year.
                            }
                            else{  ////non-leap year
                                if(day <=X) //Update X
                                    //Update isValid to true
                                else
                                    //Update output to something like - Can not have 29 or more days in a non-leap year.
                            }
                        //prevent bleed through here with ?
                    ////end case 2:
                
                //Default case if month is not between 1 and 12
                    //Update output to something like - Months must be btw 1 and 12.
            }////End of switch
        }////End of else section for multibranch if-else if
        
        //// Output section using isValid flag
        if (isValid) ////if isValid is true statement below will run
            //Print month/day/year is a valid date.
        else
            //Print month/day/year is not a valid date. + output
    }////end main
}////end class
