


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javafx.util.Pair;

public class InputClass {

	private int variables;
	
	public static  HashMap<String, Pair<Integer, Integer>>map;
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	public HashMap<String, Pair<Integer, Integer>> getMap() {
		return map;
	}

	
	public InputClass() throws NumberFormatException, IOException
		{
		InputClass.map=new  HashMap<String, Pair<Integer,Integer>>();	
		
		
		
		}

	public void inputVariable() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("Enter the number of variables to be added max 100");
		
		this.variables=Integer.parseInt(br.readLine());
		if(variables>100)
			{System.out.println("Pls enter value under 100 else program will exit ");
			
			this.variables=Integer.parseInt(br.readLine());
			if(variables>=100)
			{
				System.out.println("Sorry ,Exiting");
				System.exit(0);
			}
			}
		for(int i=0;i<variables;i++)
		{
			System.out.println("Input Variable: "+(i+1)+" in the format (Name Xcoordinate Ycoordinate)");
			String str[]= br.readLine().split(" ");
			map.put(str[0],new Pair<Integer, Integer>(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
			
			
					
		}
		
		
		
		
	}
	public void searchVariable() throws IOException
	{
		System.out.println("Following is the list of varibles previously entered and set to alive state (Name Xcoord Ycoord)");
		int count=0;
		for(String s :map.keySet())
		{
			System.out.println(++count+ " "+s+" dish["+map.get(s).getKey()+"]["+map.get(s).getValue()+"]");
			
		}
		System.out.println("Enter Variable to search (Name only)");
		String searchString= br.readLine();
			if(map.containsKey(searchString))
			{
				System.out.println("Variable found, Previous Value: 1, New Value: "+Dish.getDishValue(map.get(searchString).getKey(),map.get(searchString).getKey()));
			}
			else 
			{
				System.out.println("Variable not found");
			}
		
		
	}
	
}
