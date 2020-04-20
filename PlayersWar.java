package pachet;
import java.util.Scanner;
public class PlayersWar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PlayerStatus.setGameName("PlayersWar");
		System.out.println("Welcome to Players War!");


		PlayerStatus p1 = new PlayerStatus();

		System.out.println("Set the nickname for player 1");
		p1.initPlayer(sc.next(), 5, 50000);

		p1.setHealth(100);

		PlayerStatus p2 = new PlayerStatus();
		System.out.println("Set the nickname for player 2");
		p2.initPlayer(sc.next(), 5, 50000);

		p2.setHealth(100);
	
		
			System.out.println("Choose a weapon for "+p1.getNickname()+" between:");
			System.out.println("knife");
			System.out.println("kalashnikov");
			System.out.println("sniper");

			while(!p1.setWeaponInHand(sc.next())) {
				System.out.println("Please select a valid weapon!");

			}
			System.out.println("Choose a weapon for "+p2.getNickname()+" between:");
			System.out.println("knife");
			System.out.println("kalashnikov");
			System.out.println("sniper");

			while(!p2.setWeaponInHand(sc.next())) {
				System.out.println("Please select a valid weapon!");

		}

			System.out.println("Set the coordonates for "+p1.getNickname());
			p1.setDistance(sc.nextDouble(),sc.nextDouble());

			System.out.println("Set the coordonates for "+p2.getNickname());
			p2.setDistance(sc.nextDouble(),sc.nextDouble());

			PlayerStatus.distanceBetweenPlayers(p1.getPositionX(), p1.getPositionY(), p2.getPositionX(), p2.getPositionY());

			double distance = PlayerStatus.distanceBetweenPlayers(p1.getPositionX(), p1.getPositionY(), p2.getPositionX(), p2.getPositionY());
			int count = 1;
			
			while(p1.getLives()>0 || p2.getLives()>0 ) {

			System.out.println("After attack number "+count+":");
			++count;
			if(p1.getWeaponInHand().equals(p2.getWeaponInHand())) {
				int prob1 = p1.winningChance(p1.getHealth(), p1.getScore());
				int prob2 = p2.winningChance(p2.getHealth(), p2.getScore());
				if(prob1>prob2) {
					System.out.println(p2.getNickname()+ " is minus 25 health");
					p2.updateHealth(25);
					System.out.println(p2.getNickname()+ " has "+p2.getLives()+" lives");
				}else {
					System.out.println(p1.getNickname()+ " is minus 25 health");
					p1.updateHealth(25);
					System.out.println(p1.getNickname()+ " has "+p1.getLives()+" lives");
				}
			}else if(distance >1000){
				if(p1.getWeaponInHand().equals("sniper")&& !p2.getWeaponInHand().equals("sniper")) {
					p2.updateHealth(100);
					System.out.println(p2.getNickname()+ " is minus 100 health");
					System.out.println(p2.getNickname()+ " has "+p2.getLives()+" lives");

				}else if(p2.getWeaponInHand().equals("sniper")&& !p1.getWeaponInHand().equals("sniper")) {
					p1.updateHealth(100);
					System.out.println(p1.getNickname()+ " is minus 100 health");
					System.out.println(p1.getNickname()+ " has "+p1.getLives()+" lives");

				}
			}else if(distance <= 1000) {
				if(p1.getWeaponInHand().equals("kalashnikov")&& !p2.getWeaponInHand().equals("kalashnikov")) {
					System.out.println(p2.getNickname()+ " is minus 50 health");
					System.out.println(p2.getNickname()+ " has "+p2.getLives()+" lives");
					p2.updateHealth(50);
				}else if(p2.getWeaponInHand().equals("kalashnikov")&& !p1.getWeaponInHand().equals("kalashnikov")) {
					System.out.println(p1.getNickname()+ " is minus 50 health");
					System.out.println(p1.getNickname()+ " has "+p1.getLives()+" lives");
					p1.updateHealth(50);

				}
			}
			System.out.println(p1.getNickname()+" please insert a code for finding an artifact!");
			p1.findArtifact(sc.nextInt());

			System.out.println(p2.getNickname()+" please insert a code for finding an artifact!");
			p2.findArtifact(sc.nextInt());

			
			

		}
	}

}


