public class Maze
{
    private int width;
    private int height;
    private Cell[][] cells;

    public Maze(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.cells = new Cell[height][width];
    }

    public Cell getCell(int row, int col)
    {
        if (row >= 0 && row < height && col >= 0 && col < width)
        {
            return cells[row][col];
        }
        else
        {
            return null;
        }
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
}
