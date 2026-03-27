public class EjemploHilos extends Thread {

    public EjemploHilos(String nombre) {
        super(nombre);
    }

    @Override
    public void run() {
        for (int i = 1; i < 5; i++) {
            System.out.println(i + " - " + getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Error en el hilo");
            }
        }
    }

    public static void main(String[] args) {
        EjemploHilos hilo1 = new EjemploHilos("Hilo 1");
        EjemploHilos hilo2 = new EjemploHilos("Hilo 2");
        hilo1.start();
        hilo2.start();
    }
}  