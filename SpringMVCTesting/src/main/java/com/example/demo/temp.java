package com.example.demo;


import java.util.Scanner;
import java.util.ArrayList;

class temp {

	public void chnage(){

		System.out.println("prakhar chnages;;;");

	}

	/* static  int queries;
    static  int K;
    static  String A[];
    static Scanner sc;

    public static void QueryResult(ArrayList<Integer>sequence,int first_index,int q){
    	sequence.addAll(sequence);
        for(int i=first_index;i<sequence.size();i++){
        	int temp=((sequence.get(i)% 1000000007) + (Integer.parseInt(A[(i %  K)]))% 1000000007)% 1000000007;
        	sequence.set(i, temp);
        }
        if(q<sequence.size()){
           System.out.println(sequence.get(q));
           queries--;
           if(queries==0)
      		 return;
           else{
        	   q=Integer.parseInt(sc.nextLine());
        	   QueryResult(sequence,sequence.size(),q);
           }
        }else
        	QueryResult(sequence,sequence.size(),q);
    }*/

	public static long decimalNumberLength(long number){

		long   count = 0; 
		do{
			System.out.print((number % 2)+" ");
			number = number/2;        	
			count++;
		}while(!(number == 0 ) );

		System.out.println("count is : "+count++);
		return ++count;
	}


	public static void main(String args[] ) throws Exception {
		decimalNumberLength(10);

		double totalSizeMB = ((Runtime.getRuntime().totalMemory()/1024)/1024);
		double freeInMB = ((Runtime.getRuntime().freeMemory()/1024 )/1024);
		double maxInMB = ((Runtime.getRuntime().maxMemory()/1024 )/1024);

		System.out.println("total memory in heap " +totalSizeMB+ "MB     :   "+(totalSizeMB /1024)+" in GB" );

		System.out.println("max memory in heap " +maxInMB+ "MB     :   "+(maxInMB /1024)+" in GB" );

		System.out.println("avalable apace in heap " +((Runtime.getRuntime().freeMemory()/1024 )/1024)+" MB      :   "+(((Runtime.getRuntime().freeMemory()/1024 )/1024) /1024)+" in GB"  );

		System.out.println("After memory allocation................");
		//    String sss = new String("111111111111111111111111111111111111111111111111111111111111111");

		//    System.out.println(sss.length());

		// 117mb = 122683392
		StringBuilder s=null;

		//long number = 682622976;

		//String str = new String( "");

		try{

			s = 	new StringBuilder((122683392 *5 ) +70000000);

		}catch(Exception e){
			System.out.println("exception e : "+e);
		}
		//StringBuilder s = 	new StringBuilder(671772725);

		// 	StringBuilder s1 = 	new StringBuilder(134354545);
		System.out.println("avalable space in heap " +((Runtime.getRuntime().freeMemory()/1024 )/1024)+" MB      :   "+(((Runtime.getRuntime().freeMemory()/1024 )/1024) /1024)+" in GB"  );

		System.out.println("size is  : "+  ((s.capacity()/1024 )/1024));
		//	System.out.println("size is  : "+s1.capacity());


		//	1343545451
		// 	1.251274209  GB

		/*
        sc = new Scanner(System.in);
        ArrayList<Integer>sequence=new ArrayList<Integer>();
        K = Integer.parseInt(sc.nextLine());


        A=sc.nextLine().split(" ");
        queries=Integer.parseInt(sc.nextLine());
        if(queries <=0)
        	 System.exit(0);
        sequence.add(1);
       int q=Integer.parseInt(sc.nextLine());
       QueryResult(sequence, sequence.size(),q);*/
	}
}