
public class Program16_1 {
	
public static void main(String[] args){
	
	TNode<Integer> root;
	
	root=buildTree16_1();
	System.out.println(inorderDisplay(root));
}
public static TNode<Integer> buildTree16_1(){
	TNode<Integer> root20=null,t45,t15,t30,t5,t10,t25,t35;
	t35=new TNode<Integer>(35);
	t25=new TNode<Integer>(25);
	t10=new TNode<Integer>(10,null,t35);
	t5=new TNode<Integer>(5);
	t30=new TNode<Integer>(30,t25,null);
	t15=new TNode<Integer>(15,t5,t10);
	t45=new TNode<Integer>(45,null,t30);
	root20=new TNode<Integer>(20,t45,t15);
	
	return root20;
}

public static <T> String inorderDisplay(TNode<T> t){
	String s="";
	if(t!=null){
		
		
		s+=inorderDisplay(t.left);
		s+=inorderDisplay(t.right);
		s+=t.nodeValue+" ";
	}
	return s;
}

//public static <T> String levelorderDisplay(TNode<T> t){
//	LinkedQueue<TNode<T>> q=new LinkedQueue<TNode<T>>();
//}
}
