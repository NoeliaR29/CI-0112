import java.util.ArrayList;
import java.util.Scanner;
public class JuegoBatalla {
    private ArrayList<Robot> robots;
    public JuegoBatalla() {
        this.robots = new ArrayList();
    }

    public void solicitarDatos() {
        Scanner ent = new Scanner(System.in);
        int cantRobots;
        do {
            System.out.print("Ingrese la cantidad de robots, por favor entre 1 y 10: ");
            cantRobots = ent.nextInt();
            if (cantRobots < 1 || cantRobots > 10) {
                System.out.println("Cantidad inválida, debe ser entre 1 y 10.");
            }
        } while (cantRobots < 1 || cantRobots > 10);
        
        for (int i = 0; i < cantRobots; i++) {
            System.out.print("Ingrese el nombre del robot " + (i + 1) + ": ");
            String nombre = ent.next();
            System.out.print("Ingrese los puntos de vida para el robot: " + nombre + " ,debe ser entre 50 y 100");
            int puntosVida = ent.nextInt();
            while (puntosVida < 50 || puntosVida > 100) {
                System.out.print("Valor ingresado inválido, por favor ingrese un número entre 50 y 100: ");
                puntosVida = ent.nextInt();
            }
            System.out.print("Ingrese la fuerza de ataque para el robot:  " + nombre + " , debe ser entre 10 y 20");
            int ataque = ent.nextInt();
            while (ataque < 10 || ataque > 20) {
                System.out.print("Valor inválido. Ingrese un número entre 10 y 20: ");
                ataque = ent.nextInt();
            }
            System.out.print("Ingrese la defensa (entre 0 y 10) para " + nombre + ": ");
            int defensa = ent.nextInt();
            while (defensa < 0 || defensa > 10) {
                System.out.print("Valor inválido. Ingrese un número entre 0 y 10: ");
                defensa = ent.nextInt();
            }
            robots.add(new Robot(nombre, puntosVida, ataque, defensa));
        }
        iniciarBatalla();
    }

    public void iniciarBatalla() {
             while (robots.size() > 1) {
        for (int i = 0; i < robots.size(); i++) {
            Robot atacante = robots.get(i);
            if (atacante.estaDestruido()) {
                continue;
            }
            Robot defensor;
            do {
                defensor = robots.get((int) (Math.random() * robots.size()));
            } while (atacante == defensor || defensor.estaDestruido());
    
            System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre());
            atacante.atacar(defensor);
            if (defensor.getPuntosVida() <= 0) {
                System.out.println(defensor.getNombre() + " ha sido destruido.");
                defensor.marcarDestruido();
            }
            }
        eliminar(robots);
        }
        robotGanador();
    }

    public void robotGanador() {
        if (robots.size() == 1) {
         Robot ganador = robots.get(0);
            System.out.println("El ganador del juego es: " + ganador.getNombre());
            System.out.println("Fin de la simulación :)");
        } else {
            System.out.println("no hay vivos.");
        }
    }
    
        public void eliminar(ArrayList<Robot> robots) {
        for (int i = 0; i < robots.size(); i++) {
            if (robots.get(i).estaDestruido()) {
                robots.remove(i);
                i--; 
            }
        }
    }

    public static void main(String[] args) {
        JuegoBatalla juego = new JuegoBatalla();
        juego.solicitarDatos();
    }
}
