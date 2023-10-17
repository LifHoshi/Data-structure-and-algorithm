import java.util.*;


class bestteam {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int total = sc.nextInt();
		sc.nextLine();

		Triple[] athletics = new Triple[total];

		//ArrayList<Double> firstLegs = new ArrayList<>();
		//ArrayList<Double> restLegs = new ArrayList<>();

		for (int i = 0; i < total; i++) {

			String ath = sc.nextLine();
			String[] aths = ath.split(" ");
			String name = aths[0];
			double first_leg = Double.parseDouble(aths[1]);
			double rest_leg = Double.parseDouble(aths[2]);
			athletics[i] = new Triple(name, first_leg, rest_leg);

		//	firstLegs.add(first_leg);
		//restLegs.add(rest_leg);
		}

		Arrays.sort(athletics);
		
    /*
		for(Triple trip : athletics){
			System.out.printf("%s, %.2f, %.2f \n",trip.name, trip.leg1, trip.legrest);
		}*/
    
		double minTime = 999999;
		Triple minRunner = new Triple("temp", 0, 0);
		for(int i = 0; i< athletics.length; i++){
			double tempTime = athletics[i].leg1;

      int list = 3;
			for(int j = 0; i < athletics.length; j++){
				if(athletics[i] == athletics[j]){
					continue; 
				}
				tempTime += athletics[j].legrest;
				//System.out.println(tempTime);
				list -= 1;
        
				if(list == 0){
					break;
				}
			}

			if (tempTime < minTime){ 
				minTime = tempTime;
				minRunner = athletics[i];
			}
		}
		

		 System.out.println(minTime);
		 System.out.println(minRunner.name);
     
		 int rest_number = 3;
		 for(int i = 0; i < athletics.length; i++) {
			if(athletics[i] == minRunner){
				continue;
			}
			  System.out.println(athletics[i].name);

				rest_number -= 1;
			
			if(rest_number == 0){
				break;
			}

			}
		}

		/* 
		// Previous Thought:

		restLegs.addAll(firstLegs);
		double[] sort_restLegs = new double[restLegs.size()];

		for (int i = 0; i < restLegs.size(); i++) {
			sort_restLegs[i] = restLegs.get(i);
		}

		QuickSort.quickSort(sort_restLegs);
   /* 
		for (int i = 0; i < total * 2; i++) {
			System.out.println(sort_restLegs[i]);
		}*/
     
	  /* 
		Triple[] sort_runners = new Triple[total];

		for(int i = 0; i < 8 ; i++){
			for(int j = 0; j < total; j++){
				if(sort_restLegs[i] == athletics[j].legrest){
					sort_runners[i] = athletics[j];
				} else if(sort_restLegs[i] == athletics[j].leg1){
					if(athletics[j].name == )
				}
				}
			}
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(sort_runners[i]);
		} */

		/*
		 * for(int i = 0; i < total; i++) {
		 * Triple temp = new Triple("xxx",0,0);
		 * if(sort_restLegs[0] == athletics[i].legrest){
		 * temp = athletics[total - 1];
		 * athletics[total - 1]= athletics[i];
		 * athletics[i] = temp;
		 * 
		 * }
		 * }
		 * 
		 * 
		 * 
		 * for(int i = 0; i < total; i++) {
		 * Triple temp = new Triple("xxx",0,0);
		 * if(sort_restLegs[1] == athletics[i].legrest){
		 * temp = athletics[total - 2];
		 * athletics[total - 2]= athletics[i];
		 * athletics[i] = temp;
		 * }
		 * }
		 * 
		 * 
		 * 
		 * for(int i = 0; i < total; i++) {
		 * Triple temp = new Triple("xxx",0,0);
		 * if(sort_restLegs[2] == athletics[i].legrest){
		 * temp = athletics[total - 3];
		 * athletics[total - 3]= athletics[i];
		 * athletics[i] = temp;
		 * }
		 * }
		 * 
		 * ArrayList<Double> firstLegs = new ArrayList<>();
		 * 
		 * for(int i = 0; i < total - 3; i++) {
		 * firstLegs.add(athletics[i].leg1);
		 * }
		 * 
		 * double[] sort_firstLegs = new double[firstLegs.size()];
		 * 
		 * for(int i = 0; i < firstLegs.size(); i++){
		 * sort_firstLegs[i] = firstLegs.get(i);
		 * }
		 * QuickSort.quickSort(sort_firstLegs);
		 * 
		 * double total_time = sort_restLegs[0] + sort_restLegs[1] + sort_restLegs[2] +
		 * sort_firstLegs[0];
		 * 
		 * System.out.println(total_time);
		 * 
		 * for(int i = 0; i < firstLegs.size(); i++){
		 * if(athletics[i].leg1 == sort_firstLegs[0]) {
		 * System.out.println(athletics[i].name);
		 * }
		 * }
		 * 
		 * for(int i = total - 1; i > total - 4; i--){
		 * System.out.println(athletics[i].name);
		 * }
		 */

	

	public static class Triple implements Comparable<Triple>{
		public String name;
		public double leg1;
		public double legrest;

		public Triple(String n, double leg, double leg2) {
			name = n;
			leg1 = leg;
			legrest = leg2;
		}

		@Override
		public int compareTo(Triple next){
			if(this.legrest > next.legrest){
				return 1;
			} else if (this.legrest < next.legrest){
				return -1;
			} else {
				return 0;
			}
		}
	}


 /* Previous Thought
	public static class QuickSort {

		public static void quickSort(double[] a) {
			quickSort(a, 0, a.length - 1);
		}

		public static void quickSort(double[] a, int i, int j) {
			if (i < j) {
				int pivotIdx = partition(a, i, j);
				quickSort(a, i, pivotIdx - 1);
				quickSort(a, pivotIdx + 1, j);
			}
		}

		public static void swap(double[] a, int pos1, int pos2) {
			double temp = a[pos1];
			a[pos1] = a[pos2];
			a[pos2] = temp;
		}

		public static int partition(double[] a, int i, int j) {

			double p = a[i];
			int m = i;

			for (int k = i + 1; k <= j; k++) {
				if (a[k] < p) {
					m++;
					swap(a, k, m);
				}
			}

			swap(a, i, m);
			return m;
		}
	}
	*/
}