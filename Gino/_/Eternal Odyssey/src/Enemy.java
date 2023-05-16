public class Enemy {
    private String name;
    private int healthPoints;
    private String strength; // Strength attribute
    private String weakness; // Weakness attribute
    private String type; // Enemy type
    private int armor; // Enemy's armor value

    public Enemy(String name, int healthPoints, String strength, String weakness, String type, int armor) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.weakness = weakness;
        this.type = type;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
