

import java.util.HashMap;

import javafx.util.Pair;

public class Dish {

    private final int row;

    private final int column;

    private int seedCount = 500;

    public static int [][] dish;

	public static int [][] dishBackup;
    public  int gen = 0;
    
    public boolean updateFlag=false;
   
    public Dish() {
        // TODO Auto-generated constructor stub
        this(100, 100);

    }
    
    public Dish(int i, int j) {
        // TODO Auto-generated constructor stub
        this.row = i;
        this.column = j;
        Dish.dish = new  int [row][column];
        
    }
    
    
    public Dish(int i, int j, int k) {
		// TODO Auto-generated constructor stub
    	this(i, j);
    	seedCount=k;
    	
    	
	}

	public  void printDish() {
    	if(gen==0)
    		System.out.println("Initial/Randomly Seeded Dish,Gen: "+gen );
    	else if(updateFlag) 
    		System.out.println("Input/Updated Dish Cultured,Gen: "+gen );
    	else 
    		System.out.println("Dish Cultured,Gen: "+gen );
    	
    	
    	System.out.println();
    	for(int i=0;i<row;i++)
		{
			for(int j=0;j<column;j++)
			{
			 
				if(dish[i][j]==1)
					System.out.print("#"+" ");
				else 
					System.out.print("."+" ");
			 
			}
			System.out.println();
		}
    	System.out.println();
		
	}
	


    public void nextGeneration() {
        int p = dish.length,
            q = dish[0].length;

        // Possible neighboring
        // indexes
        int u[] = {1,-1,0,1,-1,0,1,-1};
        int v[] = {0,0,-1,-1,-1, 1,1,1};
        gen++;

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                // IF the initial value
                // of the dish(i, j) is 1
                if (dish[i][j] > 0) {
                    for (int k = 0; k < 8; k++) {
                        if (isSafe(dish, i + u[k],
                                j + v[k]) &&
                            dish[i + u[k]][j + v[k]] > 0) {
                            // If initial value > 0,
                            // just increment it by 1
                            dish[i][j]++;
                        }
                    }
                }

                // IF the initial value
                // of the dish(i, j) is 0
                else {
                    for (int k = 0; k < 8; k++) {
                        if (isSafe(dish, i + u[k],
                                j + v[k]) &&
                            dish[i + u[k]][j + v[k]] > 0) {
                            // If initial value <= 0
                            // just decrement it by 1
                            dish[i][j]--;
                        }
                    }
                }
            }
        }

        // Generating new Generation.
        // Now the magnitude of the
        // dish will represent number
        // of neighbours
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                // If initial value was 1.
                if (dish[i][j] > 0) {
                    // Since Any live cell with
                    // < 2 live neighbors dies
                    if (dish[i][j] < 3)
                        dish[i][j] = 0;

                    // Since Any live cell with
                    // 2 or 3 live neighbors live
                    else if (dish[i][j] <= 4)
                        dish[i][j] = 1;

                    // Since Any live cell with
                    // > 3 live neighbors dies
                    else if (dish[i][j] > 4)
                        dish[i][j] = 0;
                } else {
                    // Since Any dead cell with
                    // exactly 3 live neighbors
                    // becomes a live cell
                    if (dish[i][j] == -3)
                        dish[i][j] = 1;
                    else
                        dish[i][j] = 0;
                }
            }
        }
    printDish();
    }
    
    public boolean isSafe(int[][] dish, int row, int col) {
        return (dish.length > row && dish[0].length > col && row >= 0 && col >= 0);
      }

    public  void randomSeed() {

        for (int i = 0; i < seedCount; i++) {

            int x = (int)(Math.random() * row);

            int y = (int)(Math.random() * column);

            dish[x][y] = 1;



        }

    }
    
    public void updateDish()
    {
    	HashMap<String , Pair<Integer,Integer>>map= InputClass.map;
    	for(String s  : map.keySet())
    	{
    		Pair<Integer,Integer> p=map.get(s);
    		int i= p.getKey();
    		int j=p.getValue();
    		dish[i][j]=1;
    		
    		
    		
    	}
    	System.out.println("The following positions(marked by *) have been set to alive as per the input ");
    	
    	for(int i=0;i<row;i++) {
    		for(int j=0;j<column;j++)
    		{	 boolean foundFlag=false;
    			for(String s  : map.keySet())
        	{
        		Pair<Integer,Integer> p=map.get(s);
        		if(new Pair<Integer,Integer>(i,j).equals(p))
        		{			foundFlag=true;
        					break;
        		}
        		
        		
        		
        	}
    			if(foundFlag)
    			System.out.print("*" +" ");
    			else 
    			{
    				if(dish[i][j]==1)
    					System.out.print("#"+" ");
    				else 
    					System.out.print("."+" ");
    			 
    			}
        		
        			
    		}
    	System.out.println();
    	}
    	updateFlag=true;
    	nextGeneration();
    	
    }
    
    public static int getDishValue(int i, int j)
    {
    	return  dish[i][j]; 
    }


}