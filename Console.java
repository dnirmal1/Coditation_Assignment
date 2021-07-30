/* 
Name :Aishwarya Vivek Gawande
Gmail:aishpatil19999@gmail.com
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

			public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
				BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
				
				char chMain;
	do {
	String str ="Welcome TO The Game Of Life"+ System.lineSeparator() +"At each step in time (tick), the following transitions occur:" + System.lineSeparator() +
		"1. Any live cell with fewer than two live neighbors dies, as if by loneliness."+ System.lineSeparator() +"2. Any live cell with more than three live neighbors dies, as if by overcrowding."+ System.lineSeparator() +
		"3. Any live cell with two or three live neighbors lives, unchanged, to the next generation."+ System.lineSeparator() +
		"4. Any dead cell with exactly three live neighbors comes to life." + System.lineSeparator() +
		"The initial pattern constitutes the 'seed' (randomly placed 500 cells) of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed — births and deaths happen simultaneously, and the discrete moment at which this happens is called a tick. (In other words, each generation is a pure function of the one before.)" ;
	
	System.out.println(str);
	
	System.out.println("Default Dish Size 100, 100, Default seed is 500(500 alive cells)  ");
	System.out.println("# shows alive state while . shows dead state ");
		
	//Dish dish= new Dish(5,5,10); //Uses 5x5 board and 10 seed , for testing purpose only
	Dish dish= new Dish();
	dish.randomSeed();
    dish.printDish();
    dish.nextGeneration();
	InputClass inputClass= new InputClass();
	char ch2;
	do {
	inputClass.inputVariable();
	dish.updateDish();
	char ch;
	do {
	
		inputClass.searchVariable();
		System.out.println("Do you want to search some other variable again (Y/N)");
		ch=br.readLine().charAt(0);
				
	}while(ch=='Y'||ch=='y');
	System.out.println("Do you want to enter input and culture the dish again? (Y)");
	ch2=br.readLine().charAt(0);
	}while(ch2=='Y'||ch2=='y');
	System.out.println("Do you want to re-run the whole program? (Y)");
	chMain=br.readLine().charAt(0);
	
	}while(chMain=='y'||chMain=='Y');
	br.close();
	System.out.println("Thanks,  Exiting ");
	
	
	

}

}