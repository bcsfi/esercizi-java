public enum Weekday {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    final int numberOfDay;
    Weekday (int numberOfDay){

        this.numberOfDay = numberOfDay;
    }


}
//Weekday dayOfTheWeek;
//dayOfTheWeek = Weekday.MONDAY;