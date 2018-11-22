import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static int[] array = {0, 5, 10, 0, 11, 14, 13, 4, 11, 8, 8, 7, 1, 4, 12, 11};	
	static List<int[]> listArrays = new ArrayList<int[]>();
	static int numberArray=0;
	static boolean flag = false;
	static int step=0;
	static int lenghtCycle;
	
	public static void  main(String[] args) {

			listArrays.add(array.clone());
			
	    		while(flag==false) {
	    			step++;
	    			newStep();
	    		}
	    		
    System.out.print("\nЧисло шагов = " + step);
    System.out.print("\nДлина цикла = " + lenghtCycle);
	}
	
	static void newStep() {//Новый шаг
		
		int index = searchIndex(array);
		int valueMax = array[index];
		array[index] = 0;

		int x = index;
		for(int i = valueMax; i!=0; i--) {
			x++;
			if(x == array.length) {
				x=0;
			}
			array[x]++;
		}
		
		addList(array);
		checkList(array);
	}
	
	static int searchIndex(int[] newArray) {//Нахождение индекса ячейки с макс. значением
		
		int indexMaxValue = 0;
		int maxValue = newArray[indexMaxValue];
		
		for(int i=1; i<newArray.length; i++) {
			if(maxValue<newArray[i]) {
				indexMaxValue=i;
				maxValue = newArray[indexMaxValue];
			}
		}
		return indexMaxValue;
	}
	
	static void addList(int[] newArray) {//Добавляем новый массив в список массивов, найденные ранее
		numberArray++;
		listArrays.add(newArray.clone());
	}
	
	static boolean checkList(int[] newArray) {//Поиск одинаковых комбинаций значений
		for(int a =0; a<numberArray; a++)
		{			
			if(Arrays.equals(listArrays.get(a), newArray)) {
				lenghtCycle=numberArray-a;
				flag =true;
			}
		}
		return flag;
	}

}
