import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Army {
	final int SUMMONER_ATTACK_MIN = 7;
	final int SUMMONER_ATTACK_MAX = 8;
	final int SOLDIER_ATTACK_MIN = 9;
	final int SOLDIER_ATTACK_MAX = 14;
	final int UNIT_ATTACK = 5;
	final int RANGE_UNIT_ATTACK = 8;
	final int SHIELD_UNIT_ATTACK = 4;

	final int SUMMONER_DEFENSE = 2;
	final int SOLDIER_DEFENSE = 4;
	final int UNIT_DEFENSE = 3;
	final int RANGE_DEFENSE = 1;
	final int SHIELD_DEFENSE = 5;

	final int SUMMONER_LIFE = 40;
	final int SOLDIER_LIFE = 50;
	final int UNIT_LIFE = 35;
	final int RANGE_LIFE = 30;
	final int SHIELD_LIFE = 40;

	Hero hero1;
	Hero hero2;
	LinkedList<Unit> units1 = new LinkedList<Unit>();
	LinkedList<Unit> units2 = new LinkedList<Unit>();

	public Army(LinkedList<Unit> units1, LinkedList<Unit> units2) {

		Random rand1 = new Random();
		{
			if (rand1.nextInt(2) < 1) {
				hero1 = new Summoner("召唤师1",
						SUMMONER_ATTACK_MIN + rand1.nextInt(SUMMONER_ATTACK_MAX - SUMMONER_ATTACK_MIN + 1),
						SUMMONER_DEFENSE, SUMMONER_LIFE);
				System.out.println("召唤师1 " + "Attack:" + ((Unit) hero1).getAttack() + " Defense:"
						+ ((Unit) hero1).getDefense() + " Life:" + ((Unit) hero1).getLife());
			} else {
				hero1 = new Soilder("战士1",
						SOLDIER_ATTACK_MIN + rand1.nextInt(SOLDIER_ATTACK_MAX - SOLDIER_ATTACK_MIN + 1),
						SOLDIER_DEFENSE, SOLDIER_LIFE);
				System.out.println("战士1 " + "Attack:" + ((Unit) hero1).getAttack() + " Defense:"
						+ ((Unit) hero1).getDefense() + " Life:" + ((Unit) hero1).getLife());
			}
			units1.add((Unit) hero1);

			for (int i = 1; i <= 5; i++) {
				if (rand1.nextInt(3) == 0) {
					units1.add(new Unit("unit1-" + i, UNIT_ATTACK, UNIT_DEFENSE, UNIT_LIFE));
				} else if (rand1.nextInt(2) == 1) {
					units1.add(new RangeUnit("range1-" + i, RANGE_UNIT_ATTACK, RANGE_DEFENSE, RANGE_LIFE));
				} else {
					units1.add(new ShieldUnit("shield1-" + i, SHIELD_UNIT_ATTACK, SHIELD_DEFENSE, SHIELD_LIFE));
				}

			}
		}
		Random rand2 = new Random();
		{
			if (rand2.nextInt(2) < 1) {
				hero2 = new Summoner("召唤师2",
						SUMMONER_ATTACK_MIN + rand1.nextInt(SUMMONER_ATTACK_MAX - SUMMONER_ATTACK_MIN + 1),
						SUMMONER_DEFENSE, SUMMONER_LIFE);
				System.out.println("召唤师2 " + "Attack:" + ((Unit) hero2).getAttack() + " Defense:"
						+ ((Unit) hero2).getDefense() + " Life:" + ((Unit) hero2).getLife());
			} else {
				hero2 = new Soilder("战士2",
						SOLDIER_ATTACK_MIN + rand1.nextInt(SOLDIER_ATTACK_MAX - SOLDIER_ATTACK_MIN + 1),
						SOLDIER_DEFENSE, SOLDIER_LIFE);
				System.out.println("战士2 " + "Attack:" + ((Unit) hero2).getAttack() + " Defense:"
						+ ((Unit) hero2).getDefense() + " Life:" + ((Unit) hero2).getLife());
			}
			units2.add((Unit) hero2);

			for (int i = 1; i <= 5; i++) {
				if (rand2.nextInt(3) == 0) {
					units2.add(new Unit("unit2-" + i, UNIT_ATTACK, UNIT_DEFENSE, UNIT_LIFE));
				} else if (rand2.nextInt(2) == 1) {
					units2.add(new RangeUnit("range2-" + i, RANGE_UNIT_ATTACK, RANGE_DEFENSE, RANGE_LIFE));
				} else {
					units2.add(new ShieldUnit("shield2-" + i, SHIELD_UNIT_ATTACK, SHIELD_DEFENSE, SHIELD_LIFE));
				}
			}
			System.out.println(units1.get(0).getName() + " " + units1.get(1).getName() + " " + units1.get(2).getName()
					+ " " + units1.get(3).getName() + " " + units1.get(4).getName() + " " + units1.get(5).getName()
					+ " ");
			System.out.println(units2.get(0).getName() + " " + units2.get(1).getName() + " " + units2.get(2).getName()
					+ " " + units2.get(3).getName() + " " + units2.get(4).getName() + " " + units2.get(5).getName()
					+ " ");
		}

		while (!units1.isEmpty() && !units2.isEmpty()) {
			Random rand3 = new Random();
			Random rand4 = new Random();
			for (int i = 0; i < units1.size() && i < units2.size(); i++) {
				Unit unit2 = units2.get(rand3.nextInt(units2.size()));
				Unit unit1 = units1.get(rand4.nextInt(units1.size()));

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
			System.out.println("战斗结束 - " + units1);
			System.out.println(units2);
		}
	}

	private Hero hero;
	List<Unit> units = new LinkedList<Unit>();

	public Unit getHero() {
		return (Unit) hero;
	}

}
