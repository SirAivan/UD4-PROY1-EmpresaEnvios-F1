/**
 * Un bulto físico que forma parte de un envío.
 *
 * @Iván Álvarez Martínez
 */
public class Paquete {
    private Dimension dimension;
    private double peso;
    private double pesoVolumetrico;
    /** cm3 que equivalen a 1 kg a efectos de facturación */
    public static final double FACTOR_VOLUMETRICO = 5000;

    // TODO atributos: una Dimension y el peso real (kg)

    /**
     * Crea un paquete a partir de una dimensión ya creada y su peso real (kg).
     */
    public Paquete(Dimension dimension, double peso) {
        this.dimension = dimension;
        this.peso = peso;
    }

    /**
     * Crea un paquete a partir de sus medidas (cm) y su peso real (kg).
     * Sin duplicar el código del otro constructor.
     */
    public Paquete(double alto, double ancho, double largo, double peso) {
        this(new Dimension(alto, ancho, largo), peso);
    }

    public Dimension getDimension() {
        return dimension;
    }

    /**
     * @return el peso real en kg
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @return el volumen del paquete en cm3
     */
    public double calcularVolumen() {
        dimension.calcularVolumen();
        return dimension.calcularVolumen();
    }

    /**
     * @return el peso volumétrico en kg (volumen / FACTOR_VOLUMETRICO)
     */
    public double calcularPesoVolumetrico() {
        pesoVolumetrico = dimension.calcularVolumen() / FACTOR_VOLUMETRICO;
        return pesoVolumetrico;
    }

    /**
     * El peso facturable es el mayor entre el peso real y el volumétrico.
     *
     * @return el peso facturable en kg
     */
    public double calcularPesoFacturable() {
        double facturable = peso;
        if (pesoVolumetrico > peso){
            facturable = pesoVolumetrico;
        }
        return facturable;
    }

    /**
     * @return por ejemplo "40.0 x 30.0 x 50.0 cm | 8.0 kg (facturable 12.0 kg)"
     */
    public String toString() {
        return dimension.toString() + "|" + peso + "kg " + "(facturable " + calcularPesoFacturable() + " kg)";
    }
}
