import java.util.Random;
public class Robot {
    private String nombre; private int puntosVida; private int ataque; private int defensa;private boolean destruido;
    public Robot(String nombre, int puntosVida, int ataque, int defensa) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.destruido = false;
    }

    public void atacar(Robot otroRobot) {
        int daño = this.ataque - otroRobot.getDefensa(); 
        if (daño > 0) {
            otroRobot.reducirVida(daño);
            System.out.println(this.nombre + " le bajó " + daño + " puntos de vida a: "+ otroRobot.nombre +".");
            System.out.println(otroRobot.getNombre() + " ahora tiene " + otroRobot.getPuntosVida() + " puntos de vida.");
            System.out.println("------------------");
        } else {
            System.out.println(this.nombre + " no pudo dañar a " + otroRobot.getNombre());
        }
    }
    
    public void reducirVida(int daño) {
        this.puntosVida -= daño;
        if (this.puntosVida < 0) {
            this.puntosVida = 0;
        }
    }

    public boolean estaVivo() {
        return this.puntosVida > 0;
    }

    public int getPuntosVida() {
        return puntosVida;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getDefensa() {
        return defensa;
    }

    public String toString() {
        return "Robot: " + nombre + " , Vida: " + puntosVida + " , Ataque: " + ataque + " , Defensa: " + defensa;
    }
    
    public boolean estaDestruido() {
        return destruido;
    }

    public void marcarDestruido() {
        this.destruido = true;
    }
}