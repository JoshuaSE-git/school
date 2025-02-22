public class ValidDate {
    public static void main (String[] args) {
        int month, day, year;
        String output = "";
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a date in MM/DD/YYYY format: ");
        String dateInput = input.nextLine();

        Scanner dateScanner = new Scanner(dateInput).useDelimiter("/");

        month = dateScanner.nextInt();
        day = dateScanner.nextInt();
        year = dateScanner.nextInt();
       
        boolean isValid = false;

        if (day < 1) {
            output = "Can never have less than 1 day in a month";
        } else if (day > 31) {
            output = "Can never have more than 31 days in a month.";
        } else {  
            switch (month) {
                case 1:
                    isValid = true;
                    break;
                case 3:
                    isValid = true;
                    break;
                case 5:
                    isValid = true;
                    break;
                case 7:
                    isValid = true;
                    break;
                case 8:
                    isValid = true;
                    break;
                case 10:
                    isValid = true;
                    break;
                case 12:
                    isValid = true;
                    break;

                case 4:
                    if (day <= 30) {
                        isValid = true;
                    } else {
                        output = "Can not have 31 days for this month.";
                    }
                    break;
                case 6:
                    if (day <= 30) {
                        isValid = true;
                    } else {
                        output = "Can not have 31 days for this month.";
                    }
                    break;
                case 9:
                    if (day <= 30) {
                        isValid = true;
                    } else {
                        output = "Can not have 31 days for this month.";
                    }
                    break;
                case 11:
                    if (day <= 30) {
                        isValid = true;
                    } else {
                        output = "Can not have 31 days for this month.";
                    }
                    break;
                case 2:
                    boolean isLeapYear = false;
                   
                    if (year % 400 == 0 || (year % 4 == 0 && !(year % 100 == 0))) {
                        isLeapYear = true;
                    }
                       
                    if (isLeapYear) {
                            if (day <= 29) {
                                isValid = true;
                            } else {
                                output = "Can not have 30 or more days in a leap year.";
                            }
                        } else {
                            if (day <= 29) {
                                isValid = true;
                            } else {
                                output = "Can not have 29 or more days in a non-leap year.";
                            }
                        }
                        break;
                    }
                default:
                    output = "Months must be between 1 and 12.";
            }
        }
       
        if (isValid) {
            System.out.printf("%d/%d/%d is a valid date.", month, day, year);
        } else {
            System.out.printf("%d/%d/%d is not a valid date. " + output, month, day, year);
        }
    }
}