package entities;

public class Champion {

    private String name;
    private int life;
    private int attack;
    private int armor;

    public Champion(String name, int life, int attack, int armor) {
        this.name = name;
        this.life = life;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    // Aplica o dano recebido pelo ataque de outro campeão
    public void takeDamage(Champion other) {
        int danoEfetivo = other.getAttack() - this.armor;

        // Garante que o dano mínimo seja de pelo menos 1 de vida
        if (danoEfetivo < 1) {
            danoEfetivo = 1;
        }

        this.life -= danoEfetivo;

        // A vida não pode ser menor que zero
        if (this.life < 0) {
            this.life = 0;
        }
    }

    // Retorna o status atual do campeão formatado
    public String status() {
        if (this.life == 0) {
            return this.name + ": 0 de vida (morreu)";
        }
        return this.name + ": " + this.life + " de vida";
    }
}
