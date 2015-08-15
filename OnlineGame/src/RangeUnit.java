
import java.util.LinkedList;
import java.util.Random;

public class RangeUnit extends Unit {

	public RangeUnit(String name, double attack, double defense, double life) {
		super(name, attack, defense, life);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Attack(Unit target, LinkedList<Unit> friends, LinkedList<Unit> targets) {
		double realAttack = 0;
		if (new Random().nextInt(10) < 3) {
			System.out.println(String.format("%1$s���ڹ���%2$s�����2��������",
					this.getName(), target.getName()));
			realAttack = attack * 2;
		} else {
			System.out.println(String.format("%1$s���ڹ���%2$s", this.getName(),
					target.getName()));
			realAttack = attack;
		}

		target.HurtFrom(this, realAttack);
	}

}
