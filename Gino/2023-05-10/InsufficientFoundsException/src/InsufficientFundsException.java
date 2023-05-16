public class InsufficientFundsException extends Exception
{
    private String description;
    public InsufficientFundsException(String description)
    {
        this.description = description;
    }

    public String getDescription() {
    return description;
}

    public void setDescription(String description) {
        this.description = description;
    }
}
