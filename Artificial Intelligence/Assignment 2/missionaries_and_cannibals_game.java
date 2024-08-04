import java.util.*;
class missionaries_and_cannibals_game{
	public static void main(String[] args) {
		System.out.println("Game Start!!!!");
		int left_missionaries = 3;
		int left_cannibals = 3;
		int right_missionaries = 0;
		int right_cannibals = 0;
		int attempts = 0;
		System.out.println("M M M C C C  | ");
		Scanner sc = new Scanner(System.in);
		try{
			while(true){
				int move_missionaries = 0;
				int move_cannibals = 0;
				while(true){
					System.out.println("Left side -----> Right Side");
					System.out.print("Enter the Number of Missionaries Travelling: ");
					move_missionaries = sc.nextInt();
					System.out.print("Enter the Number of Cannibals Travelling: ");
					move_cannibals = sc.nextInt();

					if(move_cannibals == 0 && move_missionaries == 0){
						System.out.println("Empty Travelling is Not Possible!");
					}
					else if((move_missionaries + move_cannibals <=2) && (left_missionaries-move_missionaries >=0) && (left_cannibals - move_cannibals >=0)){
						break;
					}
					else{
						System.out.println("Invalid Input!");
					}
				}

				left_missionaries -= move_missionaries;
				left_cannibals -= move_cannibals;
				right_missionaries += move_missionaries;
				right_cannibals += move_cannibals;
				attempts++;

				System.out.println();
				for(int i=0; i<left_missionaries; i++){
					System.out.print("M ");
				}
				for(int i=0; i<left_cannibals; i++){
					System.out.print("C ");
				}
				System.out.print(" |  ");
				for(int i=0; i<right_missionaries; i++){
					System.out.print("M ");
				}
				for(int i=0; i<right_cannibals; i++){
					System.out.print("C ");
				}
				System.out.println();

				if((left_cannibals > left_missionaries && left_missionaries > 0) || (right_cannibals > right_missionaries && right_missionaries > 0) ){
					System.out.println("Cannibals Eats Missionaries");
					System.out.println("Game Over! You Lost!");
					break;
				}
				if((right_missionaries + right_cannibals) == 6){
					System.out.println("You Won The Game!!! Congratulations!");
					System.out.println("Total Attemps = "+ attempts);
					break;
				}

				int return_missionaries = 0;
				int return_cannibals = 0;
				while(true){
					System.out.println("Right Side -----> Left Side river Travel");
					System.out.print("Enter the Number of Missionaries Travelling: ");
					return_missionaries = sc.nextInt();
					System.out.print("Enter the Number of Cannibals Travelling: ");
					return_cannibals = sc.nextInt();

					if(return_missionaries == 0 && return_cannibals == 0){
						System.out.println("Empty Travelling is not possible!");
					}
					else if((return_missionaries + return_cannibals <=2) && (right_missionaries - return_missionaries >=0) && (right_cannibals - return_cannibals >= 0)){
						break;
					}
					else{
						System.out.println("Invalid Input! ");
					}
				}
				left_missionaries += return_missionaries;
				left_cannibals += return_cannibals;
				right_missionaries -= return_missionaries;
				right_cannibals -= return_cannibals;
				attempts++;

				System.out.println();
				for(int i=0; i<left_missionaries; i++){
					System.out.print("M ");
				}
				for(int i=0; i<left_cannibals; i++){
					System.out.print("C ");
				}
				System.out.print(" |  ");
				for(int i=0; i<right_missionaries; i++){
					System.out.print("M ");
				}
				for(int i=0; i<right_cannibals; i++){
					System.out.print("C ");
				}
				System.out.println();
				if((left_cannibals > left_missionaries && left_missionaries > 0) || (right_cannibals > right_missionaries && right_missionaries > 0)){
					System.out.println("Game Over! Cannibals ate the Missionaries");
					break;
				}
			}

		}catch(Exception e){
			System.out.println("Invalid Input!");
		}

	}
}