/**
 * Un envío agrupa los paquetes que un cliente manda a un mismo destino.
 * Un envío admite como máximo tres paquetes.
 *
 * Ninguno de los métodos de esta clase escribe en pantalla.
 *
 * @Iván Álvarez Martínez
 */
public class Envio {

    // TODO constante de clase MAX_PAQUETES (ver enunciado)
    // private es la visibilidad más restrictiva posible en este caso, ya que las opciones son o public o private.
    private static final int MAX_PAQUETES = 3;

    // TODO atributos: código de seguimiento, código postal y tres paquetes
    public String codigo;
    public String codigoPostal;
    public Paquete paquete1;
    public Paquete paquete2;
    public Paquete paquete3;

    /**
     * Crea un envío sin paquetes.
     *
     * @param codigo       código de seguimiento, p.ej. "PX00000001R"
     * @param codigoPostal código postal del destino, p.ej. "36202"
     */
    public Envio(String codigo, String codigoPostal){
        this.codigo = codigo;
        this.codigoPostal = codigoPostal;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @return cuántos paquetes tiene el envío (0 a 3)
     * Para mejorar el algoritmo: Los paquetes se añaden siempre en orden, así que nunca hay huecos entre ellos.
     */
    public int getNumeroPaquetes() {
        // TODO (se calcula comprobando qué atributos d paquete son null)
        if (paquete1 == null) {
            return 0;
        }else if (paquete2 == null) {
            return 1;
        }else if (paquete3 == null){
            return 2;
        }
        else {
            return 3;
        }
    }

    /**
     * @return true si ya no se pueden añadir más paquetes
     */
    public boolean estaCompleto() {
        if (getNumeroPaquetes() == MAX_PAQUETES){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Añade un paquete al envío si no está completo.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(Paquete paquete) {
        if (!estaCompleto()) {
            if (paquete1 == null) {
                paquete1 = paquete;
            } else if (paquete2 == null) {
                paquete2 = paquete;
            } else if (paquete3 == null){
                paquete3 = paquete;
                }
            return true;
        } else{
            return false;
        }
    }

    /**
     * Crea un paquete con las medidas y peso indicados y lo añade al envío.
     *
     * @return true si se ha añadido, false si el envío estaba completo
     */
    public boolean addPaquete(double alto, double ancho, double largo, double peso){
        Paquete nuevo = new Paquete(alto, ancho, largo, peso);
        if (!estaCompleto()){
            addPaquete(nuevo);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return la suma de los pesos reales de los paquetes (kg)
     */
    public double calcularPesoReal() {
        if (paquete3 != null){
        return paquete1.getPeso() + paquete2.getPeso() + paquete3.getPeso();
        }
        else {
            return paquete1.getPeso() + paquete2.getPeso();
        }
    }

    /**
     * Suma los pesos facturables de los paquetes y redondea hacia arriba
     * al kilo entero.
     *
     * @return el peso facturable del envío (kg enteros)
     */
    public double calcularPesoFacturable() {
        if (paquete3 != null){
            return Math.ceil(paquete1.calcularPesoFacturable() + paquete2.calcularPesoFacturable() + paquete3.calcularPesoFacturable());
        } else {
            return Math.ceil(paquete1.calcularPesoFacturable() + paquete2.calcularPesoFacturable());
        }
    }

    /**
     * @return el paquete de mayor peso real; si hay empate, el que se añadió
     * antes; null si el envío no tiene paquetes
     */
    public Paquete getPaqueteMasPesado() {
        if (paquete1.getPeso() >= paquete2.getPeso() && paquete1.getPeso() >= paquete3.getPeso()) {
            return paquete1;
        } else if (paquete2.getPeso() > paquete1.getPeso() && paquete2.getPeso() >= paquete3.getPeso()) {
            return paquete2;
        } else if (paquete3.getPeso() > paquete1.getPeso() && paquete3.getPeso() > paquete2.getPeso()) {
            return paquete3;
        } else {
            return null;
        }
    }

    /**
     * @return representación textual del envío (ver enunciado)
     */
    public String toString() {
        if (paquete3 != null){
            return "Envío" + codigo + "-> CP" + codigoPostal + "(" + getNumeroPaquetes() + "paquete/s)" +
                    "\n1. " + paquete1.toString() +
                    "\n2. " + paquete2.toString() +
                    "\n3. " + paquete3.toString() +
                    "\nPeso real:" + calcularPesoReal() + "kg | Peso facturable: " + calcularPesoFacturable() + " kg";
        } else {
            return "Envío" + codigo + "-> CP" + codigoPostal + "(" + getNumeroPaquetes() + "paquete/s)" +
                    "\n1. " + paquete1.toString() +
                    "\n2. " + paquete2.toString() +
                    "\nPeso real:" + calcularPesoReal() + "kg | Peso facturable: " + calcularPesoFacturable() + " kg";
        }
    }
}
