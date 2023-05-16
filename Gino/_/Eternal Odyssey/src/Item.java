public class Item
{
    private String name;
    private String description;
    private int armorPoints;
    private int attackPoints;
    private int magicImprovement;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
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

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getMagicImprovement() {
        return magicImprovement;
    }

    public void setMagicImprovement(int magicImprovement) {
        this.magicImprovement = magicImprovement;
    }
}

