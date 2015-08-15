import java.util.LinkedList;

public class Unit {
	protected String name;
	protected double attack;
	protected double defense;
	protected int defenseTime;
	protected double initDefense;
	protected double life;
	protected double maxLife;

	public Unit(String name, double attack, double defense, double maxLife) {
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.initDefense = defense;
		this.defenseTime = 0;
		this.maxLife = maxLife;
		this.life = maxLife;
	}

	public void getStatistics() {
		System.out.println(this.name + " " + this.attack + " " + this.defense
				+ " " + this.life);
	}

	public String getName() {
		return this.name;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}

	public double getLife() {
		return life;
	}

	public void Attack(Unit target, LinkedList<Unit> friends, LinkedList<Unit> targets) {

		System.out.println(String.format("%1$s���ڹ���%2$s", this.getName(),
				target.getName()));
		target.HurtFrom(this, this.attack);
	}

	/*public void CounterAttack(Unit enemy) {

		System.out.println(String.format("%1$s���ڷ���%2$s", this.getName(),
				enemy.getName()));
		this.Attack(enemy);

	}**/

	public void HurtFrom(Unit enemy, double attack) {

		double realDamage = attack - this.defense;
		if (realDamage < 0) {
			realDamage = 0;
		}
		this.life = this.life - realDamage;
		if (defenseTime > 0) {
			defenseTime--;
			if (defenseTime == 0) {
				defense = initDefense;
			}
		}

		System.out.println(String.format("%1$s�ܵ�%2$s�Ĺ���,�˺�%3$s,��ǰѪ��%4$s",
				this.getName(), enemy.getName(), realDamage, this.life));

		deathJudgingOrCounterAttack(enemy);
	}
	
	public void groupSkill(LinkedList<Unit> units){
		
	}

	protected void deathJudgingOrCounterAttack(Unit enemy) {
		if (this.life <= 0) {

			System.out.println(String.format("%1$s������!!!!!!", this.getName()));
			return;
		}

		// this.CounterAttack(enemy);
	}
}
