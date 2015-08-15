import java.util.LinkedList;

public interface Hero {
	public void attackSkill(Unit target ,LinkedList<Unit> targets);
	public void defendSkill(LinkedList<Unit> targets);

}