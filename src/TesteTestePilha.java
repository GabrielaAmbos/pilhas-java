
public class TesteTestePilha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Exercicios e = new Exercicios();
		String ex = "12345";
		char[] ex1 = ex.toCharArray();
		StaticStack<Character> s1 = new StaticStack<Character>(100);
		for(char c : ex1) {
			s1.push(c);
		}

		//)A + B(-C” e “(A + B)) – (C + D” 
		//“((A + B)” e “A + B(” 
		//“((A + B) – (C + D))”
			
		
		System.out.println(s1.toString() + "\n\n");
		e.invertePilha(s1);
		System.out.println(s1.toString());
		*/
		
		StaticStack<Integer> pilha = new StaticStack<Integer>(10);
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		
		StaticStack<Integer> pilha2 = new StaticStack<Integer>(10);
		pilha2.push(1);
		pilha2.push(2);
		pilha2.push(3);
		pilha2.push(4);
		
		//System.out.println(pilha.equals(pilha2) + "\n\n");
		//pilha.push(pilha2);
		//System.out.println(pilha.toString() + "\n\n");
		
		StaticStack<Integer> pilhaClonada = pilha.clone();
		pilhaClonada.clear();
		
		
		System.out.println(pilhaClonada.toString());
		
		
	}
}
