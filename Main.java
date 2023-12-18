import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuantos nodos se agregaran?");
        int nveces = sc.nextInt();
        ArbolBinario arbol = new ArbolBinario();

        for (int i = 1; i <= nveces; i++){
            System.out.println("Escriba el valor del nodo #"+i);
            int nodo = sc.nextInt();
            arbol.insertar(nodo);
        }

        /*arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(20);
        arbol.insertar(40);
        arbol.insertar(70);
        arbol.insertar(60);
        arbol.insertar(80);*/

        System.out.println("Árbol en forma horizontal:");
        arbol.imprimirHorizontal();

        System.out.println("Escriba el valor del nodo a buscar");
        int valorBuscado = sc.nextInt();
        //int valorBuscado = 40;
        System.out.println("\nBuscar nodo con valor " + valorBuscado + ": " + arbol.buscar(valorBuscado));

        System.out.println("\nRecorrer el árbol en preorden:");
        arbol.preorden();

        System.out.println("\nRecorrer el árbol en inorden:");
        arbol.inorden();

        System.out.println("\nRecorrer el árbol en postorden:");
        arbol.postorden();

        System.out.println("\nEscriba el nodo a eliminar");
        int nodoAEliminar = sc.nextInt();
        //int nodoAEliminar = 30;
        arbol.eliminar(nodoAEliminar);
        //System.out.println("\n\nÁrbol después de eliminar el nodo con valor " + nodoAEliminar + ":");
        arbol.imprimirHorizontal();
    }
}