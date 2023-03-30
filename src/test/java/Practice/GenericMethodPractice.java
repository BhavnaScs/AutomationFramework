package Practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
	  //not generic
	  int a = 10;
	  int b= 20;
	  int c = a+b;
	  System.out.println(c);
	  
	  //generic
	  System.out.println(genericAdd(10,90));

	}
	//generic method
	public static int genericAdd(int a, int b) {
		return a+b;
	}

}
