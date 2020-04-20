package pachet;
import java.util.Scanner;

public class PlayerStatus {
	
	private String nickname;
	private int score;
	private int lives;
	private int health;
	private String weaponInHand;
	private double positionX;
	
	private double positionY;
	public String getNickname() {
		return nickname;
	}
	protected void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLives() {
		return lives;
	}
	public void setLives(int l) {
		this.lives = l;
		if(l<0) {
			System.out.println("Game Over!");
		}

	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		this.health = h;
		if(h >100) {
			h = 100;
		}else if(h <=0) {
			h = 100;
			setLives(getLives()-1);
		}
	}
	public String getWeaponInHand() {
		return weaponInHand;
		
	}
	
	public boolean setWeaponInHand(String weaponInHand) {
		this.weaponInHand = weaponInHand;
		if(weaponInHand.equals("knife")||weaponInHand.equals("kalashnikov")||weaponInHand.equals("sniper")) {
			
			switch(weaponInHand) {
			case "knife":
				if(this.score>=1000) {
					setScore(this.score - 1000);
					return true;
				}else {
					return false;
				}
			case "kalashnikov":
				if(this.score>=20000) {
					setScore(this.score - 20000);
					return true;
				}else {
					return false;
				}
			case "sniper":
				if(this.score>=10000) {
					setScore(this.score - 10000);
					return true;
				}else {
					return false;
				}	
			}
		}else {
			System.out.println("The weapon that you chose is not a valid one!");		
			return false;
		}
		return false;
	}
	public double getPositionX() {
		return positionX;
	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public double getPositionY() {
		return positionY;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	static String gameName;

	protected static String getGameName() {
		return gameName;
	}
	protected static void setGameName(String gameName) {
		PlayerStatus.gameName = gameName;
	}
	public String initPlayer(String nickname) {

		setNickname(nickname);
		if(nickname == null) {
			return nickname = "Player"; 
		}else {
			return nickname;
		}

	}
	public int initPlayer(String nickname,int lives) {
		initPlayer(nickname);
		setLives(lives);
		return lives;
	}
	public int initPlayer(String nickname,int lives, int score) {
		initPlayer(nickname,lives);
		setScore(score);

		return score;
	}
	public boolean isPrime(int number) {
		int nPr = number;
		int fP = 2;
		int cop = nPr;

		while(cop != 1) {
			if(cop % fP==0) {
				cop/=fP;

			}else {
				fP++;
			}

		}
		if(fP == nPr) {
			return true;
		}else {
			return false;
		}
	}
	public boolean hasPassed(int num ) {

		if(num>100) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isEven(int num) {
		if(num%2==0) {
			return true;
		}else {
			return false;
		}
	}
	public boolean numSum(int num) {
		int copie = num;
		int sum=0;
		int rest = 0;
		while(copie!=0) {
			rest = copie %10;
			sum +=rest;
			copie/=10;
		}	
		if(sum == 3) {
			return true;
		}else {
			return false;
		}
	}

	public void results(int scr,int health,int liv) {
		System.out.println("Your score is:"+ scr);
		System.out.println("Your health is:"+health);
		System.out.println("You have "+liv +" lives");
		
	}

	public void findArtifact(int artifactCode){
		int copie;
		copie =artifactCode;
		int sum= 0;

		for(int i =1;i<=copie/2;i++) {
			if(copie%i ==0) {
				sum+=i;
			}
		}
		if(sum== artifactCode) {
			setScore(this.score+=5000);
			setHealth(100);
			setLives(this.lives++);
			results(this.score,this.health,this.lives);
		}else if(isPrime(artifactCode)) {
			setScore(this.score+=1000);
			setHealth(this.health +=25);
			if(hasPassed(this.health)) {
				setHealth(this.health = 100);
			}
			setLives(this.lives+=2);
			results(this.score,this.health,this.lives);
		}else if(isEven(artifactCode)&& numSum(artifactCode)) {
			setScore(this.score-=3000);
			setHealth(this.health -=25);
			results(this.score,this.health,this.lives);
		}else {
			setScore(this.score+artifactCode);
			results(this.score,this.health,this.lives);
		}

	}
	
	public void setDistance(double ox, double oy) {
		setPositionX(ox);
		setPositionY(oy);
	}
	public int winningChance(int health,int score) {
		setHealth(health);
		setScore(score);
		

		int chance = (3 * health + score/1000)/4;
		return chance;

	}
	public int updateHealth(int health) {
		setHealth(this.health-health);
		return getHealth(); 

	}
	public static double distanceBetweenPlayers(double ox1, double oy1, double ox2,double oy2) {
		double	sum1 = ox1 + ox2;
		double pow1 = Math.pow(sum1,2);
		double sum2 = oy1+oy2;
		double pow2 = Math.pow(sum2, 2);
		double dif = pow1 - pow2;
		double result = Math.sqrt(Math.abs(dif));
		return result;

	}



	


}
