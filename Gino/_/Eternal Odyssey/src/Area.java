import java.util.HashMap;
import java.util.Map;

public class Area
{
    private String name;
    private String description;
    private Map<String, Item> items;
    private Map<String, Enemy> enemies;

    public Area(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new HashMap<>();
        this.enemies = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public void removeItem(String itemName) {
        items.remove(itemName);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public void addEnemy(Enemy enemy) {
        enemies.put(enemy.getName(), enemy);
    }

    public void removeEnemy(String enemyName) {
        enemies.remove(enemyName);
    }

    public Enemy getEnemy(String enemyName) {
        return enemies.get(enemyName);
    }
}