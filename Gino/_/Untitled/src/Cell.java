public class Cell
{
    private boolean isWall;

    public Cell(boolean isWall)
    {
        this.isWall = isWall;
    }

    public boolean isWall()
    {
        return isWall;
    }

    public void setWall(boolean wall)
    {
        isWall = wall;
    }
}
