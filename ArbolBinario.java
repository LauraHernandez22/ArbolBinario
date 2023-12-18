class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar un nuevo nodo
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            nodo = new Nodo(valor);
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = insertarRec(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = insertarRec(nodo.derecha, valor);
        }

        return nodo;
    }

    // Imprimir el árbol en forma horizontal
    public void imprimirHorizontal() {
        imprimirHorizontalRec(raiz, 0, false, "");
    }

    private void imprimirHorizontalRec(Nodo nodo, int nivel, boolean esDerecha, String prefijo) {
        if (nodo != null) {
            imprimirHorizontalRec(nodo.derecha, nivel + 1, true, prefijo + (esDerecha ? "     " : "|    "));

            System.out.print(prefijo);
            System.out.print(esDerecha ? "┌───":"└───");
            System.out.println(nodo.valor);

            imprimirHorizontalRec(nodo.izquierda, nivel + 1, false, prefijo + (esDerecha ? "     " : "|    "));
        }
    }
    /*public void imprimirHorizontal() {
        imprimirHorizontalRec(raiz, 0);
    }

    private void imprimirHorizontalRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirHorizontalRec(nodo.derecha, nivel + 1);

            for (int i = 0; i < nivel; i++) {
                System.out.print("   ");
            }

            System.out.println(nodo.valor);

            imprimirHorizontalRec(nodo.izquierda, nivel + 1);
        }
    }*/

    // Buscar un nodo
    public String buscar(int valor) {
        return buscarRec(raiz, valor) ? "El valor se encontro en el arbol":"No se encontro el valor en el arbol";
    }

    /*public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }*/

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return false;
        }

        if (valor == nodo.valor) {
            return true;
        } else if (valor < nodo.valor) {
            return buscarRec(nodo.izquierda, valor);
        } else {
            return buscarRec(nodo.derecha, valor);
        }
    }

    // Recorrer el árbol en preorden
    public void preorden() {
        preordenRec(raiz);
    }

    private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preordenRec(nodo.izquierda);
            preordenRec(nodo.derecha);
        }
    }

    // Recorrer el árbol en inorden
    public void inorden() {
        inordenRec(raiz);
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierda);
            System.out.print(nodo.valor + " ");
            inordenRec(nodo.derecha);
        }
    }

    // Recorrer el árbol en postorden
    public void postorden() {
        postordenRec(raiz);
    }

    private void postordenRec(Nodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierda);
            postordenRec(nodo.derecha);
            System.out.print(nodo.valor + " ");
        }
    }

    // Eliminar un nodo
    public void eliminar(int valor) {
        if(buscar(valor).equals("El valor se encontro en el arbol")) {
            raiz = eliminarRec(raiz, valor);
            System.out.println("\nÁrbol después de eliminar el nodo con valor " + valor + ":");
        }else{
            System.out.println("No se encontro el valor en el arbol");
        }
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.valor) {
            nodo.izquierda = eliminarRec(nodo.izquierda, valor);
        } else if (valor > nodo.valor) {
            nodo.derecha = eliminarRec(nodo.derecha, valor);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            }

            nodo.valor = encontrarMinimoValor(nodo.derecha);

            nodo.derecha = eliminarRec(nodo.derecha, nodo.valor);
        }

        return nodo;
    }

    private int encontrarMinimoValor(Nodo nodo) {
        int min = nodo.valor;
        while (nodo.izquierda != null) {
            min = nodo.izquierda.valor;
            nodo = nodo.izquierda;
        }
        return min;
    }
}