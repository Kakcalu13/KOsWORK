public class Puppy{
	public Puppy(String name){
		//This contructor has one parameter, name.
		System.out.println("Passed Name is :" + name);
	}
	public static void main(String []args){
		//following statement would create an object myPuppy
		Puppy myPuppy = new Puppy("Tommy");
	}
}