package game;

public abstract class GameObject {
	
	private int x;
	public void blas(){
		
	}
	
	// This method must be implemented by any class that extends GameObject;
	public abstract void draw();

	public static void main(String[] args){
		
		//polymophism.
		GameObject player=new Player(); 
		player.someMethod();
		
//		GameObject myObject=new GameObject();
		
		player.draw();
		
		
		GameObject menu=new Menu();
		menu.draw();
		
		
		GameObject[] gameObject=new GameObject[2];
		gameObject[0]=player;
		gameObject[1]=menu;
		
		
		for(GameObject obj:gameObject){
			obj.draw();
		}
		
	}
	
}
