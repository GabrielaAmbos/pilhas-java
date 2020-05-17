
public class Exercicios<E> {

	
	/**
	 * 3. Implemente em uma classe qualquer o seguinte método:
	 * Esse método deve percorrer a pilha p e retornar um vetor com os elementos de p sem a
	 * ocorrência do elemento number. O conteúdo original da pilha deve ser preservado
	 */
	public Integer[] itemsExcept(int number, Stack<Integer> p) {
		int tamanho = p.numElements();
		Stack<Integer> pilhaAux = new StaticStack<Integer>(p.numElements());
		int cont = 0;
		for(int i = 0; i < tamanho; i++) {
			int auxElemento = p.pop();
			if(auxElemento != number) {
				cont++;
			}
			pilhaAux.push(auxElemento);
		}
		Integer [] vetorAux = new Integer[cont];
		cont = 0;
		for(int i = 0; i < tamanho; i++) {
			int auxElemento = pilhaAux.pop();
			if(auxElemento != number) {
				vetorAux[cont] = auxElemento;
				cont++;
			}
			p.push(auxElemento);
		}
		return vetorAux;
	}
	
	/**
	 * 4. Implemente um método que recebe duas pilhas s1 e s2 e transfere os elementos da
	 *	primeira para a segunda de modo que os elementos em s2 fiquem na mesma ordem
	 *  que em s1. Dica: use uma pilha auxiliar.
	 * @param <E>
	 */
	public void transferElements(Stack<E> s1, Stack<E> s2) {
		int tamanho = s1.numElements();
		Stack<E> pilhaAux = new StaticStack<E>(s1.numElements());
		for(int i = 0; i < tamanho; i++) {
			E auxElemento = s1.pop();
			pilhaAux.push(auxElemento);
		}
		for(int i = 0; i < tamanho; i++) {
			E auxElemento = pilhaAux.pop();
			s2.push(auxElemento);
		}
	}
	
	/**
	 * 5. Implemente em uma classe qualquer o seguinte método:
	 * Esse método deve armazenar todos os elementos de p2 em p1 de maneira que eles
	 * fiquem abaixo dos elementos originais de p1, mantendo os dois conjuntos de elementos
	 * em sua ordem original. Podem ser utilizados vetores ou pilhas auxiliares.
	 */
	
	public void prependStack(Stack<Integer> p1, Stack<Integer> p2) {
		int tamanho = p1.numElements();
		Stack<Integer> pilhaAux = new StaticStack<Integer>(p1.numElements() + p2.numElements());
		for(int i = 0; i < tamanho; i++) {
			Integer auxElemento = p1.pop();
			pilhaAux.push(auxElemento);
		}
		tamanho = p2.numElements();
		for(int i = 0; i < tamanho; i++) {
			Integer auxElemento = p2.pop();
			pilhaAux.push(auxElemento);
		}
		tamanho = pilhaAux.numElements();
		for(int i = 0; i < tamanho; i++) {
			Integer auxElemento = pilhaAux.pop();
			p1.push(auxElemento);
		}
	}
	
	/**
	 * 9. Implemente um método que recebe uma pilha como parâmetro e inverte a ordem dos
	 * seus elementos. Use somente outras pilhas como estruturas auxiliares.
	 */
	public void invertePilha(Stack<E> p) {
		int tamanho = p.numElements();
		Stack<E> pilhaAuxA = new StaticStack<E>(p.numElements());
		Stack<E> pilhaAuxB = new StaticStack<E>(p.numElements());
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = p.pop();
			pilhaAuxA.push(elementoAux);
		}
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = pilhaAuxA.pop();
			pilhaAuxB.push(elementoAux);
		}
		for(int i = 0; i < tamanho; i++) {
			E elementoAux = pilhaAuxB.pop();
			p.push(elementoAux);
		}
	}
	
	
	/**
	 * 10. Escreva um algoritmo para verificar se um dado elemento está presente em uma pilha.
	 * Em caso positivo, o algoritmo deve fornecer também a posição do item na pilha,
	 * considerando a base como posição 0. A pilha deve permanecer a mesma após a
	 * execução do procedimento.
	 */
	
	public int itensContens(int number, Stack<Integer> p) {
		int tamanho = p.numElements();
		Stack<Integer> pilhaAux = new StaticStack<Integer>(p.numElements());
		int posicaoEncontrada = -1;
		for(int i = 0; i < tamanho; i++) {
			int auxElemento = p.pop();
			if(auxElemento == number) {
				posicaoEncontrada = i;
			}
			pilhaAux.push(auxElemento);
		}
		for(int i = 0; i < tamanho; i++) {
			int auxElemento = pilhaAux.pop();
			p.push(auxElemento);
		}
		return posicaoEncontrada;
	}
	
	
	/**
	 * 11. Implemente em uma classe qualquer o seguinte método:
	 * Esse método verifica se uma expressão matemática tem os parênteses agrupados de
	 * forma correta, isto é:
	 * (1) se o número de parênteses à esquerda e à direita é igual; e
	 * (2) se todo parêntese aberto é seguido, posteriormente, por um fechamento de
     * parêntese.
     * Por exemplo, as expressões “((A + B)” e “A + B(” violam a regra (1), e as expressões “)A
     * + B(-C” e “(A + B)) – (C + D” violam a regra (2). Um exemplo de expressão correta seria:
     * “((A + B) – (C + D))”.
	 * O método recebe como parâmetro uma pilha que contém os caracteres da expressão
     * matemática e retorna verdadeiro se os parênteses da expressão estão agrupados de
     * forma correta, ou falso, caso contrário. Uma pilha armazena apenas uma única
     * expressão. Utilize o método equals para a comparação dos objetos. As expressões
     * estão armazenadas na pilha da esquerda para a direita, ou seja, os caracteres da
     * esquerda são empilhados primeiro.
	 */
	
	//(a + b + a
	//a + b + a
	public boolean checkBrackets(Stack<Character> s1) {
		while (!s1.isEmpty()) {
			Character elementoAux = s1.pop();
			int tamanho = s1.numElements();
			Stack<Character> pilhaAux = new StaticStack<Character>(s1.numElements());
			if (elementoAux.equals(')')) {
				int cont = 0;
				for(int i = 0; i < tamanho; i++) {
					Character elementoEncontrado = s1.pop();
					if(!elementoEncontrado.equals('(')) {
						pilhaAux.push(elementoEncontrado);
					} else {
						cont++;
						break;
					}
				}
				if(cont == 0) {
					return false;
				}
				while (!pilhaAux.isEmpty()) {
					Character e = pilhaAux.pop();
					s1.push(e);
				}
			}
			if (elementoAux.equals('(')) {
				return false;
			}
		}
		return true;
	}
}
