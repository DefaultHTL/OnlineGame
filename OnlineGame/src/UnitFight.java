import java.util.LinkedList;
import java.util.Random;

public class UnitFight {

	final static int SUMMONER_ATTACK_MIN = 7;
	final static int SUMMONER_ATTACK_MAX = 8;
	final static int SOLDIER_ATTACK_MIN = 9;
	final static int SOLDIER_ATTACK_MAX = 14;
	final static int UNIT_ATTACK = 5;
	final static int RANGE_UNIT_ATTACK = 8;
	final static int SHIELD_UNIT_ATTACK = 4;

	final static int SUMMONER_DEFENSE = 2;
	final static int SOLDIER_DEFENSE = 4;
	final static int UNIT_DEFENSE = 3;
	final static int RANGE_DEFENSE = 1;
	final static int SHIELD_DEFENSE = 5;

	final static int SUMMONER_LIFE = 40;
	final static int SOLDIER_LIFE = 50;
	final static int UNIT_LIFE = 35;
	final static int RANGE_LIFE = 30;
	final static int SHIELD_LIFE = 40;

	public static void main(String[] args) {
		fightTest2();
	}

	public static void fightTest2() {

		LinkedList<Unit> units1 = new LinkedList<Unit>();
		LinkedList<Unit> units2 = new LinkedList<Unit>();

		createUnits(units1);
		createUnits(units2);

		while (!units1.isEmpty() && !units2.isEmpty()) {
			Random rand = new Random();
			for (int i = 0; i < units1.size() && i < units2.size(); i++) {
				Unit unit2 = units2.get(rand.nextInt(units2.size()));
				Unit unit1 = units1.get(rand.nextInt(units1.size()));

				units1.get(i).Attack(unit2, units1, units2);
				if (unit2.life <= 0) {
					units2.remove(unit2);
				}
				if (units1.isEmpty() || units2.isEmpty()) {
					break;
				}

				units2.get(i).Attack(unit1, units2, units1);
				if (unit1.life <= 0) {
					units1.remove(unit1);
				}
				if (units1.isEmpty() || units2.isEmpty()) {
					break;
				}
			}
			System.out.println("ս������ - " + units1);
			System.out.println(units2);
		}

	}

	public static Hero createUnits(LinkedList<Unit> units) {
		Hero hero;
		Random rand = new Random();
		{
			if (rand.nextInt(2) < 1) {
				hero = new Summoner("�ٻ�ʦ1",
						SUMMONER_ATTACK_MIN + rand.nextInt(SUMMONER_ATTACK_MAX - SUMMONER_ATTACK_MIN + 1),
						SUMMONER_DEFENSE, SUMMONER_LIFE);
				System.out.println("�ٻ�ʦ1 " + "Attack:" + ((Unit) hero).getAttack() + " Defense:"
						+ ((Unit) hero).getDefense() + " Life:" + ((Unit) hero).getLife());
			} else {
				hero = new Soilder("սʿ1",
						SOLDIER_ATTACK_MIN + rand.nextInt(SOLDIER_ATTACK_MAX - SOLDIER_ATTACK_MIN + 1), SOLDIER_DEFENSE,
						SOLDIER_LIFE);
				System.out.println("սʿ1 " + "Attack:" + ((Unit) hero).getAttack() + " Defense:"
						+ ((Unit) hero).getDefense() + " Life:" + ((Unit) hero).getLife());
			}
			units.add((Unit) hero);

			for (int i = 1; i <= 5; i++) {
				if (rand.nextInt(3) == 0) {
					units.add(new Unit("unit1-" + i, UNIT_ATTACK, UNIT_DEFENSE, UNIT_LIFE));
				} else if (rand.nextInt(2) == 1) {
					units.add(new RangeUnit("range1-" + i, RANGE_UNIT_ATTACK, RANGE_DEFENSE, RANGE_LIFE));
				} else {
					units.add(new ShieldUnit("shield1-" + i, SHIELD_UNIT_ATTACK, SHIELD_DEFENSE, SHIELD_LIFE));
				}

			}
		}
		return hero;
	}
}

/*
 * public static void fightTest1() { RangeUnit Robin = new RangeUnit("Robin", 5,
 * 1, 20); ShieldUnit Tom = new ShieldUnit("Tom", 3, 3, 30); simpleFight(Robin,
 * Tom); System.out.println("ս������ - " + Robin.getName() + "����Ϊ" +
 * Robin.getLife() + ", " + Tom.getName() + "����Ϊ" + Tom.getLife()); }
 * 
 * public static void simpleFight(Unit Robin, Unit Tom) { Unit attacker = Robin;
 * Unit defender = Tom; Unit temp = null;
 * 
 * while (Robin.getLife() > 0 && Tom.getLife() > 0) { attacker.Attack(defender);
 * temp = attacker; attacker = defender; defender = temp; } }
 **/
