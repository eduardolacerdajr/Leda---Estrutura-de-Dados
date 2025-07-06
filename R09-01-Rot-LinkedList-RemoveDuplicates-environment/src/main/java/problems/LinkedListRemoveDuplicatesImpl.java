package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     * - A primeira ocorrencia de um elemento que tem duplicatas na lista é a que 
     *   permanece na lista.
     * - Caso o elemento tenha apenas uma ocorrencia, ela deve permanecer na lista. 
     * - A ordem dos elementos NÃO pode ser modificada. 
     * Exemplo:
     * remover as duplicatas da lista 3 -> 5 -> 1 -> 1 -> 5 -> 6 -> 5 -> NIL
     * transforma a lista em 3 -> 5 -> 1 -> 6 -> NIL
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> current = node;

        while(!current.isNIL()) {

            SingleLinkedListNode<T> aux = current.getNext();

            while(!aux.isNIL()) {

                if (current.getData().equals(aux.getData())) {
                    aux.setData(aux.getNext().getData());
                    aux.setNext(aux.getNext().getNext());
                    } else {
                        aux= aux.getNext();
                    }
                }

                current = current.getNext();
            }
        }
}

