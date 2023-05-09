public enum WeekdayEnum
{
    MONDAY(monday, 1),
    TUESDAY(tuesday, 2),
    WEDNESDAY(wednesday, 3),
    THURSDAY(thursday, 4),
    FRIDAY(friday, 5),
    SATURDAY(saturday, 6),
    SUNDAY(sunday, 7);

    private String name;
    private int value;
    public WeekdayEnum[] weekDays = WeekdayEnum.values();

    private WeekdayEnum(String name, int value)
    {
        this.name = name;
        this.value = value;
    }

    public static int correspondingDay(WeekdayEnum weekday)
    {
        return weekday.value;
    }

    public static String followingDay(WeekdayEnum weekday)
    {
        ###
    }
}
